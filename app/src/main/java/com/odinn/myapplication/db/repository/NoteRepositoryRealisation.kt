package com.odinn.myapplication.db.repository

import androidx.lifecycle.LiveData
import com.odinn.myapplication.db.dao.NoteDao
import com.odinn.myapplication.model.NoteModel

class NoteRepositoryRealisation(private val noteDao: NoteDao): NoteRepository {
    override val allNotes: LiveData<List<NoteModel>>
        get() = noteDao.getAllNotes()

    override suspend fun insertNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.insert(noteModel)
        onSuccess()
    }

    override suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.delete(noteModel)
        onSuccess()
    }
}