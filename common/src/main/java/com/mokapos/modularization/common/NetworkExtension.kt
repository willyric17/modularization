package com.mokapos.modularization.common

import retrofit2.Call

inline fun <reified T> Call<T>.executeOrError(): T {
    execute().let {
        if (it.isSuccessful) {
            return it.body()!!
        }

        throw java.lang.RuntimeException("Failed to connect server")
    }
}