package ru.sscalliance.ui.base.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T> : RecyclerView.Adapter<BaseViewHolder>() {

    var data: MutableList<T> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(getItemResId(viewType), parent, false)
        return getViewHolder(view, viewType)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    abstract fun getItemResId(viewType: Int): Int

    abstract fun getViewHolder(view: View, viewType: Int): BaseViewHolder

    open fun setItems(data: List<T>) {
        this.data.clear()
        this.data.addAll(data)
    }

    open fun updateAdapter(data: List<T>) {
        setItems(data)
        notifyDataSetChanged()
    }

}

abstract class BaseViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    abstract fun bind(position: Int)
}
