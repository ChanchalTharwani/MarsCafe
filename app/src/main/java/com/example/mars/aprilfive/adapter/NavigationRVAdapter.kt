package com.example.mars.aprilfive.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.codenamaste.activity.model.NavigationItemModel
import com.example.mars.R
import kotlinx.android.synthetic.main.row_nav_drawer.view.*

class NavigationRVAdapter(private var items: ArrayList<NavigationItemModel>, private var currentPos: Int) :RecyclerView.Adapter<NavigationRVAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem = LayoutInflater.from(parent.context).inflate(R.layout.row_nav_drawer, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {
        if (position == currentPos) {
//            holder.itemView.constraint.setBackgroundColor(ContextCompat.getColor(context, R.color.Brown))
            holder.itemView.cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.Brown));
//            holder.itemView.navigation_icon.setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP)
            holder.itemView.navigation_title.setTextColor(Color.WHITE)
        } else {
//            holder.itemView.constraint.setBackgroundColor(ContextCompat.getColor(context, R.color.Brown))

            holder.itemView.cardView.setCardBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
        }
//        holder.itemView.navigation_icon.setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP)
        holder.itemView.navigation_title.setTextColor(Color.BLACK)
        holder.itemView.navigation_title.text = items[position].title
        holder.itemView.navigation_icon.setImageResource(items[position].icon)
    }
}