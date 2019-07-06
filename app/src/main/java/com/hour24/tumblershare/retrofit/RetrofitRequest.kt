package com.hour24.with_v2.retrofit

import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitRequest {

    //JSON
    fun <T> createService(classes: Class<T>, url: String): T {

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .baseUrl(url)
            .build()

        return retrofit.create(classes)
    }

}
