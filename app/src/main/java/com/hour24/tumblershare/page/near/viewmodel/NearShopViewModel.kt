package com.hour24.tumblershare.page.near.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hour24.tumblershare.model.ShopModel
import com.hour24.tumblershare.retrofit.ITumblerService
import com.hour24.tumblershare.utils.Logger
import com.hour24.with_v2.consts.HostConst
import com.hour24.with_v2.retrofit.RetrofitRequest
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * @author jess
 * @since 2019-06-07
 */
class NearShopViewModel : ViewModel() {

    private val TAG = NearShopViewModel::class.java.name

    val mList: MutableLiveData<ArrayList<ShopModel>> by lazy {
        MutableLiveData<ArrayList<ShopModel>>()
    }

    /**
     * 데이터 통신 후 list에 반영
     */
    fun getShopList() {

        val service = RetrofitRequest.createService(ITumblerService::class.java, HostConst.domain)
        service.reqShopList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mList.postValue(it)
            }) {
                Logger.e(TAG, it.message)
            }

    }
}