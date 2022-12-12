package com.D121201079.TaskMemo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.D121201079.TaskMemo.DB.DatabaseCatatan
import com.D121201079.TaskMemo.DB.catatan
import com.D121201079.TaskMemo.DB.catatanRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class catatanViewModel(application: Application) : AndroidViewModel(application) {

    val allNotes : LiveData<List<catatan>>
    private val repository : catatanRepository

    init {
        val dao = DatabaseCatatan.getDatabase(application).getcatatanDAO()
        repository = catatanRepository(dao)
        allNotes = repository.allNotes
    }

    fun insertNote(note : catatan) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(note)
    }

    fun deleteNote(note : catatan) = viewModelScope.launch(Dispatchers.IO){
        repository.delete(note)
    }

    fun update(note : catatan) = viewModelScope.launch(Dispatchers.IO){
        repository.update(note)
    }
}