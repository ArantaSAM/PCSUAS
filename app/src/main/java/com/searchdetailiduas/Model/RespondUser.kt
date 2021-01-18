package com.searchdetailiduas.Model

import com.google.gson.annotations.SerializedName

data class RespondUser(
    @SerializedName("items")
    val items : ArrayList<User>
)
