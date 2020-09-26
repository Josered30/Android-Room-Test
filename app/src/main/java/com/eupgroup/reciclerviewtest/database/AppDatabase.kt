package com.eupgroup.reciclerviewtest.database

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.eupgroup.reciclerviewtest.models.Contact
import com.eupgroup.reciclerviewtest.repositories.ContactRepository

@Database(entities = [Contact::class],version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun contactRepository(): ContactRepository

    companion object {
        var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "AgendaDatabase"
                ).allowMainThreadQueries().build()
            }
            return INSTANCE as AppDatabase
            
        }
    }


    override fun createOpenHelper(config: DatabaseConfiguration?): SupportSQLiteOpenHelper {
        TODO("Not yet implemented")
    }
    override fun createInvalidationTracker(): InvalidationTracker {
        TODO("Not yet implemented")
    }

    override fun clearAllTables() {
        TODO("Not yet implemented")
    }

}