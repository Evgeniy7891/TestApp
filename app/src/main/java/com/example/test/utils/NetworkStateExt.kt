package com.example.test.utils

import com.example.test.domain.models.network.NetworkState

inline fun <T> NetworkState<T>.applyIfSuccess(block: (T) -> Unit) =
    this.also {
        if (it is NetworkState.Success) {
            block.invoke(it.success)
        }
    }

inline fun <T> NetworkState<T>.applyIfError(block: (String) -> Unit) =
    this.also {
        if (it is NetworkState.Error) {
            block.invoke(it.throwable)
        }
    }

inline fun <T> NetworkState<T>.toSuccessful(predicate: (T) -> Boolean) =
    this.let {
        when (it) {
            is NetworkState.Success -> NetworkState.Success(predicate.invoke(it.success))
            is NetworkState.Error -> NetworkState.Error(it.throwable)
            is NetworkState.Loading -> NetworkState.Loading()
        }
    }