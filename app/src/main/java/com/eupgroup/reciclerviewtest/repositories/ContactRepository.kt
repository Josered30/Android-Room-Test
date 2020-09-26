package com.eupgroup.reciclerviewtest.repositories;

import androidx.room.*

import com.eupgroup.reciclerviewtest.models.Contact;

@Dao
public interface ContactRepository {
    @Query("SELECT * FROM contact")
    fun getAll(): List<Contact>

    @Insert
    fun insert(vararg contact: Contact)

    @Delete
    fun delete(vararg contact: Contact)

    @Update
    fun update(vararg contact: Contact)
}
