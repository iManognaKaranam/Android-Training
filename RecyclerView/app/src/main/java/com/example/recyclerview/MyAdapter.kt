package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var userlist : ArrayList<User>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(itemView : View)  : RecyclerView.ViewHolder(itemView){

        fun myBindViews(users : User){
            var username = itemView.findViewById<TextView>(R.id.textViewUsername)
            var password = itemView.findViewById<TextView>(R.id.textViewPassword)

            username.setText(users.username)
            password.setText(users.pwd)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return  MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.myBindViews(userlist[position])
    }

    override fun getItemCount(): Int {
        return userlist.size
    }
}