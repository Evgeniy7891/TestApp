package com.example.test.domain.usecase

import com.example.test.domain.models.NetworkState
import com.example.test.domain.models.Payments
import com.example.test.domain.repository.AuthRepository
import javax.inject.Inject

class GetPaymentsUseCase @Inject constructor(private val repository: AuthRepository) {

    suspend operator fun invoke(token: String): NetworkState<Payments> {
        return repository.getPayments(token)
    }
}