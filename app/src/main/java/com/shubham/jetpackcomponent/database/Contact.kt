package com.shubham.jetpackcomponent.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Contact")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name: String,
    val number: String,
    val createdDate : Date
    )