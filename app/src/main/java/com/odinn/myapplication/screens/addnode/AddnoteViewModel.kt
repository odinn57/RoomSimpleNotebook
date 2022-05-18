package com.odinn.myapplication.screens.addnode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.odinn.myapplication.REPOSITORT
import com.odinn.myapplication.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddnoteViewModel:ViewModel() {
    fun insert(noteModel: NoteModel,onSuccess:() -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORT.insertNote(noteModel){ onSuccess() }
        }
}