package com.vaishnav.pratilipiproject.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "content_table")
data class Content (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val text: String?,
    val timeStamp : Long
 )