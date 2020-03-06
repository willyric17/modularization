package com.mokapos.modularization.network.response

import com.google.gson.annotations.SerializedName

data class UserSearchResponse(
    @SerializedName("total_count")
    val totalCount: Int,
    @SerializedName("incomplete_results")
    val incomplete: Boolean,
    @SerializedName("items")
    val users: List<User>
)

data class User(
    @SerializedName("id")
    val id: Int,
    @SerializedName("login")
    val login: String,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("avatar_url")
    val avatarUrl: String? = null
)