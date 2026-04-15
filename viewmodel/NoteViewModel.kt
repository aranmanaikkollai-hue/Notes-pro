package com.notespro.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.notespro.data.local.Note
import com.notespro.data.local.NotesDatabase
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private val dao = NotesDatabase.getDatabase(application).noteDao()
    val notes: LiveData<List<Note>> = dao.getAllNotes()

    fun insert(note: Note) = viewModelScope.launch {
        dao.insert(note)
    }

    fun delete(note: Note) = viewModelScope.launch {
        dao.delete(note)
    }
}
