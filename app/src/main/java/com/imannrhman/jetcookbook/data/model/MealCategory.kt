package com.imannrhman.jetcookbook.data.model

import com.google.gson.annotations.SerializedName

data class MealCategory (

    @SerializedName("idCategory")
    val categoryId: String,

    @SerializedName("strCategory")
    val categoryName: String,

    @SerializedName("strCategoryThumb")
    val categoryThumb: String,

    @SerializedName("strCategoryDescription")
    val categoryDescription: String
)
