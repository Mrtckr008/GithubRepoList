package com.example.githubrepolist.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

import com.example.githubrepolist.R
import com.example.githubrepolist.adapter.UsersRepoAdapter.Companion.selectedPosition
import com.example.githubrepolist.adapter.UsersRepoAdapter.Companion.userRepoListForHomeFragment
import com.example.githubrepolist.utils.Util
import com.example.githubrepolist.viewmodel.UserRepoViewModel


class RepoDetailFragment : Fragment() {
    var userImage:ImageView?=null
    var userName:TextView?=null
    var repoStarsText:TextView?=null
    var repoOpenIssues:TextView?=null
    private lateinit var utils : Util
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_repo_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        utils= Util()
        findViews(view)
        setViewDatas()
    }


    private fun findViews(view: View){
        userImage=view.findViewById(R.id.user_profile_image)
        userName=view.findViewById(R.id.user_name)
        repoStarsText=view.findViewById(R.id.repo_stars_text)
        repoOpenIssues=view.findViewById(R.id.repo_open_issue_text)
    }

    private fun setViewDatas(){
        MainActivity.mainActivityContext?.let { userImage?.let { it1 ->
            utils.loadImageWithGlide(it, userRepoListForHomeFragment?.get(selectedPosition)?.owner?.avatarUrl.toString(),
                it1
            )
        } }
        userName?.let { utils.setTextView(it, userRepoListForHomeFragment?.get(selectedPosition)?.owner?.login.toString()) }
        repoStarsText?.let { utils.setTextView(it,"Stars: "+
            userRepoListForHomeFragment?.get(selectedPosition)?.stargazersCount.toString()
        ) }
        repoOpenIssues?.let { utils.setTextView(it, "Open Issues: "+userRepoListForHomeFragment?.get(selectedPosition)?.openIssuesCount.toString()) }
    }

    companion object {
    }
}
