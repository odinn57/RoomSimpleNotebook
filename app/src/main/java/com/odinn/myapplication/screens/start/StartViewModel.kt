package com.odinn.myapplication.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.odinn.myapplication.REPOSITORT
import com.odinn.myapplication.db.NoteDatabase
import com.odinn.myapplication.db.repository.NoteRepositoryRealisation
import com.odinn.myapplication.model.NoteModel


class StartViewModel(application: Application):AndroidViewModel(application) {
    private val context = application

    fun initDatabase(){
        val daoNote = NoteDatabase.getInstance(context).getNoteDao()
        REPOSITORT = NoteRepositoryRealisation(daoNote)
    }

    fun getAllNotes(): LiveData<List<NoteModel>> = REPOSITORT.allNotes
}