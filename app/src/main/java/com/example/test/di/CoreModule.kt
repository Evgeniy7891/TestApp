package com.example.test.di

import com.example.test.data.datasources.AuthRemoteDataSource
import com.example.test.data.repository.AuthRepositoryImpl
import com.example.test.domain.repository.AuthRepository
import com.example.test.providers.datasources.AuthRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CoreModule {
    @Binds
    abstract fun bindAuthRemoteDataSource(impl: AuthRemoteDataSourceImpl): AuthRemoteDataSource
    @Binds
    abstract fun bindAuthRepository(impl: AuthRepositoryImpl): AuthRepository
}