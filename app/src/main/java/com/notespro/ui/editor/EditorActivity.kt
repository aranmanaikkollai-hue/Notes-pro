
package com.notespro.ui.editor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.notespro.databinding.ActivityEditorBinding

class EditorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditorBinding
    private lateinit var viewModel: NoteViewModel
   
    viewModel = ViewModelProvider(this)[NoteViewModel::class.java]

override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditorBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
override fun onPause() {
    super.onPause()

    val title = binding.title.text.toString()
    val content = binding.content.text.toString()

    if (title.isNotEmpty() || content.isNotEmpty()) {
        val note = Note(
            title = title,
            content = content,
            timestamp = System.currentTimeMillis()
        )
        viewModel.insert(note)
    }
}
