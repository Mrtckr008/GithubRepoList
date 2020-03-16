package com.example.githubrepolist.view

import android.app.Activity
import android.os.Bundle
import android.os.StrictMode
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.githubrepolist.R
import com.example.githubrepolist.adapter.UsersRepoAdapter
import com.example.githubrepolist.utils.Util


class MainActivity : AppCompatActivity() {
    var favoriteStarIcon:ImageView?=null
    var toolbarTitle:TextView?=null
    var toolbarBackButton:ImageView?=null
    private lateinit var navigationController : NavController
    var savedRepoIDList :HashSet<String>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityContext=this

        val policy = StrictMode.ThreadPolicy.Builder()
            .permitAll().build()
        StrictMode.setThreadPolicy(policy)

        navigationController = Navigation.findNavController(this, R.id.navigation_fragment)
    //    NavigationUI.setupActionBarWithNavController(this,navigationController)

        val mTopToolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbarTitle = findViewById(R.id.toolbar_title)
        toolbarBackButton = findViewById(R.id.toolbar_back_button)

        setSupportActionBar(mTopToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        favoriteStarIcon=findViewById(R.id.toolbar_star_icon)

        favoriteStarIcon?.setOnClickListener {
            Util().scaleAnimation(favoriteStarIcon!!)
            Util().saveToLocal(this.getString(R.string.save_star_shared_name),
                UsersRepoAdapter.userRepoListForHomeFragment?.get(UsersRepoAdapter.selectedPosition)?.id.toString())
            savedRepoIDList= Util().getValueFromLocal(this.getString(R.string.save_star_shared_name)) as HashSet<String>?
            setStarTintColor(UsersRepoAdapter.userRepoListForHomeFragment?.get(UsersRepoAdapter.selectedPosition)?.id.toString())
        }
        toolbarBackButton?.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navigationController,null)
    }

    fun setStarIconVisibility(visibilityStatus:Int){
        favoriteStarIcon!!.visibility = visibilityStatus
        toolbarBackButton?.visibility = visibilityStatus
    }

    fun setStarTintColor(repoId:String){
        savedRepoIDList = Util().getValueFromLocal(this.getString(R.string.save_star_shared_name)) as HashSet<String>?
        if (Util().containsSubString(savedRepoIDList,repoId)) {
            favoriteStarIcon?.setColorFilter(
                ContextCompat.getColor(this, R.color.colorFavoriteStar),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
        }
        else {
            favoriteStarIcon?.setColorFilter(
                ContextCompat.getColor(this, R.color.colorStarDefault),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
        }
    }

    fun setToolbarTitleText(title:String){
        toolbarTitle?.text=title
    }

    companion object{
        var mainActivityContext : Activity?=null
    }
}
