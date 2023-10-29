package com.imannrhman.jetcookbook.core.model

import com.google.gson.annotations.SerializedName

data class  ApiModel<T>(
    @SerializedName("categories")
    val categories: T? = null,

    @SerializedName("meals")
    val meals: T? = null,
)
