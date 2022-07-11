package com.example.mars.aprilfive.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mars.R
import com.example.mars.databinding.ItemViewFivePaymentBinding

class MyAdapterFivePayment (val coffeeeeeee:List<String>): RecyclerView.Adapter<MyAdapterFivePayment.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_view_five_payment,parent,false)
        val payment =  ItemViewFivePaymentBinding.bind(view)
        return MyViewHolder(payment)
    }

    override fun onBindViewHolder(holder: MyViewHolder,position: Int) {
        //holder.tv1.text = coffeeeeeee[position]
        holder.binding.tvproductname.text = coffeeeeeee[position]
    }

    override fun getItemCount(): Int {
        return coffeeeeeee.size
    }

    class MyViewHolder(val binding:ItemViewFivePaymentBinding): RecyclerView.ViewHolder(binding.root) {
        //var tv1= itemView.findViewById<TextView>(R.id.tv1)
    }
}