package com.example.githubrepolist.view

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubrepolist.adapter.UsersRepoAdapter
import com.example.githubrepolist.R
import com.example.githubrepolist.service.UserRepoAPIService.Companion.dynamicUrl
import com.example.githubrepolist.utils.Util
import com.example.githubrepolist.viewmodel.UserRepoViewModel
import kotlinx.android.synthetic.main.fragment_home.*

@Suppress("DEPRECATED_IDENTITY_EQUALS")
class HomeFragment : Fragment() {

    private val usersRepoAdapter = UsersRepoAdapter(arrayListOf())
    private lateinit var viewModel :UserRepoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var repoRecyclerView:RecyclerView?=null
        repoRecyclerView=view.findViewById(R.id.recyclerview_repo)

        var userSearchEditText:EditText?=null
        userSearchEditText=view.findViewById(R.id.search_editText)

        var userSearchSubmitButton:Button?=null
        userSearchSubmitButton=view.findViewById(R.id.submit_button)



        viewModel= ViewModelProviders.of(this).get(UserRepoViewModel::class.java)

        repoRecyclerView.layoutManager = LinearLayoutManager(context)
        repoRecyclerView.adapter = usersRepoAdapter

        userSearchSubmitButton.setOnClickListener{
            if(Util().isInternetAvailable()){
                dynamicUrl=userSearchEditText.text.toString()
                viewModel.getUseRepoDataFromApi()
            }
            else{
                Toast.makeText(
                    MainActivity.mainActivityContext, MainActivity.mainActivityContext?.getString(R.string.noConnection),
                    Toast.LENGTH_SHORT).show()
            }

        }
        observableLiveData()

        userSearchEditText.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent): Boolean {
                if (event.action === KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    userSearchSubmitButton.performClick()
                    return true
                }
                return false
            }
        })

        val mainActivity = activity as MainActivity?
        mainActivity?.setStarIconVisibility(View.INVISIBLE)
        mainActivity?.setToolbarTitleText("Home")

        swipeRefreshLayout.setOnRefreshListener {
            viewModel.getUseRepoDataFromApi()
        }
    }

    private fun observableLiveData(){
        viewModel.usersRepoList.observe(viewLifecycleOwner, Observer{
            UserRepo ->
                UserRepo?.let {
                    usersRepoAdapter.updateUsersRepoList(UserRepo)
                    swipeRefreshLayout.isRefreshing=false
                }
        })
    }
}
