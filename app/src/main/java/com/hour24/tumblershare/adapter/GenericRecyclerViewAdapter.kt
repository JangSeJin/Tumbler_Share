package com.hour24.tb.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * Generic RecyclerView Adapter for DataBinding
 *
 * @author jess
 * @since 2019-06-07
 */
@Suppress("UNCHECKED_CAST")
//abstract class GenericRecyclerViewAdapter<T : Any, in D : ViewDataBinding>(
//    private val mContext: Context?, private val mLayoutId: Int, private var mList: ArrayList<T>
//) : RecyclerView.Adapter<GenericRecyclerViewAdapter.ViewHolder>() {

abstract class GenericRecyclerViewAdapter<T : Any, in D : ViewDataBinding>(
    val mContext: Context?,
    val mLayoutId: Int,
    val mList: ArrayList<T> = ArrayList()
) : RecyclerView.Adapter<GenericRecyclerViewAdapter.ViewHolder>() {

//    constructor(mContext: Context, mLayoutId: Int, mList: ArrayList<T>) : this(mContext, mLayoutId)

    abstract fun onBindData(position: Int, model: T, dataBinding: D)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val dataBinding =
            DataBindingUtil.inflate<ViewDataBinding>(
                LayoutInflater.from(parent.context),
                mLayoutId,
                parent,
                false
            )
        return ViewHolder(dataBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        try {
            onBindData(position, mList[position], holder.mDataBinding as D)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    override fun getItemCount(): Int {
        return if (mList.isNotEmpty()) mList.size else 0
    }

    fun clear() {
        mList.clear()
    }

    /**
     * addAll List
     */
    fun addAll(list: ArrayList<T>) {
        mList.addAll(list)
        notifyDataSetChanged()
    }

    fun addItem(item: T) {
        mList.add(item)
        notifyDataSetChanged()
    }

    fun getItem(position: Int): T {
        return mList[position]
    }

    override fun getItemId(position: Int): Long {
        return try {
            mList[position].hashCode().toLong()
        } catch (e: Exception) {
            e.printStackTrace()
            0
        }

    }

    class ViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        var mDataBinding: ViewDataBinding = binding
    }

//    mAdapter = object : GenericRecyclerViewAdapter<Product, ListItemBinding>(activity, R.layout.list_item) {
//
//        override fun onBindData(position: Int, model: Product, dataBinding: ListItemBinding) {
//
//            try {
//
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//
//        }
//    }
}
