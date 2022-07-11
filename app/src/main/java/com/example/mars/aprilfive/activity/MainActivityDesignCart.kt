package com.example.mars.aprilfive.activity

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.mars.MyAdapterCart
import com.example.mars.R
import com.example.mars.aprilfive.adapter.MyAdapterFivePayment
import com.example.mars.aprilfive.database.CoffeeDatabase
import kotlinx.android.synthetic.main.activity_main_design_cart.*
import kotlinx.android.synthetic.main.custome_details_dialog.view.*
import kotlinx.android.synthetic.main.item_view_product.*


class MainActivityDesignCart : AppCompatActivity(), MyAdapterCart.click {
    lateinit var database: CoffeeDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_design_cart)
        database = Room.databaseBuilder(this, CoffeeDatabase::class.java, "coffeeDb")
            .build()

        tv11.setOnClickListener {
            val dialog = LayoutInflater.from(this).inflate(R.layout.custome_details_dialog, null)
            val builder = AlertDialog.Builder(this)
                .setView(dialog)
                .setTitle("Custome Details")
            dialog.cardview4.setOnClickListener {
                val dialog = LayoutInflater.from(this).inflate(R.layout.customize_order_detail, null)
                val builder1 = AlertDialog.Builder(this)
                    .setView(dialog)
                    .setTitle("Customize Order")

                val mAlertDialog = builder1.show()
            }

            val mAlertDialog = builder.show()
        }
        val coffee = listOf<String>("Frappe", "Frappe", "Frappe")
        val payment = listOf<String>("Cash", "Debit", "E-wallet")
        recyclpayment.adapter = MyAdapterFivePayment(payment)
        recyclpayment.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val profileName=intent.getStringExtra("ab")
        Log.e("TagprofileName", profileName.toString())

        getData()
    }

    fun getData() {
        database.CoffeeDAO().getCoffee().observe(this, Observer {
            //Log.d("chanchal", it.toString())
//                it.forEach { it-> Log.d("chanchal", it.id.toString())
//}
            Log.e("Taggg", it.size.toString())

            recyclcart.adapter = MyAdapterCart(it, database, object : MyAdapterCart.click {
                override fun clickRv() {
                    //callback
                    getData()
                }
            })

            recyclcart.layoutManager = object : LinearLayoutManager(this) {
            }



            var totalPrice = 0
            it.forEach {
                totalPrice = totalPrice + (it.qty * it.price)
            }
            tv4.text = (totalPrice).toString()//SUBTOTAL
            tv10.text = (totalPrice).toString()//TOTAL
        })
    }
}

//            var ab = ""
//
//            if (ab==pizzal.toString()){
//                pizzal.text.toString()
//                Log.d("lll",ab)
//              //  getData()
//            }
            //getData()


//            var size = 0
//            if (size==1){
//                pizzal.text = pizzal.toString()
//                //Log.e("pizza", size.toString())
//            }
//
