package com.example.test.data.repository

import com.example.test.data.datasources.AuthRemoteDataSource
import com.example.test.di.IoDispatcher
import com.example.test.domain.models.Login
import com.example.test.domain.models.NetworkState
import com.example.test.domain.models.Payments
import com.example.test.domain.models.TokenSuccess
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