package com.mokapos.modularization.customer.usecase

import com.mokapos.modularization.customer.model.CustomerEntity
import com.mokapos.modularization.customer.repository.UserRepository

interface CustomerUsecase {
    fun getAllUser(): List<CustomerEntity>

    fun getFirstUser(): CustomerEntity
}

class CustomerUsecaseImpl(private val userRepository: UserRepository) : CustomerUsecase {
    override fun getAllUser(): List<CustomerEntity> {
        return userRepository.getUser()
    }

    override fun getFirstUser(): CustomerEntity {
        return userRepository.getUser()[0]
    }
}