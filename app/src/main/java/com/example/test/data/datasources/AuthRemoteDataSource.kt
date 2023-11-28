package com.example.test.data.datasources

import com.example.test.domain.models.Login
import com.example.test.domain.models.Payments
import com.example.test.domain.models.TokenSuccess

interface AuthRemoteDataSource {
    suspend fun login(login: Login): TokenSuccess

    suspend fun getPayments(token: String): Payments
}