package com.example.githubrepolist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.githubrepolist.R
import com.example.githubrepolist.adapter.UsersRepoAdapter.Companion.selectedPosition
import com.example.githubrepolist.adapter.UsersRepoAdapter.Companion.userRepoListForHomeFragment
import com.example.githubrepolist.utils.Util


class RepoDetailFragment : Fragment() {
    var userImage:ImageView?=null
    var userName:TextView?=null
    var repoStarsText:TextView?=null
    var repoOpenIssues:TextView?=null
    private lateinit var utils : Util
  //  private lateinit var mainActivity: MainActivity
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
        val mainActivity = activity as MainActivity?
        mainActivity?.setStarIconVisibility(View.VISIBLE)
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
        userName?.text=userRepoListForHomeFragment?.get(selectedPosition)?.owner?.login.toString()
        repoStarsText?.text="Stars: "+ userRepoListForHomeFragment?.get(selectedPosition)?.stargazersCount.toString()
        repoOpenIssues?.text="Open Issues: "+userRepoListForHomeFragment?.get(selectedPosition)?.openIssuesCount.toString()
    }

    companion object {
    }
}
