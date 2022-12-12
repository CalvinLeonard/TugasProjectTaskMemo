package com.D121201079.TaskMemo.DB

class catatanRepository (private val catatan_DAO : catatanDAO) {
    val allNotes = catatan_DAO.getAllNotes()

    suspend fun insert(note : catatan){
        catatan_DAO.insert(note)
    }

    suspend fun delete(note : catatan){
        catatan_DAO.delete(note)
    }

    fun update(note : catatan){
        catatan_DAO.update(note)
    }
}