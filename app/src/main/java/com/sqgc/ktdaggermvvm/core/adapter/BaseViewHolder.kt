package com.sqgc.ktdaggermvvm.core.adapter

import android.view.View
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.sqgc.ktdaggermvvm.core.utils.Constant

public abstract class BaseViewHolder<M, L : BaseRecyclerItemClickListener<M>>(@NonNull binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    private var lastClickedTime : Long = System.currentTimeMillis();

    abstract fun onBind()
    abstract fun onBind(model: M)
    abstract fun onBind(model: M, listener: L)
    abstract fun onBind(model: M, listener: L, position: Int)

    protected fun enableClickItem(model: M, listener: L) {
        itemView.setOnClickListener {
            val now = System.currentTimeMillis()
            if (now - lastClickedTime > Constant.CLICK_TIME_INTERVAL){
                return@setOnClickListener
            }
            lastClickedTime = now
            listener.onClick(it, model, adapterPosition)
        }
    }

    protected fun enableLongClickItem(model: M, listener: L) {
        itemView.setOnLongClickListener(View.OnLongClickListener {
            val now = System.currentTimeMillis()
            if (now - lastClickedTime > Constant.CLICK_TIME_INTERVAL){
                return@OnLongClickListener false
            }
            lastClickedTime = now
            listener.onClick(it, model, adapterPosition)
            return@OnLongClickListener true
        })
    }

    protected fun enableCustomClickItem(v: View, model: M, listener: L) {
        v.setOnClickListener {
            val now = System.currentTimeMillis()
            if (now - lastClickedTime > Constant.CLICK_TIME_INTERVAL){
                return@setOnClickListener
            }
            lastClickedTime = now
            listener.onClick(it, model, adapterPosition)
        }
    }
}