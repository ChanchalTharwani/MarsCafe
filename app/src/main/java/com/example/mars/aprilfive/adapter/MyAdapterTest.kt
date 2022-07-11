package com.example.mars.aprilfive.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codenamaste.activity.model.Coffee
import com.example.mars.R
import com.example.mars.aprilfive.database.CoffeeDatabase
import com.example.mars.databinding.ItemViewTestBinding
import java.nio.file.Files.size

class MyAdapterTest( var coffeeeee: List<Coffee>,
                    var database: CoffeeDatabase,): RecyclerView.Adapter<MyAdapterTest.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from((parent.context))
        val view = inflater.inflate(R.layout.item_view_test, parent, false)
        val a = ItemViewTestBinding.bind(view)

        return MyViewHolder(a)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.textview.text = coffeeeee[position].name
       // holder.binding.textview.text = coffeeeee[position].price.toString()


//     holder.button.setOnClickListener {
//         startActivity(Intent(this, MainActivity ::class.java))
//
//     }

    }

    override fun getItemCount(): Int {
        return coffeeeee.size
    }

    class MyViewHolder(val binding: ItemViewTestBinding) : RecyclerView.ViewHolder(binding.root) {
//    var button = itemView.findViewById<TextView>(R.id.btn1)

    }
}


