package com.example.noteappdoc.ui.fragments.note

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.example.noteappdoc.App
import com.example.noteappdoc.data.models.NoteModels
import com.example.noteappdoc.databinding.FragmentNoteDetailBinding
import com.example.noteappdoc.extensions.setBackStackData
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale


class NoteDetailFragment : Fragment() {

    private var _binding: FragmentNoteDetailBinding? = null
    private val binding: FragmentNoteDetailBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListene()
        setupListener()
        setupListeners()
        setupListenerss()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setupListene() {
        val localDateTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd MMMM \nHH:mm", Locale("ru"))
        val data = localDateTime.format(formatter)

        binding.btnGoBack.setOnClickListener {
            val etTitle = binding.etAdd.text.toString()
            val etDescription = binding.etTitle.text.toString()
            App().getInstance()?.noteDao()?.insertNote(
                NoteModels(
                    title = etTitle,
                    description = etDescription,
                    color = "#151515",
                    data = data
                )
            )
            findNavController().navigateUp()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setupListener() {
        val localDateTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd MMMM \nHH:mm", Locale("ru"))
        val data = localDateTime.format(formatter)

        binding.btnAddBlack.setOnClickListener {
            val etTitle = binding.etAdd.text.toString()
            val etDescription = binding.etTitle.text.toString()
            App().getInstance()?.noteDao()?.insertNote(
                NoteModels(
                    title = etTitle,
                    description = etDescription,
                    color = "#FF000000",
                    data = data
                )
            )
            findNavController().navigateUp()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setupListeners() {
        val localDateTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd MMMM \nHH:mm", Locale("ru"))
        val data = localDateTime.format(formatter)

        binding.btnAddWhite.setOnClickListener {
            val etTitle = binding.etAdd.text.toString()
            val etDescription = binding.etTitle.text.toString()
            App().getInstance()?.noteDao()?.insertNote(
                NoteModels(
                    title = etTitle,
                    description = etDescription,
                    color = "#EBE4C9",
                    data = data
                )
            )
            findNavController().navigateUp()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setupListenerss() {
        val localDateTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd MMMM \nHH:mm", Locale("ru"))
        val data = localDateTime.format(formatter)

        binding.btnAddReed.setOnClickListener {
            val etTitle = binding.etAdd.text.toString()
            val etDescription = binding.etTitle.text.toString()
            App().getInstance()?.noteDao()?.insertNote(
                NoteModels(
                    title = etTitle,
                    description = etDescription,
                    color = "#571818",
                    data = data
                )
            )
            findNavController().navigateUp()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}