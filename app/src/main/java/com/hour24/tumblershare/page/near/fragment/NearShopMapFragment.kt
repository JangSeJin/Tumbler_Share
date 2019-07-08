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
import com.hour24.tumblershare.utils.Logger
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*
import com.naver.maps.map.overlay.Marker
import kotlinx.android.synthetic.main.near_shop_map_fragment.*
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
    private var mMap: NaverMap? = null

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

        val fm = childFragmentManager
        val mapFragment = fm.findFragmentById(R.id.map_view) as MapFragment?
            ?: MapFragment.newInstance().also {
                fm.beginTransaction().add(R.id.map_view, it).commitAllowingStateLoss()
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
        setMapUi()

    }

    /**
     * 지도 객체 준비
     *
     * @param map
     */
    @UiThread
    override fun onMapReady(map: NaverMap) {
        Logger.e(TAG, "onMapReady")
        mMap = map
        setMapUi()
    }


    /**
     * 지도 UI
     */
    private fun setMapUi() {

        if (mList.isEmpty() || mMap == null) {
            return
        }

        mMap!!.locationTrackingMode = LocationTrackingMode.Follow

        val cameraUpdate = CameraUpdate.scrollTo(LatLng(37.574686, 126.9768213))
        mMap!!.moveCamera(cameraUpdate)

        val uiSettings = mMap!!.uiSettings
        uiSettings.isLocationButtonEnabled = true

        mList.forEach {
            try {
                setMarker(mMap!!, it)
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