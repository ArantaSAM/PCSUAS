package com.searchdetailiduas.Model

data class DetailUserRespond(
    val login: String,
    val id: Int,
    val avatar_url: String,
    val name: String,
    val followers: Int,
    val following: Int
)