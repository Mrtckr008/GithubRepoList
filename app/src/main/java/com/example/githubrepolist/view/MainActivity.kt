package com.example.githubrepolist.view

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.githubrepolist.R
import com.example.githubrepolist.utils.Util
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var imageView:ImageView?=null
    private lateinit var navigationController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityContext=this
        navigationController = Navigation.findNavController(this, R.id.navigation_fragment)
    //    NavigationUI.setupActionBarWithNavController(this,navigationController)
        savedRepoIDList= Util().getValueFromLocal(this.getString(R.string.save_star_shared_name))
        val mTopToolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(mTopToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)



        println("mcmcmc saved index is-> ${savedRepoIDList?.size}")
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navigationController,null)
    }

    fun setStarIconVisibility(visibilityStatus:Int){
        imageView=this.findViewById(R.id.toolbar_star_icon)
        imageView!!.visibility = visibilityStatus
    }

    companion object{
        var mainActivityContext : Activity?=null
        var savedRepoIDList :MutableSet<String>?=null
    }
}
