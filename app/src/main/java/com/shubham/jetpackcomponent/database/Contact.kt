package com.shubham.jetpackcomponent.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contact")
data class Contact(val name: String,
                   val number: String,
                   @PrimaryKey(autoGenerate = true)
                   val id:Int )