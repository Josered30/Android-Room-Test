package com.eupgroup.reciclerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Update
import com.eupgroup.reciclerviewtest.database.AppDatabase
import com.eupgroup.reciclerviewtest.models.Contact
import kotlinx.android.synthetic.main.activity_contact.*
import kotlinx.android.synthetic.main.activity_details.*

class ContactActivity : AppCompatActivity() {

    lateinit var contact: Contact
    var update: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.title="Add contact"
        init()
    }

    private fun init() {

        if (intent.hasExtra("contact")) {
            update = true
            contact = intent.getSerializableExtra("contact") as Contact
            editName.text?.append(contact.name)
            editTextPhone.text?.append(contact.phone)
        }

        button.setOnClickListener{
            commit()
        }
    }


    private fun commit() {

        var uid: Int? =  if (!update) null else contact.uid
        contact = Contact(
            uid,
            editName.text.toString(),
            editTextPhone.text.toString(),
        )

        if(!update)
            AppDatabase.getInstance(this).contactRepository().insert(contact)
        else
            AppDatabase.getInstance(this).contactRepository().update(contact)
        finish()
    }

}