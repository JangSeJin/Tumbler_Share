package com.hour24.with_v2.view.fragment

import androidx.fragment.app.Fragment
import com.hour24.tumblershare.model.ShopModel

/**
 *
 * 내 주변 매장 리스트
 *
 * @author jess
 * @since 2019-06-07
 */
open class NearShopBaseFragment : Fragment() {

    private val TAG = NearShopBaseFragment::class.java.name

    open fun setShopList(list: ArrayList<ShopModel>) {

    }

}