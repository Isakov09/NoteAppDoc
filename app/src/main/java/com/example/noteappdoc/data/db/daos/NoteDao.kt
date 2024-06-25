package com.example.noteappdoc.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.noteappdoc.data.models.NoteModels
@Dao
interface NoteDao {

    @Query("SELECT * FROM noteModel")
    fun getAll(): LiveData<List<NoteModels>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(noteModels: NoteModels)
}