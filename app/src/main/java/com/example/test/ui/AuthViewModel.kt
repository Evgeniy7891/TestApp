package com.example.test.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.domain.models.NetworkState
import com.example.test.domain.usecase.AuthUseCase
import com.example.test.domain.usecase.GetPaymentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel@Inject constructor(
    private val authUseCase: AuthUseCase,
    private val getPaymentsUseCase: GetPaymentsUseCase
) : ViewModel() {

    init {
        viewModelScope.launch {
            when(val response = authUseCase.invoke("demo", "12345")){
                is NetworkState.Error -> println("ERROR")
                is NetworkState.Loading -> true
                is NetworkState.Success -> {
                    println("SUCCES ${response.success.response.token}")
                    when(val responseTwo = getPaymentsUseCase.invoke(response.success.response.token)) {
                        is NetworkState.Error -> println("ERROR TWO")
                        is NetworkState.Loading -> true
                        is NetworkState.Success -> println("SUCCES LIST ${responseTwo.success}")
                    }
                }
            }
        }
    }
}