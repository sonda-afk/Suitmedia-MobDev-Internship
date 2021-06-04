package com.sondari.myapplication.catalogue

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sondari.myapplication.api.ApiInstance
import com.sondari.myapplication.api.ApiService
import com.sondari.myapplication.data.ModelGuest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GuestVm : ViewModel() {
    val recyclerViewData = MutableLiveData<ArrayList<ModelGuest>>()

    fun getDataGuest(): MutableLiveData<ArrayList<ModelGuest>> {
        return recyclerViewData
    }

    fun setDataGuest() {
        val retrofitAPI = ApiInstance.getRetrofitAPI().create(ApiService::class.java)
        val call = retrofitAPI.getGuest()
        call.enqueue(object : Callback<ArrayList<ModelGuest>?> {
            override fun onResponse(
                call: Call<ArrayList<ModelGuest>?>,
                response: Response<ArrayList<ModelGuest>?>
            ) {
                if (response.isSuccessful) {
                    recyclerViewData.postValue(response.body())
                } else {
                    return
                }
            }

            override fun onFailure(call: Call<ArrayList<ModelGuest>?>, t: Throwable) {
                Log.d("Failure", t.message.toString())
            }
        })
    }
}