package com.D121201079.TaskMemo.DB

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
abstract class catatanDAO {

    @Query("SELECT * FROM catatan_tabel ORDER BY id ASC")
    abstract fun getAllNotes() : LiveData<List<catatan>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insert(catatan : catatan)

    @Delete
    abstract fun delete(catatan : catatan)

    @Update
    abstract fun update(catatan: catatan)
}