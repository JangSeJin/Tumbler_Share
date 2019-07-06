package com.hour24.tumblershare.page.near.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.hour24.tumblershare.R
import com.hour24.tumblershare.databinding.NearShopActivityBinding
import com.hour24.tumblershare.page.near.viewmodel.NearShopViewModel
import com.hour24.tumblershare.utils.Logger
import com.hour24.with_v2.adapter.GenericViewPagerAdapter
import com.hour24.with_v2.view.fragment.NearShopBaseFragment
import com.hour24.tumblershare.page.near.fragment.NearShopListFragment
import com.hour24.with_v2.view.fragment.NearShopMapFragment
import kotlinx.android.synthetic.main.near_shop_activity.*

/**
 * 내 주변 매장
 *
 * @author jess
 * @since 2019-06-07
 */
class NearShopActivity : AppCompatActivity() {

    private val TAG = NearShopActivity::class.java.name

    private lateinit var mBinding: NearShopActivityBinding
    private lateinit var mViewModel: NearShopViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.near_shop_activity)

        initViewModel()
        initLayout()
        initEventListener()
        getLocation()

    }

    /**
     * ViewModel 초기화
     */
    private fun initViewModel() {
        mViewModel = ViewModelProviders.of(this).get(NearShopViewModel::class.java).apply {
            this.mList.observe(this@NearShopActivity, Observer {
                Logger.e(TAG, it.toString())

                val adapter = mBinding.vpShop.adapter as GenericViewPagerAdapter
                for (i in 0..1) {
                    val fragment = adapter.getItem(i) as NearShopBaseFragment
                    fragment.setShopList(it)
                }

            })
        }
    }

    /**
     * Layout 초기화
     *
     */
    private fun initLayout() {

        cb_list.isChecked = true
        cb_map.isChecked = false

        runOnUiThread {
            // ViewPager
            mBinding.vpShop.adapter = GenericViewPagerAdapter(supportFragmentManager).apply {
                addItem(NearShopListFragment())
                addItem(NearShopMapFragment())
            }
        }

    }

    /**
     * eventListener 초기화
     */
    private fun initEventListener() {

        mBinding.vpShop.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                if (position == 0) {
                    mBinding.cbList.isChecked = true
                    mBinding.cbMap.isChecked = false
                } else {
                    mBinding.cbList.isChecked = false
                    mBinding.cbMap.isChecked = true
                }
            }

        })

    }

    private fun getLocation() {
        mViewModel.getShopList(37.574686, 126.9768213)
    }

}
