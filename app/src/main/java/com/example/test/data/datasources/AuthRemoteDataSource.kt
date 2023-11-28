package com.example.test.data.datasources

import com.example.test.domain.models.auth.Login
import com.example.test.domain.models.pay.Payments
import com.example.test.domain.models.auth.TokenSuccess

interface AuthRemoteDataSource {
    suspend fun login(login: Login): TokenSuccess
    suspend fun getPayments(token: String): Payments
}