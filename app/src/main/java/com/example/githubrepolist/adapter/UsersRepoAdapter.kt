package com.example.githubrepolist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.githubrepolist.R
import com.example.githubrepolist.model.UserRepo
import com.example.githubrepolist.view.HomeFragmentDirections
import com.example.githubrepolist.view.MainActivity.Companion.savedRepoIDList
import kotlinx.android.synthetic.main.repo_item_list.view.*


class UsersRepoAdapter(var usersRepoList:ArrayList<UserRepo>) : RecyclerView.Adapter<UsersRepoAdapter.FeedViewHolder>() {
    companion object{
        var userRepoListForHomeFragment:ArrayList<UserRepo> ?=null
        var selectedPosition=0
    }
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
        if(containsSubString(savedRepoIDList,usersRepoList[position].id.toString())){
            holder.itemView.repo_star.visibility=View.VISIBLE
        }
        holder.itemView.repo_name.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToRepoDetailFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }

    fun updateUsersRepoList(newRepoList:List<UserRepo>){
        usersRepoList.clear()
        usersRepoList.addAll(newRepoList)
        userRepoListForHomeFragment=usersRepoList
        notifyDataSetChanged()
    }

    private fun containsSubString(stringArray: MutableSet<String>?, substring: String?): Boolean {
        if (stringArray != null) {
            for (string in stringArray) {
                if (string.contains(substring!!))
                    return true
            }
        }
        return false
    }

    class FeedViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}