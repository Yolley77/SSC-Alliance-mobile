package ru.sscalliance.ui.base.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T> : RecyclerView.Adapter<BaseViewHolder>() {

    var data: MutableList<T> = mutableListOf()

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = data.size

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
