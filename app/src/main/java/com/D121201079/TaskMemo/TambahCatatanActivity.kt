package com.D121201079.TaskMemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.D121201079.TaskMemo.DB.catatan
import com.D121201079.TaskMemo.databinding.ActivityTambahCatatanBinding

class TambahCatatanActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTambahCatatanBinding
    private lateinit var viewModel: catatanViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTambahCatatanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[catatanViewModel::class.java]

        val button : Button = findViewById(R.id.simpan_btn)
        val items = listOf("Penting Mendesak","Tidak Penting Mendesak","Penting Tidak Mendesak","Tidak Penting Tidak Mendesak")
        val adapter = ArrayAdapter(this,R.layout.layout_dropdown,items)
        binding.keterangan.setAdapter(adapter)

        if(intent.getIntExtra("code",0)==2){
            binding.isicatatan.setText(intent.getStringExtra("isi"))
            binding.keterangan.setText(intent.getStringExtra("keterangan"))
            binding.simpanBtn.setText("Edit")
        }

        button.setOnClickListener{
            addingNote(intent.getIntExtra("code",0))
        }

        binding.backButton.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun addingNote(code : Int){
        val isi : EditText = findViewById(R.id.isicatatan)
        val keterangan : EditText = findViewById(R.id.keterangan)
        val submit1= isi.text.toString()
        val submit2 = keterangan.text.toString()


        if(submit1.isNotEmpty() && submit2.isNotEmpty()){
            if(code==1){
                viewModel.insertNote(catatan(0,submit1,submit2))
            }else{
                viewModel.update(catatan(intent.getIntExtra("id",0),submit1,submit2))
            }

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this,"Keterangan & Isi Harus Di Isi",Toast.LENGTH_SHORT).show()
        }
    }
}