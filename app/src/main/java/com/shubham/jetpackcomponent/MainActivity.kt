package com.shubham.jetpackcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.textView)

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.mutableLiveData.observe(this,{
            textView.text = it
        })

        button.setOnClickListener(View.OnClickListener {
            viewModel.updateData()
        })
    }
}