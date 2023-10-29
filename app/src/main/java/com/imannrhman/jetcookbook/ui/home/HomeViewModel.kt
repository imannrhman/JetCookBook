package com.imannrhman.jetcookbook.ui.home

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imannrhman.jetcookbook.core.flow.DataState
import com.imannrhman.jetcookbook.data.model.MealCategory
import com.imannrhman.jetcookbook.data.repository.ExampleRepository
import com.imannrhman.jetcookbook.data.repository.MealRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val mealRepository: MealRepository) : ViewModel() {
    private val TAG = HomeViewModel::class.java.simpleName

    val mealCategories = mutableStateOf<List<MealCategory>?>(emptyList())

    init {
        getMealCategories()
    }

    private fun getMealCategories() {
        viewModelScope.launch {
            mealRepository.getMealCategories().collect { response ->
                if (response is DataState.Success) mealCategories.value =
                    response.data?.dropLastWhile { it.categoryName in arrayOf("Breakfast", "Goat") }
                        ?.toList() ?: emptyList()
            }
        }
    }


}