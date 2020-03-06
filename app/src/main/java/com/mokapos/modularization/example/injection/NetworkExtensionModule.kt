package com.mokapos.modularization.example.injection

import com.mokapos.modularization.logger.Logger
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
class NetworkExtensionModule {
    @Provides
    @Singleton
    fun provideInterceptors(): List<Interceptor> {
        return listOf(
            HttpLoggingInterceptor {
                Logger.d("OkHttp", it)
            }.apply {
                level = HttpLoggingInterceptor.Level.BASIC
            },
            Interceptor { chain ->
                Logger.i("OkHttp", "execute ${chain.request().url().uri()}")
                chain.call().execute()
            }
        )
    }
}