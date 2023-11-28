package com.example.test.data.repository

import com.example.test.data.datasources.AuthRemoteDataSource
import com.example.test.di.IoDispatcher
import com.example.test.domain.models.auth.Login
import com.example.test.domain.models.network.NetworkState
import com.example.test.domain.models.pay.Payments
import com.example.test.domain.models.auth.TokenSuccess
import com.example.test.domain.repository.AuthRepository
import com.example.test.utils.safeApiCall
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val remoteDataSource: AuthRemoteDataSource
) : AuthRepository {
    override suspend fun login(login: Login): NetworkState<TokenSuccess> {
        return safeApiCall(dispatcher){
            remoteDataSource.login(login)
        }
    }
    override suspend fun getPayments(token: String): NetworkState<Payments> {
        return safeApiCall(dispatcher) {
            remoteDataSource.getPayments(token)
        }
    }
}