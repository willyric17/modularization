package com.mokapos.modularization.customer.repository

import com.mokapos.modularization.customer.model.CustomerEntity
import com.mokapos.modularization.network.service.GithubService
import com.mokapos.modularization.common.executeOrError
import com.mokapos.modularization.network.response.UserSearchResponse

interface UserRepository {
    fun getUser(): List<CustomerEntity>
}

class CustomerRepositoryImpl(private val githubService: GithubService) : UserRepository {
    override fun getUser(): List<CustomerEntity> {
        return githubService.searchUser("a", 1)
            .executeOrError<UserSearchResponse>().users
            .map { user ->
                CustomerEntity(user.login, user.url ?: "")
            }
    }
}