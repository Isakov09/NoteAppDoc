package com.example.noteappdoc.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.noteappdoc.data.db.daos.NoteDao
import com.example.noteappdoc.data.models.NoteModels

@Database(entities = [NoteModels::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao() : NoteDao
}
