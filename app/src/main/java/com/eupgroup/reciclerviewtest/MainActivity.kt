package com.eupgroup.reciclerviewtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.eupgroup.reciclerviewtest.database.AppDatabase
import com.eupgroup.reciclerviewtest.models.Contact
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var contacts: List<Contact>
    private lateinit var contactAdapter: ContactAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.title="Agenda"
    }

    override fun onResume() {
        super.onResume()
        loadContacts()
        initViews()
    }

    private fun loadContacts() {
        contacts = AppDatabase.getInstance(this).contactRepository().getAll()
    }


    private fun initViews() {
        contactAdapter = ContactAdapter( this.contacts)

        contactAdapter.setOnItemClickListener{
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("contact", it)
            startActivity(intent)
        }

        rvContact.adapter = contactAdapter
        rvContact.layoutManager = LinearLayoutManager(this)

        floatingActionButton.setOnClickListener {
            val intent = Intent(this, ContactActivity::class.java)
            startActivity(intent)
        }



    }
}