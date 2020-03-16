package com.example.githubrepolist.viewmodel

import android.os.Handler
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubrepolist.model.UserRepo
import com.example.githubrepolist.service.UserRepoAPIService
import com.example.githubrepolist.service.UserRepoAPIService.Companion.dynamicUrl
import com.example.githubrepolist.utils.Util
import com.example.githubrepolist.view.MainActivity.Companion.mainActivityContext
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers


class UserRepoViewModel: ViewModel() {
    private val userRepoAPIService = UserRepoAPIService()
    private val disposable = CompositeDisposable()          // her calldan sonra hafızayı boşaltmak için ders 34-2:36,

    val usersRepoList = MutableLiveData<List<UserRepo>>()

    fun getUseRepoDataFromApi(){
        disposable.add(
            userRepoAPIService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<UserRepo>>(){
                    override fun onSuccess(t: List<UserRepo>) {
                        Util().hideKeyboard()
                        usersRepoList.value=t
                    }

                    override fun onError(e: Throwable) {
                        Util().hideKeyboard()
                        usersRepoList.value= arrayListOf()
                        Handler().postDelayed({
                            Toast.makeText(mainActivityContext,"There is no user with the username \"${dynamicUrl}\".",Toast.LENGTH_LONG).show()
                        },400)
                    }
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}