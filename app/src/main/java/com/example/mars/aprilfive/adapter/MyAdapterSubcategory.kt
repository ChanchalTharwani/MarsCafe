package com.example.codenamaste.Aprilone.AprilAdapter

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mars.R
import com.example.mars.aprilfive.model.CategoryItem
import com.example.mars.databinding.ItemViewTwoBinding

class MyAdapterSubcategory(
    var onclick: Clickkk,
    private val listjson: List<CategoryItem>,
    var activity: Activity

) :
    RecyclerView.Adapter<MyAdapterSubcategory.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_view_two, parent, false)
        val subcategory = ItemViewTwoBinding.bind(view)
        return MyViewHolder(subcategory)
    }

    interface Clickkk {
        fun clickRvvv(id: Int) {

        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val subcategoryitems = listjson!![position]
        if (subcategoryitems != null) {
            holder.binding.tvsubcategory.text = subcategoryitems.name
            subcategoryitems.name?.let { Log.d("dataprint", it) }
            //Log.d("alldataprint",subcategoryitems.toString())
            //subcategoryitems.name?.let { Log.d("dataprint", it) }

        }

      //  holder.binding.tvsubcategory.text = listjson[position].name

        holder.itemView.setOnClickListener {
           // Log.d("alldataprint",subcategoryitems.toString())
            onclick.clickRvvv(subcategoryitems!!.cId!!)
            Log.d("alldataprint",subcategoryitems.toString())
            //Log.d("alldataprint",it.toString())

//            holder.itemView.setOnClickListener {
//                onclick.clickRvvv()
//
//
//                subcategoryitems.name?.let { Log.d("dataaaaa", it) }
//
//
//            }
            //subcategoryitems.name?.let { Log.d("dataaaaa", it) }


         //   Log.d("alldataprint",subcategoryitems.toString())


          //  subcategoryitems.name?.let { Log.d("dataaaaa", it) }


        }


    }

    override fun getItemCount(): Int {
        return listjson.size
    }

    class MyViewHolder(val binding: ItemViewTwoBinding) : RecyclerView.ViewHolder(binding.root)
}