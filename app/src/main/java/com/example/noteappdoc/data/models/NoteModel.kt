package com.example.noteappdoc.data.models

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "noteModel")
data class NoteModels(
    val title: String,
    val description: String,
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0)
