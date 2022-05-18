package com.odinn.myapplication.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.odinn.myapplication.DATABASE_NAME
import com.odinn.myapplication.db.dao.NoteDao
import com.odinn.myapplication.model.NoteModel

@Database(entities = [NoteModel::class] , version = 1, exportSchema = false)
abstract class NoteDatabase:RoomDatabase() {
    abstract fun getNoteDao():NoteDao

    companion object{
        @Volatile private var database:NoteDatabase? = null

        fun getInstance(context: Context):NoteDatabase{
            return database ?: synchronized(this){
                database ?: buildDatabase(context).also{ database = it }
            }
        }

        private fun buildDatabase(context: Context):NoteDatabase{
            return Room.databaseBuilder(context, NoteDatabase::class.java, DATABASE_NAME).build()
        }
    }
}