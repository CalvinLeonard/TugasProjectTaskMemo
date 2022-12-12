package com.D121201079.TaskMemo.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [catatan::class], version = 1, exportSchema = false)
abstract class DatabaseCatatan : RoomDatabase() {

    abstract fun getcatatanDAO() : catatanDAO

    companion object{
        @Volatile
        private var INSTANCE : DatabaseCatatan? = null
        fun getDatabase(context: Context) : DatabaseCatatan{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseCatatan::class.java,
                    "catatan_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }


}