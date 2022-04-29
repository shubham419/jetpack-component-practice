package com.shubham.jetpackcomponent.database

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface ContactDao {
    @Insert
    suspend fun insertContact (contact: Contact)

    @Update
    suspend fun updateContact (contact: Contact)

    @Delete
    suspend fun deleteContact (contact: Contact)

    @Query("SELECT * FROM Contact")
    fun getContact (): LiveData<List<Contact>>
}