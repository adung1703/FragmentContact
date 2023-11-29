package com.huudung.fragmentcontact

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val detailFragment = DetailFragment()
    val listFragment = ListContactFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.ListContacts, listFragment)
            .commit()

        findViewById<ImageButton>(R.id.AddButton).setOnClickListener {
            val addContactFragment = AddContactFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.ListContacts, addContactFragment)
                .addToBackStack("LIST")
                .commit()
        }
    }
}