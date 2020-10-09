package com.eupgroup.reciclerviewtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.eupgroup.reciclerviewtest.models.Contact
import kotlinx.android.synthetic.main.prototype_contact.view.*

class ContactAdapter(var contacts: List<Contact>) : RecyclerView.Adapter<ContactAdapter.ContactPrototype>() {
    lateinit var clickListener: ClickListener<Contact>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactPrototype {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.prototype_contact, parent, false)
        return ContactPrototype(view)
    }

    override fun onBindViewHolder(holder: ContactPrototype, position: Int) {
        holder.bindTo(this.contacts[position])
        holder.cardView.setOnClickListener {
            _ -> clickListener.onItemClick(contacts[position])
        }

    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    fun setOnItemClickListener(clickListener :ClickListener<Contact>) {
        this.clickListener = clickListener;
    }

    class ContactPrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var cardView: CardView = itemView.findViewById(R.id.cardView);

        fun bindTo(contact: Contact) {
            itemView.tvName.text = contact.name
            itemView.tvPhone.text = contact.phone


        }

    }

}

fun interface ClickListener<T>{
    fun onItemClick (data: T)
}