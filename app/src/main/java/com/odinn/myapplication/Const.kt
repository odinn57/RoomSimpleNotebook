package com.odinn.myapplication

import androidx.navigation.fragment.NavHostFragment
import com.odinn.myapplication.db.repository.NoteRepository

lateinit var  APP: MainActivity
lateinit var REPOSITORT: NoteRepository
lateinit var navHostFragment:NavHostFragment

const val DATABASE_NAME = "note.db"