package com.odinn.myapplication.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.odinn.myapplication.model.NoteModel

//указываем какая функция что выполняет
@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE) //если что-то пойдет не так, игнор
    suspend fun insert(noteModel: NoteModel)

    @Delete
    suspend fun delete(noteModel: NoteModel)

    @Query("SELECT * FROM note_table")
    fun getAllNotes(): LiveData<List<NoteModel>>
}