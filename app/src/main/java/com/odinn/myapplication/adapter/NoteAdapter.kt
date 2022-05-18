package com.odinn.myapplication.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.odinn.myapplication.databinding.ItemLayoutBinding
import com.odinn.myapplication.model.NoteModel
import com.odinn.myapplication.screens.start.StartFragment

class NoteAdapter: RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    var listNote = emptyList<NoteModel>()

    class NoteViewHolder(private var itemNoteBinding: ItemLayoutBinding):RecyclerView.ViewHolder(itemNoteBinding.root){
        fun bind(noteModel: NoteModel){
            with(itemNoteBinding) {
                itemTitle.text = noteModel.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapter.NoteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemNoteBinding = ItemLayoutBinding.inflate(layoutInflater,parent,false)
        return NoteViewHolder(itemNoteBinding)
    }

    override fun onBindViewHolder(holder: NoteAdapter.NoteViewHolder, position: Int) {
        holder.bind(listNote[position])
    }

    override fun getItemCount(): Int = listNote.size

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<NoteModel>){
        listNote = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: NoteViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            StartFragment.clickNote(listNote[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: NoteViewHolder) {
        holder.itemView.setOnClickListener (null)
    }


}