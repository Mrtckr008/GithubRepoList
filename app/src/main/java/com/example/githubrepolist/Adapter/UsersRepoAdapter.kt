package com.example.githubrepolist.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubrepolist.Model.UserRepo
import com.example.githubrepolist.R
import kotlinx.android.synthetic.main.repo_item_list.view.*

class UsersRepoAdapter(var usersRepoList:ArrayList<UserRepo>) : RecyclerView.Adapter<UsersRepoAdapter.FeedViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val view = LayoutInflater.from(parent.
            context).inflate(R.layout.repo_item_list,parent,false)
        return FeedViewHolder(view)
    }
    override fun getItemCount(): Int {
        return usersRepoList.size
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.itemView.repo_name.text=usersRepoList[position].name
    }

    fun updateUsersRepoList(newRepoList:List<UserRepo>){
        usersRepoList.clear()
        usersRepoList.addAll(newRepoList)
        notifyDataSetChanged()
    }

    class FeedViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}