package com.example.mars.aprilfive.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.mars.MyAdapterCart
import com.example.mars.R
import com.example.mars.aprilfive.database.CoffeeDatabase
import com.example.mars.databinding.FragmentCartBinding
import com.example.mars.databinding.FragmentHistoryBinding
import kotlinx.android.synthetic.main.activity_main_design_cart.*


class FragmentHistory : Fragment() {
    lateinit var database: CoffeeDatabase
    private lateinit var binding:FragmentHistoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_history, container, false)
        database = Room.databaseBuilder(requireActivity(), CoffeeDatabase::class.java, "coffeeDb")
            .build()
       // getdata()
        return binding.root

        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_history, container, false)
    }

//    private fun getdata() {
//        database.CoffeeDAO().getCoffee().observe(requireActivity(), Observer {
//            //Log.d("chanchal", it.toString())
////                it.forEach { it-> Log.d("chanchal", it.id.toString())
////}
//            Log.e("Taggg", it.size.toString())
//
//            recyclcart.adapter = MyAdapterCart(it, database, object : MyAdapterCart.click {
//                override fun clickRv() {
//                    //callback
//                    //getData()
//                }
//            })
//
//            recyclcart.layoutManager = object : LinearLayoutManager(requireActivity()) {
//            }
//
//
//
//            var totalPrice = 0
//            it.forEach {
//                totalPrice = totalPrice + (it.qty * it.price)
//            }
//            tv4.text = (totalPrice).toString()//SUBTOTAL
//            tv10.text = (totalPrice).toString()//TOTAL
//        })
//    }

}
