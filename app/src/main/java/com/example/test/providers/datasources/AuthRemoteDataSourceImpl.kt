package com.example.test.providers.datasources

import com.example.test.data.datasources.AuthRemoteDataSource
import com.example.test.domain.models.Login
import com.example.test.domain.models.Payments
import com.example.test.domain.models.TokenSuccess
import com.example.test.providers.network.NetworkService
import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor(
    private val apiService: NetworkService
): AuthRemoteDataSource {
    override suspend fun login(login: Login): TokenSuccess {
        return apiService.login(login)
    }

    override suspend fun getPayments(token: String): Payments {
        return apiService.getPaymentsList(token)
    }
}