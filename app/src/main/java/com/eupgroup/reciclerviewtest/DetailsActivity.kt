package com.eupgroup.reciclerviewtest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.eupgroup.reciclerviewtest.database.AppDatabase
import com.eupgroup.reciclerviewtest.models.Contact
import kotlinx.android.synthetic.main.activity_details.*


class DetailsActivity : AppCompatActivity() {

    lateinit var contact: Contact

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.title="Details"
        init()
    }

    private fun init(){
        contact = intent.getSerializableExtra("contact") as Contact
        name.text = "Name:   "+contact.name
        phone.text = "Phone:   " +contact.phone

        delete.setOnClickListener {
            AppDatabase.getInstance(this).contactRepository().delete(contact)
            finish()
        }

        edit.setOnClickListener {
            AppDatabase.getInstance(this).contactRepository()
            val intent = Intent(this, ContactActivity::class.java)
            intent.putExtra("contact", contact)
            //intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_TASK_ON_HOME
            startActivity(intent)
            finish()
        }

    }
}