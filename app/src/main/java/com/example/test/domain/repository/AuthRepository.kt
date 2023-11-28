package com.example.test.domain.repository

import com.example.test.domain.models.auth.Login
import com.example.test.domain.models.network.NetworkState
import com.example.test.domain.models.pay.Payments
import com.example.test.domain.models.auth.TokenSuccess

interface AuthRepository {
    suspend fun login(login: Login): NetworkState<TokenSuccess>
    suspend fun getPayments(token: String): NetworkState<Payments>
}