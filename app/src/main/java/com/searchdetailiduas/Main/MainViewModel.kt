package com.searchdetailiduas.Main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.searchdetailiduas.Model.RespondUser
import com.searchdetailiduas.Model.User
import com.searchdetailiduas.api.Client
import retrofit2.Call
import  retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    val listUsers = MutableLiveData<ArrayList<User>>()

    fun setSearchUsers(query: String) {
        Client.apiInstance
            .getSearchUser(query)
            .enqueue(object : Callback<RespondUser> {
                override fun onResponse(call: Call<RespondUser>, response: Response<RespondUser>) {
                    if (response.isSuccessful) {
                        listUsers.postValue(response.body()?.item)
                    }
                }

                override fun onFailure(call: Call<RespondUser>, t: Throwable) {
                    t.message?.let { Log.d("Failure", it) }
                }

            })
    }

    fun getSearchUser(): LiveData<ArrayList<User>>{
        return listUsers
    }
}