package com.perqin.turbo9search

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * @author perqin
 */
class SearchRecyclerAdapter : RecyclerView.Adapter<SearchRecyclerAdapter.ViewHolder>() {
    var apps = emptyList<App>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(parent.context).inflate(0, parent, false))

    override fun getItemCount() = apps.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
