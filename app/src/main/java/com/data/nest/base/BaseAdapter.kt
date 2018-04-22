package com.data.nest.base

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.ArrayList

/**
 * Created by n on 2018/4/22.
 */
abstract class BaseAdapter<T, Holder : RecyclerView.ViewHolder>(val context: Context) : RecyclerView.Adapter<Holder>() {

    private var data: List<T>? = null

    fun setData(data: List<T>) {
        this.data = data
    }

    fun addData(data: MutableList<T>?) {
        var data = data
        if (data == null) {
            data = ArrayList()
        }
        data.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder? {
        return newHolder(parent, viewType)
    }

    fun inflate(parent: ViewGroup, layoutRes: Int): View {
        return LayoutInflater.from(context).inflate(layoutRes, parent, false)
    }

    protected abstract fun newHolder(parent: ViewGroup, viewType: Int): Holder

    override fun getItemCount(): Int {
        return if (data == null) 0 else data!!.size
    }
}
