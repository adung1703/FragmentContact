package com.huudung.fragmentcontact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListContactFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListContactFragment : Fragment() {

    val contacts = ArrayList<ItemData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contacts.add(ItemData("0001", "Bố", "0904461456", "huuthom1972@gmail.com", R.drawable.b))
        contacts.add(ItemData("0002", "Mẹ", "0702189333", "phuongdo1976@gmail.com", R.drawable.m))
        contacts.add(ItemData("0003", "Chị gái", "0966937097", "nhungnt@gmail.com", R.drawable.c))
        contacts.add(ItemData("0004", "Bác Sĩ Tuấn Phó GĐ Bệnh Viện TS", "0914571389", "tuandoctor@gmail.com", R.drawable.t))
        contacts.add(ItemData("0005", "Cháu Quang", "0326942865", "nguyenducquang@gmail.com", R.drawable.q))
        contacts.add(ItemData("0006", "Chị Biển", "0388102109", "nttbien@gmail.com", R.drawable.b))
        contacts.add(ItemData("0007", "Chú Long", "0975711787", "longnt@gmail.com", R.drawable.l))
        contacts.add(ItemData("0008", "Cô Giang", "0904655910", "gianglethu@gmail.com", R.drawable.g))
        contacts.add(ItemData("0009", "Diệp Anh", "0867 281 604", "anhntd@gmail.com", R.drawable.d))
        contacts.add(ItemData("0010", "Thầy Lâm", "0978144924", "lamnv@gmail.com", R.drawable.l))
        contacts.add(ItemData("0011", "Chú Luân", "0944950156", "luancomputer@gmail.com", R.drawable.l))
        contacts.add(ItemData("0012", "Lành máy giặt", "0934094789", "lanhmaygiat@gmail.com", R.drawable.l))
        contacts.add(ItemData("0013", "Dũng", "0867831513", "adung1703@gmail.com", R.drawable.d))
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_contact, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val listView = view.findViewById<RecyclerView>(R.id.listview)
        listView.layoutManager = LinearLayoutManager(requireContext())
        listView.adapter = MyAdapter(contacts)
    }

}