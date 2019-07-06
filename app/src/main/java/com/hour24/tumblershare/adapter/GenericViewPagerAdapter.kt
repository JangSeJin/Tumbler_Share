package com.hour24.with_v2.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import java.util.*

/**
 * Generic ViewPager Adapter
 * FragmentPagerAdapter : Fragment의 개수가 정해진 화면에서 사용
 *
 * @author jess
 * @since 2019-06-07
 */
class GenericViewPagerAdapter(mFragmentManager: FragmentManager) : FragmentPagerAdapter(mFragmentManager) {

    private val mFragments = ArrayList<Fragment>()

    public fun addItem(fragment: Fragment) {
        mFragments.add(fragment)
    }

    override fun getItem(position: Int): Fragment {
        return mFragments[position]
    }

    override fun getCount(): Int {
        return mFragments.size
    }

    override fun getItemPosition(`object`: Any): Int {
        // fragment update
        return POSITION_NONE
    }
}
