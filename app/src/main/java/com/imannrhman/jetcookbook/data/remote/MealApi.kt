package com.imannrhman.jetcookbook.data.remote

import com.imannrhman.jetcookbook.core.model.ApiModel
import com.imannrhman.jetcookbook.data.model.MealCategory
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApi {

    @GET("/api/json/v1/1/categories.php")
    suspend fun getCategoriesRecipes(): ApiModel<List<MealCategory>>


    @GET("/api/json/v1/1/filter.php?c=")
    suspend fun getMealByCategory(@Query("c") category: String): ApiModel<List<MealCategory>>

}