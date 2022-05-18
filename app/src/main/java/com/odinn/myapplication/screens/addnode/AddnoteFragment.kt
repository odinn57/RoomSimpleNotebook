package com.odinn.myapplication.screens.addnode

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.odinn.myapplication.APP
import com.odinn.myapplication.R
import com.odinn.myapplication.databinding.FragmentAddnoteBinding
import com.odinn.myapplication.model.NoteModel


class AddnoteFragment : Fragment() {

    lateinit var binding: FragmentAddnoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddnoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_addnoteFragment_to_startFragment)
        }
        val viewModel = ViewModelProvider(this).get(AddnoteViewModel::class.java)
        binding.btnAddnote.setOnClickListener {
            val title = binding.etAddTitle.text.toString()
            val description = binding.etAddDescription.text.toString()
            viewModel.insert(NoteModel(title = title, description = description)){

            }
            APP.navController.navigate(R.id.action_addnoteFragment_to_startFragment)
        }
    }

}