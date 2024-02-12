package com.example.apidataflow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter:RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    private var users:List<User> = listOf()

    fun setUsers(users: List<User>){
        this.users = users
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentUser = users[position]
        holder.bind(currentUser)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.text_view)

        fun bind(user: User) {
            textView.text = "${user.first_name} ${user.last_name}"
        }
    }


}