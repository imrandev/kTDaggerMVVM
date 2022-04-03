package com.sqgc.ktdaggermvvm.core.adapter

import android.view.View

interface BaseRecyclerItemClickListener<M> {
    fun onClick(v : View, model : M, position : Int)
}