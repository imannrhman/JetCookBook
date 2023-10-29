package com.imannrhman.jetcookbook.core.flow

/**
 * Created by Kudzoza
 * on 07/07/2022
 **/

sealed class DataState<out T> {
    class Success<T>(val data: T?) : DataState<T>()
    class Error(
        val message: String,
        val exception: Exception? = null,
    ) : DataState<Nothing>()

    object Loading : DataState<Nothing>()
    object Finish : DataState<Nothing>()
}