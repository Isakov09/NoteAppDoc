package com.example.noteappdoc.ui.fragments.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.noteappdoc.App
import com.example.noteappdoc.data.models.NoteModels
import com.example.noteappdoc.databinding.FragmentNoteDetailBinding

class NoteDetailFragment : Fragment() {

    private var _binding: FragmentNoteDetailBinding? = null
    private val binding: FragmentNoteDetailBinding get() = _binding!!
    private var noteId: Int = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        upDate()
        setupListeners()
    }

    private fun upDate() {
        arguments?.let {
            noteId = it.getInt("noteId", -1)
        }
        if (noteId != -1) {
            val argsNote = App().getInstance()?.noteDao()?.getNoteById(noteId)
            argsNote?.let { model ->
                binding.etAdd.setText(model.title)
                binding.etTitle.setText(model.description)
            }
        }

    }

    private fun setupListeners() {
        binding.btnAddBlack.setOnClickListener {
            val etTittle = binding.etAdd.text.toString()
            val etDescription = binding.etTitle.text.toString()
            if (noteId != -1) {
                val updateNote = NoteModels(etTittle, etDescription)
                updateNote.id = noteId
                App().getInstance()?.noteDao()?.updateNote(updateNote)
            }else{
                App().getInstance()?.noteDao()?.insertNote(NoteModels(etTittle, etDescription))
            }
            findNavController().navigateUp()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
