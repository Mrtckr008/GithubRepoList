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
    private val disposable = CompositeDisposable()

    val usersRepoList = MutableLiveData<List<UserRepo>>()
    val repositoryLoading = MutableLiveData<Boolean>()

    fun getUseRepoDataFromApi(){
        /*
        Request to API with method of RxJaxa. Observable has a method called onComplete() that will do the disposing for you when called.
        A backend request is done and the Disposable returned from the subscribe() method is added to the list of CompositeDisposables.
        The moment the Activity will be destroyed, the list of Disposables gets cleared and thats why i use method of disposable.
         */
        disposable.add(
            userRepoAPIService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<UserRepo>>(){
                    override fun onSuccess(t: List<UserRepo>) {
                        Util().hideKeyboard()
                        usersRepoList.value=t
                        repositoryLoading.value=false
                    }

                    override fun onError(e: Throwable) {
                        Util().hideKeyboard()
                        usersRepoList.value= arrayListOf()
                        repositoryLoading.value=true
                        Handler().postDelayed({
                            Toast.makeText(mainActivityContext,"There is no user with the username \"${dynamicUrl}\"",Toast.LENGTH_LONG).show()
                        },400)
                        repositoryLoading.value=false
                    }
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}