package com.example.test.domain.usecase

import com.example.test.domain.models.network.NetworkState
import com.example.test.domain.models.pay.Payments
import com.example.test.domain.repository.AuthRepository
import javax.inject.Inject

class GetPaymentsUseCase @Inject constructor(private val repository: AuthRepository) {

    suspend operator fun invoke(token: String): NetworkState<Payments> {
        return repository.getPayments(token)
    }
}