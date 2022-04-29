package com.shubham.jetpackcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.shubham.jetpackcomponent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)

        val post  = Post("beauty", "beauty lies in eyes of beholder","https://firebasestorage.googleapis.com/v0/b/smart-attendance-676ea.appspot.com/o/3659672%20(1).jpg?alt=media&token=04f38afc-5c96-40a2-bde7-5a8b17e63569")

        binding.post = post

    }
}