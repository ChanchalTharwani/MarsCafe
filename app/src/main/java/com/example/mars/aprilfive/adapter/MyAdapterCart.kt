package com.example.mars

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.codenamaste.activity.model.Coffee
import com.example.mars.aprilfive.database.CoffeeDatabase
import com.example.mars.databinding.ItemViewFourCartBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MyAdapterCart(
    val coffeeeee: List<Coffee>,
    var database: CoffeeDatabase,
    var onClick: click
) :
    RecyclerView.Adapter<MyAdapterCart.MyViewHolder>() {

    interface click {
        fun clickRv() {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        lateinit var database: CoffeeDatabase
        val inflater = LayoutInflater.from(parent.context)
        //var i:Int = 0

        val view = inflater.inflate(R.layout.item_view_four_cart, parent, false)
        val cart = ItemViewFourCartBinding.bind(view)

        return MyViewHolder(cart)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.tvproductname.text = coffeeeee[position].name
        holder.binding.tv2.text = coffeeeee[position].price.toString()
        holder.binding.tv4444.text = coffeeeee[position].qty.toString()

//        holder.tv1.text = coffeeeee[position].name
//        holder.tv2.text = coffeeeee[position].price.toString()
//        holder.text.text = coffeeeee[position].qty.toString()

        //Log.e("price>>>", coffeeeee[position].price.toString())
        //Log.e("name>>>", coffeeeee[position].name + " " + coffeeeee[position].price)
        //Log.e("2","print")
        holder.binding.tv6.text = (coffeeeee[position].price * coffeeeee[position].qty).toString()
        holder.binding.tvAddddd.setOnClickListener {
            GlobalScope.launch {
                database.CoffeeDAO().updateCoffee(
                    Coffee(
                        coffeeeee[position].id,
                        coffeeeee[position].name,
                        coffeeeee[position].qty + 1,
                        coffeeeee[position].price
                    )
                )

            }
            //click
            onClick.clickRv()
        }
//        holder.textt.text = (holder.text.text.toString().toInt() + 1).toString()
        holder.binding.tv55555.setOnClickListener {
            GlobalScope.launch {

                if (coffeeeee[position].qty.toString().toInt() <= 1) {
                    database.CoffeeDAO().deleteCoffee(coffeeeee[position].id)
                } else {
                    database.CoffeeDAO().updateCoffee(
                        Coffee(
                            coffeeeee[position].id,
                            coffeeeee[position].name,
                            coffeeeee[position].qty - 1,
                            coffeeeee[position].price
                        )
                    )
                }
                //Log.e("chanchu", "1")
            }
            onClick.clickRv()
           // Log.e("chanchu", "2")
        }
    }


    override fun getItemCount(): Int {
        Log.e("coffeeeee.size",""+coffeeeee.size)
        return coffeeeee.size
    }

    class MyViewHolder(val binding:ItemViewFourCartBinding) : RecyclerView.ViewHolder(binding.root) {
//        var tv1 = itemView.findViewById<TextView>(R.id.tv1)
//        var tv2 = itemView.findViewById<TextView>(R.id.tv2)
//        var tv6 = itemView.findViewById<TextView>(R.id.tv6)
//        var tvplus = itemView.findViewById<TextView>(R.id.tvAddddd)
//        var tvminus = itemView.findViewById<TextView>(R.id.tv55555)
//        var text = itemView.findViewById<TextView>(R.id.tv4444)
    }
}