package com.data.nest.fragment

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.data.nest.R
import com.data.nest.base.BaseAdapter

/**
 * Created by n on 2018/4/22.
 */
class FictionFragment : BaseFragment() {

    private lateinit var listView: RecyclerView

    override fun createView(): Int {
        return R.layout.layout_recycler_view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        listView = view!!.findViewById(R.id.fg_fiction_view)
        listView.adapter = Adapter(context)
        listView.layoutManager = LinearLayoutManager(context)
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)

    internal inner class Adapter(context: Context) : BaseAdapter<String, Holder>(context) {
        override fun onBindViewHolder(holder: Holder?, position: Int) {
        }

        override fun newHolder(parent: ViewGroup, viewType: Int): Holder {
            return Holder(inflate(parent, R.layout.item_fiction))
        }

        override fun getItemCount(): Int {
            return 10
        }
    }
}