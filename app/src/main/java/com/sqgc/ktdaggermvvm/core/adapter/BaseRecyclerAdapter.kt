package com.sqgc.ktdaggermvvm.core.adapter

import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<M, L : BaseRecyclerItemClickListener<M>>(private val items: List<M>, private val listener: L?) : RecyclerView.Adapter<BaseViewHolder<M, L>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<M, L> {
        return onCreateHolder(parent)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<M, L>, position: Int) {
        if (listener != null){
            holder.onBind(model = items[position], listener = listener)
        } else {
            holder.onBind()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    protected abstract fun onCreateHolder(@NonNull parent: ViewGroup) : BaseViewHolder<M, L>
}