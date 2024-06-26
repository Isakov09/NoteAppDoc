package com.example.noteappdoc.ui.fragments.chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteappdoc.databinding.FragmentChatBinding
import com.example.noteappdoc.ui.adapters.ChatAdapter
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore


class ChatFragment : Fragment() {

    private lateinit var binding: FragmentChatBinding
    private val chatAdapter = ChatAdapter()
    private val db = Firebase.firestore
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setUpListener()
    }

    private fun initialize() {
        binding.rvChat.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = chatAdapter
        }
    }

    private fun setUpListener() {
        binding.btnSend.setOnClickListener {
            val user = hashMapOf(
                "name" to binding.etMassage.text.toString()
            )
            db.collection("user")
                .add(user)
                .addOnCompleteListener{
                    binding.etMassage.text.clear()
                }
        }
    }
}