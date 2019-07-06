package com.hour24.tumblershare.page.near.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hour24.tumblershare.model.ShopModel
import kotlin.math.floor

/**
 * @author jess
 * @since 2019-06-07
 */
class NearShopListViewModel : ViewModel() {

    private val TAG = NearShopListViewModel::class.java.name

    val mList: MutableLiveData<ArrayList<ShopModel>> by lazy {
        MutableLiveData<ArrayList<ShopModel>>()
    }

    lateinit var mModel: ShopModel

    /**
     * 소수점 버리기
     *
     * @return Int 미터 변환
     */
    fun getDistance(): Int {
        return floor(mModel.distance).toInt()
    }

}