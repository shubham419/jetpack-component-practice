package com.shubham.jetpackcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.room.Room
import com.shubham.jetpackcomponent.database.Contact
import com.shubham.jetpackcomponent.database.Database
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var database : Database
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = Room.databaseBuilder(applicationContext,Database::class.java,"Database").build()


        GlobalScope.launch {
            database.contactDao().insertContact(Contact("shubham","3245", 0))
        }

    }

    fun click(view: View) {
        database.contactDao().getContact().observe(this,  {
            Log.d("xyz", it.toString())
        })
    }
}