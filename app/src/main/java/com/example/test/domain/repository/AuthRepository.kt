package com.example.test.domain.repository

import com.example.test.domain.models.Login
import com.example.test.domain.models.NetworkState
import com.example.test.domain.models.Payments
import com.example.test.domain.models.TokenSuccess

interface AuthRepository {
    suspend fun login(login: Login): NetworkState<TokenSuccess>
    suspend fun getPayments(token: String): NetworkState<Payments>
}