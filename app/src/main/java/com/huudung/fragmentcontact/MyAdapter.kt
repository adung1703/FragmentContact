package com.huudung.fragmentcontact

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView


class MyAdapter(val items : ArrayList<ItemData>) : RecyclerView.Adapter<MyAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val avatar = itemView.findViewById<ImageView>(R.id.avatar)
        val name = itemView.findViewById<TextView>(R.id.name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.avatar.setImageResource(items[position].avatar)
        holder.name.text = items[position].name
        holder.itemView.setOnClickListener {
            val detailFragment = DetailFragment()
            val bundle = Bundle()
            bundle.putString("id", items[position].id)
            bundle.putString("name", items[position].name)
            bundle.putString("phone", items[position].phone)
            bundle.putString("mail", items[position].mail)
            detailFragment.arguments = bundle

            (holder.itemView.context as AppCompatActivity)
                .supportFragmentManager
                .beginTransaction()
                .replace(R.id.ListContacts, detailFragment)
                .addToBackStack("LIST")
                .commit()
        }
        val popupMenu = PopupMenu(holder.itemView.context, holder.itemView)
        popupMenu.menuInflater.inflate(R.menu.my_menu, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.call -> {
                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${items[position].phone}"))
                    holder.itemView.context.startActivity(intent)
                    true
                }
                R.id.mess -> {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.setType("vnd.android-dir/mms-sms")
                    intent.setData(Uri.parse("smsto:${items[position].phone}"))
                    intent.putExtra(Intent.EXTRA_TEXT, "Message Text")
                    holder.itemView.context.startActivity(intent)
                    true
                }
                R.id.mail -> {
                    val intent = Intent(Intent.ACTION_SEND)
                    intent.type = "text/plain"
                    intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(items[position].mail))
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Email Subject")
                    intent.putExtra(Intent.EXTRA_TEXT, "Email Message Text")
                    holder.itemView.context.startActivity(intent)
                    true
                }
                else -> false
            }
        }

        holder.itemView.setOnLongClickListener {
            popupMenu.show()
            true
        }
    }
}