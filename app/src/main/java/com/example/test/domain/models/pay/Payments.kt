package com.example.test.domain.models.pay

import com.google.gson.annotations.SerializedName


data class Payments(
    @SerializedName("success") val success: String,
    @SerializedName("response") val response: List<ResponsePayment>,
)