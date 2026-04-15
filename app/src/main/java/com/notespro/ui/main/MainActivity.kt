package com.notespro.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.notespro.databinding.ActivityMainBinding
import com.notespro.ui.editor.EditorActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Dummy data
        val dummyList = listOf("First Note", "Second Note", "Third Note")

        // RecyclerView setup
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = object : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
                val tv = TextView(parent.context)
                tv.setPadding(40, 40, 40, 40)
                return object : RecyclerView.ViewHolder(tv) {}
            }

            override fun getItemCount() = dummyList.size

            override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
                (holder.itemView as TextView).text = dummyList[position]
            }
        }

        // FAB click
        binding.fab.setOnClickListener {
            startActivity(Intent(this, EditorActivity::class.java))
        }
    }
}
