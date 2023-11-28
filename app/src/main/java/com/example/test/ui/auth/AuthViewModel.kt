package com.example.test.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.test.domain.usecase.AuthUseCase
import com.example.test.domain.usecase.GetPaymentsUseCase
import com.example.test.providers.local.PreferencesProvider
import com.example.test.utils.BaseViewModel
import com.example.test.utils.applyIfError
import com.example.test.utils.applyIfSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel@Inject constructor(
    private val authUseCase: AuthUseCase,
    private val preferencesProvider: PreferencesProvider,
) : BaseViewModel() {

    private val _entrance = MutableLiveData<Boolean>()
    val entrance: LiveData<Boolean>
        get() = _entrance

    init {
        val enter = preferencesProvider.getToken()
        if(enter != null){
            println("TOKEN- $enter")
            if(enter.isNotEmpty())
                _entrance.value = true
        }
    }

    fun tryLogin(login: String, password: String) {
        viewModelScope.launch {
            authUseCase.invoke(login, password)
                .applyIfError { _errorMessage.emit("ОШИБКА ПРИ ЗАПРОСЕ $it")
                    _entrance.value = false
                }
                .applyIfSuccess {
                    if (it.success == "true") {
                        println("УДАЧНАЯ ПОПЫТКА")
                        _entrance.value = true
                        preferencesProvider.saveToken(it.response.token)
                    } else {
                        _errorMessage.emit("НЕ УДАЛОСЬ ВЫПОЛНИТЬ ЗАПРОС")
                        _entrance.value = false
                    }
                }
        }
    }
}