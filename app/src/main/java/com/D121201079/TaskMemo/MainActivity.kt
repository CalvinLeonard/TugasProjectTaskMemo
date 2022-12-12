package com.D121201079.TaskMemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.D121201079.TaskMemo.DB.catatan

class MainActivity : AppCompatActivity(), IAdaptor {

    private lateinit var viewModel : catatanViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerview : RecyclerView = findViewById(R.id.recycler_view)
        recyclerview.layoutManager = LinearLayoutManager(this)
        val adapter = CatatanAdapter(this)
        recyclerview.adapter = adapter

        viewModel = ViewModelProvider(this).get(catatanViewModel::class.java)
        viewModel.allNotes.observe(this, Observer {
            adapter.updateCatatan(it)
        })
    }

    fun tambahcatatan(view:View){
        val intent = Intent(this,TambahCatatanActivity::class.java)
        intent.putExtra("code",1)
        startActivity(intent)
    }

    override fun onDeleteClick(note : catatan){
        viewModel.deleteNote(note)
    }
}