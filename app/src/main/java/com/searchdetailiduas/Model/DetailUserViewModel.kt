package com.searchdetailiduas.Model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.searchdetailiduas.api.Client
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailUserViewModel : ViewModel() {
    val user = MutableLiveData<DetailUserRespond>()

    fun setUserDetail(Username: String) {
        Client.apiInstance
            .getDetail(Username)
            .enqueue(object : Callback<DetailUserRespond> {
                override fun onResponse(
                    call: Call<DetailUserRespond>,
                    response: Response<DetailUserRespond>
                ) {
                    if (response.isSuccessful) {
                        user.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<DetailUserRespond>, t: Throwable) {
                    t.message?.let { Log.d("Failure", it) }
                }

            })
    }

    fun getUserDetail(): LiveData<DetailUserRespond> {
        return user
    }

    private fun Any.enqueue(callback: Callback<DetailUserRespond>) {

    }
}


