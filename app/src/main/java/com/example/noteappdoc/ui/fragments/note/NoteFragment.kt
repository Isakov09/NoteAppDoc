package com.example.noteappdoc.ui.fragments.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteappdoc.App
import com.example.noteappdoc.R
import com.example.noteappdoc.data.models.NoteModels
import com.example.noteappdoc.databinding.FragmentNoteBinding
import com.example.noteappdoc.extensions.getBackStackData
import com.example.noteappdoc.interfaces.OnClickItem
import com.example.noteappdoc.ui.adapters.NoteAdapter

class NoteFragment : Fragment(), OnClickItem {

    private var _binding: FragmentNoteBinding? = null
    private val binding: FragmentNoteBinding get() = _binding!!

    private val noteAdapter = NoteAdapter(this, this)
    private val list: ArrayList<NoteModels> = ArrayList()
    private var isLinearLayout = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListeners()
        getData()
    }

    private fun initialize() {
        binding.rvNotes.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = noteAdapter
        }
    }

    private fun setupListeners() = with(binding) {
//        val preferenceHelper = PreferenceHelper()
//        preferenceHelper.unit(requireContext())
//        btnSave.setOnClickListener {
//            val et = edText.text.toString()
//            preferenceHelper.text =et
//            txtSave.text = et
//        }
//        txtSave.text = preferenceHelper.text
        btnAddNote.setOnClickListener {
            findNavController().navigate(R.id.action_noteFragment_to_noteDetailFragment)
        }

        ivGrit.setOnClickListener {
            toggleLayout()
        }
    }

    private fun toggleLayout() {
        if (isLinearLayout) {
            binding.rvNotes.layoutManager = GridLayoutManager(requireContext(), 2)
        } else {
            binding.rvNotes.layoutManager = LinearLayoutManager(requireContext())
        }
        isLinearLayout = !isLinearLayout
    }


    private fun getData() {
        App().getInstance()?.noteDao()?.getAll()?.observe(viewLifecycleOwner) {
            noteAdapter.submitList(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onLongClick(noteModels: NoteModels) {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Вы точно хотите удалить заметку?")
            .setPositiveButton("Да") { dialog, which ->
                App().getInstance()?.noteDao()?.deleteNote(noteModels)
            }
            .setNegativeButton("Нет") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }

    override fun onClick(noteModels: NoteModels) {
        val action = NoteFragmentDirections.actionNoteFragmentToNoteDetailFragment(noteModels.id)
        findNavController().navigate(action)
    }
}