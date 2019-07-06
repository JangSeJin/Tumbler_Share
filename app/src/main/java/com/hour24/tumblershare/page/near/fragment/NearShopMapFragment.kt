package com.hour24.with_v2.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.UiThread
import androidx.databinding.DataBindingUtil
import com.hour24.tumblershare.R
import com.hour24.tumblershare.databinding.NearShopMapFragmentBinding
import com.hour24.tumblershare.model.ShopModel
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.LocationTrackingMode
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.overlay.InfoWindow
import com.naver.maps.map.overlay.Marker
import java.lang.Exception

/**
 * 내 주변 매장 지도
 *
 * @author jess
 * @since 2019-06-07
 */
class NearShopMapFragment : NearShopBaseFragment(), OnMapReadyCallback {

    private val TAG = NearShopMapFragment::class.java.name

    private lateinit var mBinding: NearShopMapFragmentBinding

    private var mList: ArrayList<ShopModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.near_shop_map_fragment, container, false)
        return mBinding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        initLayout()

    }


    /**
     * 레이아웃 초기화
     */
    private fun initLayout() {

        val fm = activity!!.supportFragmentManager
        val mapFragment = fm.findFragmentById(R.id.map_view) as MapFragment?
            ?: MapFragment.newInstance().also {
                fm.beginTransaction().add(R.id.map_view, it).commit()
            }

        mapFragment.getMapAsync(this)
    }

    /**
     * 매장 데이터 세팅
     *
     * @param list
     */
    override fun setShopList(list: ArrayList<ShopModel>) {
        mList.apply {
            clear()
            addAll(list)
        }
    }

    /**
     * 지도 객체 준비
     *
     * @param map
     */
    @UiThread
    override fun onMapReady(map: NaverMap) {

        map.locationTrackingMode = LocationTrackingMode.Follow

        val uiSettings = map.uiSettings
        uiSettings.isLocationButtonEnabled = true

        mList.forEach {
            try {
                setMarker(map, it)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    /**
     * 마커 설정
     *
     * @param map 네이버 지도 객체
     * @param shop 매장 정보
     */
    private fun setMarker(map: NaverMap, shop: ShopModel) {
        val marker = Marker()
        marker.position =
            LatLng(shop.latitude.toDouble(), shop.longitude.toDouble())
        marker.map = map
    }

}