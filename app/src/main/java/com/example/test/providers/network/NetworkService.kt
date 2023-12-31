package com.example.test.providers.network

import com.example.test.domain.models.auth.Login
import com.example.test.domain.models.pay.Payments
import com.example.test.domain.models.auth.TokenSuccess
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface NetworkService {

    @POST("login")
    suspend fun login(
        @Body login: Login
    ): TokenSuccess

    @GET("payments")
    suspend fun getPaymentsList(@Header("token") token: String) : Payments

}