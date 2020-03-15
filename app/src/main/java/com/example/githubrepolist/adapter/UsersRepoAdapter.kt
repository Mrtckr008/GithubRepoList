package com.example.githubrepolist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.githubrepolist.R
import com.example.githubrepolist.model.UserRepo
import com.example.githubrepolist.utils.Util
import com.example.githubrepolist.view.HomeFragmentDirections
import com.example.githubrepolist.view.MainActivity.Companion.mainActivityContext
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
        var savedRepoIDList= Util().getValueFromLocal(mainActivityContext!!.getString(R.string.save_star_shared_name)) as HashSet<String>?
        if(Util().containsSubString(savedRepoIDList,usersRepoList[position].id.toString())){
            holder.itemView.repo_star.visibility=View.VISIBLE
        }
        else{
            holder.itemView.repo_star.visibility=View.GONE
        }
        holder.itemView.repo_name.setOnClickListener {
            selectedPosition=position
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

    class FeedViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}