package com.example.test.domain.models


data class ResponsePayment(
    val id: Int? = 0,
    val title: String? = "",
    val amount: Any?,
    val created: Int? = 0,
)