package com.example.githubrepolist.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubrepolist.Model.UserRepo
import com.example.githubrepolist.Service.UserRepoAPIService
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
                        usersRepoList.value=t
                    }

                    override fun onError(e: Throwable) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                })
        )
    }

}