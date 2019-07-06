package com.hour24.tumblershare.retrofit

import com.hour24.tumblershare.model.ShopModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Single

interface ITumblerService {

    /**
     * 매장 리스트 조회
     * @return
     */
    @GET("/supplier/location")
    fun reqShopList(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ): Single<ArrayList<ShopModel>>

}