package com.vaishnav.pratilipiproject.data.local

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vaishnav.pratilipiproject.data.model.Content

interface ContentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addContent(content: Content)

    @Query("SELECT * FROM content_table ORDER BY timeStamp DESC")
    fun getAllContent(): LiveData<List<Content>>

}