package com.huudung.fragmentcontact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    var id: String? = null
    var name: String? = null
    var phone: String? = null
    var mail: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        arguments?.let {
            id = it.getString("id")
            name = it.getString("name")
            phone = it.getString("phone")
            mail = it.getString("mail")
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.ID).text = id
        view.findViewById<TextView>(R.id.FullName).text = name
        view.findViewById<TextView>(R.id.Number).text = phone
        view.findViewById<TextView>(R.id.Email).text = mail
    }

}