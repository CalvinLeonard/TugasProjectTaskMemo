package com.D121201079.TaskMemo

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.D121201079.TaskMemo.DB.catatan

class CatatanAdapter(private val listener:IAdaptor) : RecyclerView.Adapter<CatatanAdapter.CatatanViewHolder>() {

    private val allNotes = ArrayList<catatan>()
    var context:Context?=null


    class CatatanViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        val isi: TextView = itemView.findViewById(R.id.isi)
        val keterangan: TextView = itemView.findViewById(R.id.keterangan)
        val delete : ImageView = itemView.findViewById(R.id.delete)
        val edit : ImageView = itemView.findViewById(R.id.edit)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatatanViewHolder {
        val viewHolder = CatatanViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_catatan,parent,false))
        context = parent.context
        viewHolder.delete.setOnClickListener{
            listener.onDeleteClick((allNotes[viewHolder.adapterPosition]))
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: CatatanViewHolder, position: Int) {
        val currentItem = allNotes[position]
        holder.isi.text = currentItem.isi
        holder.keterangan.text = currentItem.keterangan

        holder.edit.setOnClickListener {
            val intent  = Intent(context,TambahCatatanActivity::class.java)
            intent.putExtra("isi",currentItem.isi)
            intent.putExtra("keterangan",currentItem.keterangan)
            intent.putExtra("id",currentItem.id)
            intent.putExtra("code",2)
                context!!.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    fun updateCatatan(Catatanbaru : List<catatan>){
        allNotes.clear()
        allNotes.addAll(Catatanbaru)
        notifyDataSetChanged()
    }

}
interface IAdaptor{
    fun onDeleteClick(note : catatan)
}