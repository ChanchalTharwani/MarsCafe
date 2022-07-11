package com.example.codenamaste.Aprilone.AprilAdapter

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mars.R
import com.example.mars.aprilfive.model.CategoryItem
import com.example.mars.aprilfive.model.ProductItem
import com.example.mars.aprilfive.model.ProductResponse
import com.example.mars.databinding.ActivityMainDesignfourBinding
import com.example.mars.databinding.ItemViewCategoryBinding
import com.example.mars.model.Jsoncategorymodel

class MyAdapterCategory(
    var onclick: Onclikk,
    private val listjson: List<ProductItem?>?,
    var activity: Activity
) :
    RecyclerView.Adapter<MyAdapterCategory.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_view_category, parent, false)
        val category = ItemViewCategoryBinding.bind(view)

        return MyViewHolder(category)
    }

    interface Onclikk {
        fun clikRvv(id: Int) {
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // holder.tv1.text = coffee[position]
        val items = listjson!![position]
        if (items != null) {
            holder.binding.tvcategory.text = items.name
        }

         holder.binding.tvcategory.text = listjson[position]!!.name
        if (items != null) {
            Glide.with(activity).load(items.image).into(holder.binding.img1)
        }
        //Glide.with(activity).load(listjson[position].image).into(holder.img)
//        items.name?.let { Log.d("helllllllllllooloo", it) }
        holder.itemView.setOnClickListener {
            // Log.e("tag", "clicked ")
            //pid
            onclick.clikRvv(items!!.id!!)
            // Log.d("alldata",items.toString())
            // Log.d("tag",items!!.id!!.toString())
            //Log.d("alldata",it.toString())
        }
        //  items!!.name?.let { Log.d("helllllllllllooloo", it) }

    }

    override fun getItemCount(): Int {
        return listjson?.size ?: 0
    }

    class MyViewHolder(val binding: ItemViewCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)
}