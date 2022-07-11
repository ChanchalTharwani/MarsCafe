package com.example.mars.aprilfive.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.codenamaste.activity.model.Coffee
import com.example.mars.R

class MyAdapterOrder(val coffeeeeeee:List<Coffee>): RecyclerView.Adapter<MyAdapterOrder.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_view_order,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder,position: Int) {
        holder.tv1.text = coffeeeeeee[position].name
        holder.tv2.text = coffeeeeeee[position].qty.toString()
        holder.tv3.text = coffeeeeeee[position].price.toString()
        holder.subtotal.text = (coffeeeeeee[position].price * coffeeeeeee[position].qty).toString()


    }

    override fun getItemCount(): Int {
        return coffeeeeeee.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tv1= itemView.findViewById<TextView>(R.id.tv1)
        var tv2 = itemView.findViewById<TextView>(R.id.tv2)
        var tv3 = itemView.findViewById<TextView>(R.id.tv3)
        var subtotal = itemView.findViewById<TextView>(R.id.tvsubtotal)
    }
}