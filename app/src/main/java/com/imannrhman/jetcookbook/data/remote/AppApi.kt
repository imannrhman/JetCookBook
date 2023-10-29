package com.imannrhman.jetcookbook.data.remote

import com.imannrhman.jetcookbook.data.model.ExampleModel
import com.imannrhman.jetcookbook.data.model.MealCategory
import retrofit2.Response
import retrofit2.http.*

interface AppApi {

    @GET("/api/v1/example")
    suspend fun getExampleResult(): Response<List<ExampleModel>>


}