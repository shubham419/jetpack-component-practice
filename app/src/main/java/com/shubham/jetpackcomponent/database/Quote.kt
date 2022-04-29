package com.shubham.jetpackcomponent.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote_table")
data class Quote(@PrimaryKey(autoGenerate = true) val id: Int, val text: String, val author: String)
