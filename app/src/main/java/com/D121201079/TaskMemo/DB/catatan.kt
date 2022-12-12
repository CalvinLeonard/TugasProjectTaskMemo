package com.D121201079.TaskMemo.DB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "catatan_tabel")
class catatan(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id : Int = 0,
    @ColumnInfo(name = "isi") val isi : String,
    @ColumnInfo(name = "keterangan") val keterangan : String)