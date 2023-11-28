package com.example.test.domain.usecase

import com.example.test.domain.models.Login
import com.example.test.domain.models.NetworkState
import com.example.test.domain.models.TokenSuccess
import com.example.test.domain.repository.AuthRepository
import javax.inject.Inject

class AuthUseCase @Inject constructor(private val repository: AuthRepository) {

    suspend operator fun invoke(login: String, password: String): NetworkState<TokenSuccess> {
        return repository.login(Login(login = login, password = password))
    }
}