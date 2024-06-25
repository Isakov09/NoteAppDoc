package com.example.noteappdoc.interfaces

import com.example.noteappdoc.data.models.NoteModels

interface OnClickItem {
    fun  onLongClick(noteModels: NoteModels )
    fun onClick(noteModels: NoteModels)

}