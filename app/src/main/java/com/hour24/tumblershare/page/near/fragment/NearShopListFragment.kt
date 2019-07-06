package com.hour24.tumblershare.page.near.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.hour24.tb.adapter.GenericRecyclerViewAdapter
import com.hour24.tumblershare.R
import com.hour24.tumblershare.databinding.NearShopListFragmentBinding
import com.hour24.tumblershare.databinding.NearShopListItemBinding
import com.hour24.tumblershare.model.ShopModel
import com.hour24.tumblershare.page.near.viewmodel.NearShopListViewModel
import com.hour24.with_v2.view.fragment.NearShopBaseFragment

/**
 *
 * 내 주변 매장 리스트
 *
 * @author jess
 * @since 2019-06-07
 */
class NearShopListFragment : NearShopBaseFragment() {

    private val TAG = NearShopListFragment::class.java.name

    private lateinit var mBinding: NearShopListFragmentBinding
    private lateinit var mViewModel: NearShopListViewModel
    private lateinit var mAdapter: GenericRecyclerViewAdapter<ShopModel, NearShopListItemBinding>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.near_shop_list_fragment, container, false)
        return mBinding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        initAdapter()
        initLayout()

    }

    /**
     * ViewModel 초기화
     */
    private fun initViewModel() {

        mViewModel =
            ViewModelProviders.of(activity!!).get(NearShopListViewModel::class.java).apply {
                this.mList.observe(activity!!, Observer {

                    mAdapter.run {
                        clear()
                        addAll(it)
                    }
                })
            }
    }

    /**
     * Adapter 선언
     */
    private fun initAdapter() {

        mAdapter = object :
            GenericRecyclerViewAdapter<ShopModel, NearShopListItemBinding>(
                activity,
                R.layout.near_shop_list_item
            ) {

            override fun onBindData(
                position: Int,
                model: ShopModel,
                dataBinding: NearShopListItemBinding
            ) {

                try {

                    val viewModel = NearShopListViewModel()
                    viewModel.mModel = model
                    dataBinding.viewModel = viewModel

                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
        }

    }

    /**
     * 레이아웃 초기화
     */
    private fun initLayout() {

        mBinding.rvList.apply {

            // 레이아웃 매니저
            layoutManager = LinearLayoutManager(activity)

            // adapter
            adapter = mAdapter

        }
    }

    override fun setShopList(list: ArrayList<ShopModel>) {
        mBinding.pbList.visibility = View.GONE
        mViewModel.mList.postValue(list)
    }
}