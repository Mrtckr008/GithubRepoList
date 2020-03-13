package com.example.githubrepolist.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.githubrepolist.R
import com.example.githubrepolist.ViewModel.UserRepoViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var navigationController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigationController = Navigation.findNavController(this,
            R.id.navigation_fragment
        )
        NavigationUI.setupActionBarWithNavController(this,navigationController)



    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navigationController,null)
    }
}
