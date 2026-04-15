package com.notespro.ui.main

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.notespro.data.local.Note

class NotesAdapter : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    private var notes = listOf<Note>()

    fun submitList(newNotes: List<Note>) {
        notes = newNotes
        notifyDataSetChanged()
    }

    class NoteViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val tv = TextView(parent.context)
        tv.setPadding(40, 40, 40, 40)
        return NoteViewHolder(tv)
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.textView.text = notes[position].title
    }
}
