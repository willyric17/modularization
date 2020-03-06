package com.mokapos.modularization.customer.module

import com.mokapos.modularization.customer.repository.UserRepository
import com.mokapos.modularization.customer.repository.CustomerRepositoryImpl
import com.mokapos.modularization.customer.usecase.CustomerUsecase
import com.mokapos.modularization.customer.usecase.CustomerUsecaseImpl
import com.mokapos.modularization.network.module.NetworkModule
import com.mokapos.modularization.network.service.GithubService
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class CustomerModule {

    @Provides
    @Reusable
    fun provideCustomerRepository(githubService: GithubService): UserRepository {
        return CustomerRepositoryImpl(githubService)
    }

    @Provides
    @Reusable
    fun provideCustomerUsecase(userRepository: UserRepository): CustomerUsecase {
        return CustomerUsecaseImpl(userRepository)
    }
}