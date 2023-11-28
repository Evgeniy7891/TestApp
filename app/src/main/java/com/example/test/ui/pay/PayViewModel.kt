package com.example.test.ui.pay

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.test.domain.models.network.NetworkState
import com.example.test.domain.models.pay.ResponsePayment
import com.example.test.domain.usecase.GetPaymentsUseCase
import com.example.test.providers.local.PreferencesProvider
import com.example.test.utils.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PayViewModel@Inject constructor(
    private val preferencesProvider: PreferencesProvider,
    private val getPaymentsUseCase: GetPaymentsUseCase
) : BaseViewModel() {

    private val _pay = MutableLiveData<List<ResponsePayment>>()
    val pay: MutableLiveData<List<ResponsePayment>>
        get() = _pay


    init {
        viewModelScope.launch {
            val token = preferencesProvider.getToken()
            when (val response = token?.let { getPaymentsUseCase.invoke(it) }) {
                is NetworkState.Error -> {
                    _errorMessage.emit(response.throwable)
                }
                is NetworkState.Loading -> _isLoading.emit(true)
                is NetworkState.Success -> {
                    _pay.value = response.success.response
                }
                else -> {_errorMessage.emit("Error")}
            }
        }
    }

    fun logOut() {
        preferencesProvider.delete()
    }
}