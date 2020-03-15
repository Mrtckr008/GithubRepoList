package com.example.githubrepolist.utils

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.githubrepolist.R
import com.example.githubrepolist.view.MainActivity.Companion.mainActivityContext


class Util {
    var savedStarRepoArrayList: ArrayList<String>?= arrayListOf()
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

    fun hideKeyboard(){
        val imm: InputMethodManager =
            mainActivityContext?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var view: View? = mainActivityContext?.currentFocus
        if (view == null) {
            view = View(mainActivityContext)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun saveToLocal(KEY_NAME: String, value:String?){
        val savedStarReposList = getValueFromLocal(mainActivityContext!!.getString(R.string.save_star_shared_name))
        if (savedStarReposList != null) {
            savedStarRepoArrayList?.addAll(savedStarReposList)
        }
        val editor: SharedPreferences.Editor = sharedPref.edit()
        if(containsSubString(savedStarReposList as HashSet<String>?,value)){
            savedStarRepoArrayList?.remove(value.toString())
        }
        else{
            savedStarRepoArrayList?.add(value.toString())
        }
        println("mcmcmc x->$savedStarRepoArrayList")
        editor.putStringSet(KEY_NAME, savedStarRepoArrayList?.toHashSet())
        editor.apply()
    }

    fun getValueFromLocal(KEY_NAME: String): MutableSet<String>? {
        return sharedPref.getStringSet(KEY_NAME, null)
    }

    fun containsSubString(stringArray: HashSet<String>?, substring: String?): Boolean {
        if (stringArray != null) {
            for (string in stringArray) {
                if (string.contains(substring!!))
                    return true
            }
        }
        return false
    }

    fun scaleAnimation(v:View){
        val anim: Animation = ScaleAnimation(
            1f, 1.4f, 1f, 1.4f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        anim.repeatCount=0
        anim.fillAfter = false // Needed to keep the result of the animation
        anim.duration = 400
        v.startAnimation(anim)
    }
}