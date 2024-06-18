package com.example.noteappdoc.ui.fragments.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.noteappdoc.R
import com.example.noteappdoc.databinding.FragmentNoteDetailBinding
import com.example.noteappdoc.extensions.setBackStackData


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    private fun setupListeners() {
        binding.btnAddText.setOnClickListener {
            val et = binding.etAdd.text.toString()

            setBackStackData("key", et, true)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}