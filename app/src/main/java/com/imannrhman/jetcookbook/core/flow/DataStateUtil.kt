package com.imannrhman.jetcookbook.core.flow

/**
 * Created by Kudzoza
 * on 18/07/2022
 **/

fun loadingState() = DataState.Loading

fun <T> successState(data: T? = null) = DataState.Success(data)

fun errorState(message: String = "Sistem gagal memproses, silakan coba kembali nanti") =
    DataState.Error(message)

fun finishState() = DataState.Finish
