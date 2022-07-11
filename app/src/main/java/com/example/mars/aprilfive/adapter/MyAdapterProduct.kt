package com.example.codenamaste.Aprilone.AprilAdapter

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.codenamaste.activity.model.Coffee
import com.example.mars.aprilfive.activity.MainActivityDesignCart
import com.example.mars.R
import com.example.mars.aprilfive.database.CoffeeDatabase
import com.example.mars.aprilfive.model.CategoryItem
import com.example.mars.aprilfive.model.SubcategoryItem
import com.example.mars.databinding.ItemViewProductBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MyAdapterProduct(
    var onclickpro: Onclickproduct,
    //val coffee: List<SubcategoryItem>,
    //var database: CoffeeDatabase,
    var database: CoffeeDatabase,
    private var listjson: ArrayList<SubcategoryItem>,
    var activity: Activity,
    var ab:String


) :

    RecyclerView.Adapter<MyAdapterProduct.MyViewHolder>(), Filterable {
    interface Onclickproduct {
        fun clikRecycle(pos: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        lateinit var database: CoffeeDatabase
        val view = inflater.inflate(R.layout.item_view_product, parent, false)
        val product = ItemViewProductBinding.bind(view)
        return MyViewHolder(product)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val subcategoryproductitems = listjson[position]
        //var pizzasize:Int = 1

            holder.binding.pizzal.setOnClickListener {
                holder.binding.pizzal.setBackgroundResource(R.drawable.round_image);
                holder.binding.pizzar.setBackgroundResource(0);
                holder.binding.pizzax.setBackgroundResource(0);
                ab="l";
                Log.e("Tagggg",ab)

        }

            holder.binding.pizzax.setOnClickListener {

                holder.binding.pizzax.setBackgroundResource(R.drawable.round_image);
                holder.binding.pizzar.setBackgroundResource(0);
                holder.binding.pizzal.setBackgroundResource(0);
                ab="x";
                Log.e("Tagggg",ab)
        }

        holder.binding.pizzar.setOnClickListener {
            holder.binding.pizzar.setBackgroundResource(R.drawable.round_image);
            holder.binding.pizzax.setBackgroundResource(0);
            holder.binding.pizzar.setBackgroundResource(0);
            ab="r";
            Log.e("Tagggg",ab)
        }
        if (subcategoryproductitems != null) {
            holder.binding.tvproductname.text = subcategoryproductitems.name
            holder.binding.tv2.text = subcategoryproductitems.price.toString()
            Glide.with(activity).load(subcategoryproductitems.image).into(holder.binding.imgproduct)
        }


        //holder.binding.tv1.text = coffee[position].name
        //holder.tv1.text = coffee[position].name
        // holder.binding.tv2.text = coffee[position].price.toString()
        // holder.tv2.text = coffee[position].price.toString()
        //  Glide.with(activity).load(coffee[position].image).into(holder.binding.imgproduct)
        holder.binding.tvadd
            .setOnClickListener {
                Log.e("TagAdd", listjson[position].toString())
                GlobalScope.launch {
                    database.CoffeeDAO()
                        .insertCoffee(
                            Coffee(
                                0,
                                listjson[position].name!!,
                                1,
                                listjson[position].price!!.toInt(),
                                listjson[position].image.toString()

                            )
                        )
                }

                activity.startActivity(Intent(activity, MainActivityDesignCart::class.java))


            }


    }

    override fun getItemCount(): Int {
        return listjson.size
    }

    class MyViewHolder(val binding: ItemViewProductBinding) :
        RecyclerView.ViewHolder(binding.root) {

//        var tv1 = itemView.findViewById<TextView>(R.id.tv1)
//        var tvadd = itemView.findViewById<TextView>(R.id.tvadd)
//        var tv2 = itemView.findViewById<TextView>(R.id.tv2)
//        var img = itemView.findViewById<ImageView>(R.id.imgproduct)


//        var pizzaone = itemView.findViewById<TextView>(R.id.pizzal)
//        var pizzatwo = itemView.findViewById<TextView>(R.id.pizzar)
//        var pizzathree = itemView.findViewById<TextView>(R.id.pizzax)

    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                //Log.e("TAGGGG", "edit text values -----$charSearch" )
                if (charSearch.isEmpty()) {
                    val listjson: ArrayList<SubcategoryItem>
                    //  Log.e("TAGGGG", "edit text values ---- )
                    // countryFilterList = countryList as ArrayList<Model>
                } else {
                    val resultList = ArrayList<SubcategoryItem>()
                    for (row in listjson) {
                        if (row.name!!.lowercase().contains(constraint.toString().lowercase())) {
                            // Log.e("TAGGGGG", "edit text values -----${listjson}" )
                            resultList.add(row)
                            //Log.d("list",row.toString())
                        }
                    }
                    listjson = resultList

                }
                val filterResults = FilterResults()
                filterResults.values = listjson
                return filterResults
                //Log.e("filter",filterResults.toString())
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                listjson = results?.values as ArrayList<SubcategoryItem>
                notifyDataSetChanged()
                Log.e("filter", results.toString())
            }
        }
    }

}
