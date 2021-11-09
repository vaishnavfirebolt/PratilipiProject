package com.vaishnav.pratilipiproject.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.vaishnav.pratilipiproject.data.local.ContentDao
import com.vaishnav.pratilipiproject.data.local.ContentDatabase
import com.vaishnav.pratilipiproject.data.model.Content

class MainRepository (
    private val contentDao: ContentDao
){

    suspend fun addContent(content: Content) = contentDao.addContent(content)

    fun getContent(): LiveData<List<Content>> = contentDao.getAllContent()
}