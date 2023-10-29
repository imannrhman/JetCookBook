package com.imannrhman.jetcookbook.data.repository


import com.imannrhman.jetcookbook.core.flow.DataState
import com.imannrhman.jetcookbook.core.flow.errorState
import com.imannrhman.jetcookbook.core.flow.finishState
import com.imannrhman.jetcookbook.core.flow.loadingState
import com.imannrhman.jetcookbook.core.flow.successState
import com.imannrhman.jetcookbook.data.model.MealCategory
import com.imannrhman.jetcookbook.data.remote.MealApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MealRepository @Inject constructor(private val mealApi: MealApi) {

    suspend fun getMealCategories() : Flow<DataState<List<MealCategory>>> {
        return flow {
          try {
              emit(loadingState())

              val payload = mealApi.getCategoriesRecipes()
              emit(successState(payload.categories))

          } catch (e:Exception) {
              emit(errorState(e.message ?: "Failed Get Data"))
          }

        }
    }

}