package com.example.mars.aprilfive.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.mars.MyAdapterCart
import com.example.mars.R
import com.example.mars.aprilfive.adapter.MyAdapterFivePayment
import com.example.mars.aprilfive.adapter.MyAdapterOrder
import com.example.mars.aprilfive.database.CoffeeDatabase
import com.example.mars.databinding.ActivityMainDesignCartBinding
import com.example.mars.databinding.ActivityMainDesignfourBinding
import com.example.mars.databinding.FragmentCartBinding
import kotlinx.android.synthetic.main.activity_main_design_cart.*
import kotlinx.android.synthetic.main.custome_details_dialog.view.*


class FragmentCart : Fragment() {
    lateinit var database: CoffeeDatabase
    private lateinit var binding: FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//         Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false)

        database = Room.databaseBuilder(requireActivity(), CoffeeDatabase::class.java, "coffeeDb")
            .build()

    getdata()
        return binding.root
    }

    private fun getdata() {
        database.CoffeeDAO().getCoffee().observe(requireActivity(), Observer {
            //Log.d("chanchal", it.toString())
//                it.forEach { it-> Log.d("chanchal", it.id.toString())
//}
            Log.e("Taggg", it.size.toString())

          binding.rvOrder.adapter = MyAdapterOrder(it)

            binding.rvOrder.layoutManager = object : LinearLayoutManager(requireActivity()) {
            }

//            var totalPrice = 0
//            it.forEach {
//                totalPrice = totalPrice + (it.qty * it.price)
//            }
//            tv4.text = (totalPrice).toString()//SUBTOTAL
//            tv10.text = (totalPrice).toString()//TOTAL
        })
    }

}




