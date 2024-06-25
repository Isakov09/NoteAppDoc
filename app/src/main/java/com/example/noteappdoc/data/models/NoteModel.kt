package com.example.noteappdoc.data.models

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "noteModel")
data class NoteModels(
    val title: String,
    val description: String,
    val color: String,
    val data: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0)
