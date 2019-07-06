package com.hour24.tumblershare.retrofit

import com.hour24.tumblershare.model.ShopModel
import retrofit2.http.GET
import rx.Single

interface ITumblerService {

    /**
     * 매장 리스트 조회
     * @return
     */
    @GET("/supplier")
    fun reqShopList(): Single<ArrayList<ShopModel>>

}