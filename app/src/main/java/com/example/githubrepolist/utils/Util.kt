package com.example.githubrepolist.utils

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.githubrepolist.R
import com.example.githubrepolist.view.MainActivity.Companion.mainActivityContext


class Util {
    private val sharedPref: SharedPreferences = mainActivityContext!!.getSharedPreferences(
        mainActivityContext!!.getString(R.string.save_star_shared_name), Context.MODE_PRIVATE)

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

    fun saveToLocal(KEY_NAME: String, value:String?){
        val savedRepoIDList=getValueFromLocal(mainActivityContext!!.getString(R.string.save_star_shared_name))
        val editor: SharedPreferences.Editor = sharedPref.edit()
        if(1==1){
            savedRepoIDList?.add(value.toString())
        }
        else{
            savedRepoIDList?.remove(value.toString())
        }
        editor.putStringSet(KEY_NAME, savedRepoIDList)
        editor.apply()
    }

    fun getValueFromLocal(KEY_NAME: String): MutableSet<String>? {
        return sharedPref.getStringSet(KEY_NAME, null)
    }

}