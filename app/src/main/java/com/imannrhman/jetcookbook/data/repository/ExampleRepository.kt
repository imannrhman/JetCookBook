package com.imannrhman.jetcookbook.data.repository

import com.imannrhman.jetcookbook.data.dao.ExampleDao
import com.imannrhman.jetcookbook.data.remote.AppApi
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ExampleRepository @Inject constructor(private val appApi: AppApi, private val exampleDao: ExampleDao)