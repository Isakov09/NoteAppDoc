package com.example.noteappdoc.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.noteappdoc.data.models.NoteModels
@Dao
interface NoteDao {

    @Query("SELECT * FROM noteModel")
    fun getAll(): LiveData<List<NoteModels>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(noteModels: NoteModels)

    @Delete
    fun deleteNote(noteModels: NoteModels)

    @Update
    fun updateNote(noteModels: NoteModels)

    @Query("SELECT * FROM noteModel WHERE id = :id")
    fun getNoteById(id: Int):NoteModels?
}