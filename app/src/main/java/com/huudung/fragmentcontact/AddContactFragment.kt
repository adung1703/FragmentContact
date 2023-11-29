package com.huudung.fragmentcontact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class AddContactFragment : Fragment() {

    val listContactFragment = ListContactFragment()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_contact, container, false)
    }

    private fun check(ID: String, Name: String, Phone: String, Mail: String): Boolean {
        return ID.isNotBlank() && Name.isNotBlank() && Phone.isNotBlank() && Mail.isNotBlank()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val addID = view.findViewById<EditText>(R.id.AddId)
        val addName = view.findViewById<EditText>(R.id.AddName)
        val addPhone = view.findViewById<EditText>(R.id.AddPhone)
        val addMail = view.findViewById<EditText>(R.id.AddMail)

        val addButton = view.findViewById<Button>(R.id.Complete)

        addButton.setOnClickListener {
            if(check(addID.text.toString(),
                    addName.text.toString(),
                    addPhone.text.toString(),
                    addMail.text.toString()
                )) {
                Toast.makeText(context, "Add Contact Successfully!", Toast.LENGTH_SHORT).show()
                val item = ItemData(addID.text.toString(),
                    addName.text.toString(),
                    addPhone.text.toString(),
                    addMail.text.toString(),
                    resources.getIdentifier(
                        "drawable/${addName.text.toString().firstOrNull()?.lowercase()}",
                        null,
                        view.context.packageName
                    )
                    )
                listContactFragment.contacts.add(item)
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.ListContacts, listContactFragment)
                    .commit()
            }
            else Toast.makeText(context, "Fill all fields", Toast.LENGTH_SHORT).show()
        }

    }


}