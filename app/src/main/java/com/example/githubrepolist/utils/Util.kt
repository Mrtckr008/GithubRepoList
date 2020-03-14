package com.example.githubrepolist.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.getSystemService
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.githubrepolist.R
import com.example.githubrepolist.view.MainActivity
import com.example.githubrepolist.view.MainActivity.Companion.mainActivityContext


class Util {
    fun loadImageWithGlide(context:Context,url:String,intoView:ImageView){
        val options: RequestOptions = RequestOptions()
            .centerCrop()
            .placeholder(R.mipmap.ic_launcher_round)
            .error(R.mipmap.ic_launcher_round)

        Glide.with(context).load(url).apply(options)
            .into(intoView)
    }

    fun setTextView(view:TextView,value:String){
        view.text=value
    }

    fun hideKeyboard(){
        val imm: InputMethodManager =
            mainActivityContext?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var view: View? = mainActivityContext?.getCurrentFocus()
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = View(mainActivityContext)
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0)
    }

}