package com.example.mars


import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.codenamaste.Aprilone.AprilAdapter.MyAdapterCategory
import com.example.codenamaste.Aprilone.AprilAdapter.MyAdapterProduct
import com.example.codenamaste.Aprilone.AprilAdapter.MyAdapterSubcategory
import com.example.codenamaste.activity.model.Coffee
import com.example.mars.aprilfive.activity.SubcategoryProductService
import com.example.mars.aprilfive.activity.SubcategoryService
import com.example.mars.aprilfive.activity.ĘxcelService
import com.example.mars.aprilfive.database.CoffeeDatabase
import com.example.mars.aprilfive.model.*
import com.example.mars.databinding.ActivityMainDesignfourBinding
import com.example.mars.model.JsonSubcategoryModel
import com.example.mars.model.Jsoncategorymodel
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.io.InputStream
import java.util.Locale.filter
import java.util.logging.Handler

class FragmentHome : Fragment() {

    //product adpter
    var aarproduct = ArrayList<Coffee>()
    var aarproductone = ArrayList<Coffee>()
    var aarproducttwo = ArrayList<Coffee>()
    var aarproductthree = ArrayList<Coffee>()
    var aarproductfour = ArrayList<Coffee>()
    var aarproductfive = ArrayList<Coffee>()
    var aarproductsix = ArrayList<Coffee>()
    var aarproductseven = ArrayList<Coffee>()
    var aarproducteight = ArrayList<Coffee>()
    var idProduct: Int = 0
    // var alldata: String = CategoryItem().toString()
//        //for searchbar

//    //for serach bar
    //category adapter
    var aaarcategory = ArrayList<Jsoncategorymodel>()

    var apidata = ProductResponse()
    var apicategorydata = SubcategoryResponse()
    var apisubcategoryproduct = SubcategoryProductResponse()

    //subcategory adapter
    var aarsubcategory = ArrayList<JsonSubcategoryModel>()
    var aarsubcategoryone = ArrayList<JsonSubcategoryModel>()
    var aarsubcategorytwo = ArrayList<JsonSubcategoryModel>()
    var aarsubcategorythree = ArrayList<JsonSubcategoryModel>()

    lateinit var database: CoffeeDatabase
    private lateinit var binding: ActivityMainDesignfourBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.activity_main_designfour, container, false)
        val prg = ProgressDialog(requireContext())
        prg.setMessage("PLESE WAIT......")
        prg.setCancelable(false)
        android.os.Handler().postDelayed({ prg.dismiss() }, 5000)
        prg.show()
        database =
            Room.databaseBuilder(requireActivity(), CoffeeDatabase::class.java, "coffeeDb").build()
        val coffeee = listOf<String>("hot", "cold", "hot", "cold")
        read_json_category()
        read_json_subcategory()
        read_json_product()
        read_json_subcategoryone()
        read_json_subcategorythree()
        read_json_subcategorytwo()
        read_json_productone()
        read_json_producttwo()
        read_json_productthree()
        read_json_productfour()
        read_json_productfive()
        read_json_productsix()
        read_json_productseven()
        read_json_producteight()
        getProductData()
        getCategoryData(1)
//        getCategoryData(id)
        getSubcategoryProductData(1)
        //getSubcategoryProductData(id)
        /*   binding.recycl1.adapter = MyAdapterCategory(object : MyAdapterCategory.Onclikk {

               override fun clikRvv(pos: Int) {
                   Log.d("Taggg", "hello")

                   //getProductData()
                   // Log.e("Tag", "$pos")
                   if (pos == 0) {
                       //getCategoryData()
                       //Log.e("Taggg", "hello")
                       binding.recycl2.adapter = MyAdapterTwo(object : MyAdapterTwo.Clickkk {
                           override fun clickRvvv(poszero: Int) {

                               if (poszero == 0) {
                                   binding.recycl3.layoutManager =
                                       GridLayoutManager(requireActivity(), 4)
                                   binding.recycl3.adapter =
                                       MyAdapterProduct(aarproductone, database, requireActivity())
                               }
                               if (poszero == 1) {
                                   binding.recycl3.layoutManager =
                                       GridLayoutManager(requireActivity(), 4)
                                   binding.recycl3.adapter =
                                       MyAdapterProduct(aarproducttwo, database, requireActivity())
                               }
                           }
                       }, apicategorydata.category, requireActivity())
                       binding.recycl2.layoutManager =
                           LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                   }
                   if (pos == 1) {

                       binding.recycl2.adapter = MyAdapterTwo(object : MyAdapterTwo.Clickkk {
                           override fun clickRvvv(posone: Int) {
                               //Log.e("Tag","$posone")*
                               if (posone == 0) {
                                   binding.recycl3.layoutManager =
                                       GridLayoutManager(requireActivity(), 4)
                                   binding.recycl3.adapter =
                                       MyAdapterProduct(aarproductthree, database, requireActivity())
                               }
                               if (posone == 1) {
                                   binding.recycl3.layoutManager =
                                       GridLayoutManager(requireActivity(), 4)
                                   binding.recycl3.adapter =
                                       MyAdapterProduct(aarproductfour, database, requireActivity())
                               }
                           }

                       },  apicategorydata.category, requireActivity())
                       binding.recycl2.layoutManager =
                           LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

                   }
                   if (pos == 2) {
                       binding.recycl2.adapter = MyAdapterTwo(object : MyAdapterTwo.Clickkk {
                           override fun clickRvvv(posone: Int) {
                               Log.e("Tagg", "$posone")
                               if (posone == 0) {
                                   binding.recycl3.layoutManager =
                                       GridLayoutManager(requireActivity(), 4)
                                   binding.recycl3.adapter =
                                       MyAdapterProduct(aarproductfive, database, requireActivity())
                               }
                               if (posone == 1) {
                                   binding.recycl3.layoutManager =
                                       GridLayoutManager(requireActivity(), 4)
                                   binding.recycl3.adapter =
                                       MyAdapterProduct(aarproductsix, database, requireActivity())
                               }


                           }
                       },  apicategorydata.category, requireActivity())
                       binding.recycl2.layoutManager =
                           LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                   }
                   if (pos == 3) {
                       binding.recycl2.adapter = MyAdapterTwo(object : MyAdapterTwo.Clickkk {
                           override fun clickRvvv(pospatty: Int) {
                               Log.e("Tagg", "$pospatty")
                               if (pospatty == 0) {
                                   binding.recycl3.layoutManager =
                                       GridLayoutManager(requireActivity(), 4)
                                   binding.recycl3.adapter =
                                       MyAdapterProduct(aarproductseven, database, requireActivity())
                               }
                               if (pospatty == 1) {
                                   binding.recycl3.layoutManager =
                                       GridLayoutManager(requireActivity(), 4)
                                   binding.recycl3.adapter =
                                       MyAdapterProduct(aarproducteight, database, requireActivity())
                               }
                           }
                       },  apicategorydata.category, requireActivity())
                       binding.recycl2.layoutManager =
                           LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                   }
                  // getCategoryData()

               }

           }, apidata.product, requireActivity())
           binding.recycl1.layoutManager =
               LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

           binding.recycl2.adapter = MyAdapterTwo(object : MyAdapterTwo.Clickkk {
               override fun clickRvvv(posthree: Int) {
                   // Log.e("Tag","$posthree")

   //                    binding.recycl3.layoutManager = GridLayoutManager(requireActivity(), 4)
   //                    binding.recycl3.adapter = MyAdapterProduct(aarproduct, database, requireActivity())
   //
   //                    binding.recycl3.layoutManager = GridLayoutManager(requireActivity(), 4)
   //                    binding.recycl3.adapter = MyAdapterProduct(aarproduct, database, requireActivity())


               }
           },  apicategorydata.category, requireActivity())

           //bydefault coffee show
           binding.recycl3.layoutManager = GridLayoutManager(requireActivity(), 4)
           binding.recycl3.adapter = MyAdapterProduct(aarproduct, database, requireActivity())
           binding.recycl2.layoutManager =
               LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)*/


        //bydefault coffee show
        //...................adapter 3 recycle 3 product item h y..........

//        binding.recycl3.layoutManager = GridLayoutManager(requireActivity(), 2)
//        binding.recycl3.adapter = MyAdapterProduct(object :MyAdapterProduct.Onclickproduct,database, requireActivity())
//        binding.recycl2.layoutManager =
//            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        return binding.root
    }


    fun getProductData() {
        val news = ĘxcelService.cafeInstance.getProductItem()
        news.enqueue(object : Callback<ProductResponse> {

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                Log.d("Fail", news.toString())
            }

            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                val news = response.body()
                apidata = response.body()!!
                if (news != null) {
                    //     Log.e("taggg", news.product.toString())
                    var adapter = MyAdapterCategory(object : MyAdapterCategory.Onclikk {
                        override fun clikRvv(id: Int) {
                            // getCategoryData()
                            //Log.e("Tag", "$id")
                            getCategoryData(id)
                        }
                    }, apidata.product, requireActivity())
                    binding.recycl1.adapter = adapter
                    binding.recycl1.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                }
            }
        })
    }

    private fun getCategoryData(id: Int) {
        val news = SubcategoryService.cafeInstance.getSubcategoryItem()
        news.enqueue(object : Callback<SubcategoryResponse> {

            override fun onFailure(call: Call<SubcategoryResponse>, t: Throwable) {
                Log.d("chanchal", news.toString())
            }

            override fun onResponse(
                call: Call<SubcategoryResponse>,
                response: Response<SubcategoryResponse>
            ) {
                val newss = response.body()
                val category: ArrayList<CategoryItem> = ArrayList()
//                apicategorydata = response.body()!!
                if (news != null) {
                    if (newss != null) {
                        Log.d("apppiii", newss.category.toString())
                        newss.category.forEach {
                            if (it.pId == id) {
                                category.add(it)
                                //Log.d("llll", apicategorydata.toString())
                                // Log.e("dataa", it.name.toString())

                            }
                        }
                    }


                    //     Log.e("taggg", news.product.toString())
                    var adapter = MyAdapterSubcategory(object : MyAdapterSubcategory.Clickkk {
                        override fun clickRvvv(id: Int) {
                            // getCategoryData()
                            Log.e("dataa", category.toString())
                            // Log.e("Tag", "$id")
                            // getCategoryData(id)
                            getSubcategoryProductData(id)

                        }
                    }, category as List<CategoryItem>, requireActivity())
                    binding.recycl2.adapter = adapter
                    binding.recycl2.layoutManager =
                        LinearLayoutManager(
                            requireContext(),
                            LinearLayoutManager.HORIZONTAL,
                            false
                        )
                }
            }
        })
    }

    private fun getSubcategoryProductData(id: Int) {
        val news = SubcategoryProductService.cafeInstance.getSubcategoryProductItem()
        news.enqueue(object : Callback<SubcategoryProductResponse> {

            override fun onFailure(call: Call<SubcategoryProductResponse>, t: Throwable) {
                Log.d("chanchal", news.toString())
            }

            override fun onResponse(
                call: Call<SubcategoryProductResponse>,
                response: Response<SubcategoryProductResponse>
            ) {
                val newss = response.body()
                val subcategory: ArrayList<SubcategoryItem> = ArrayList()
//                apisubcategoryproduct = response.body()!!
                if (news != null) {
                    if (newss != null) {
                        Log.d("apppiii", newss.subcategory.toString())
                        newss.subcategory!!.forEach {
                            if (it!!.cId == id) {
                                subcategory.add(it)
                                Log.d("llll", apisubcategoryproduct.toString())
                                // Log.e("dataa", it.name.toString())
                            }

                        }


                        //     Log.e("taggg", news.product.toString())
                        var adapter = MyAdapterProduct(object : MyAdapterProduct.Onclickproduct {
                            override fun clikRecycle(pos: Int) {
                                // clikRecycle(pos)
                                Log.e("dataa", subcategory.toString())
                            }
                        }, database, subcategory, requireActivity(),"")
                        // },MyAdapterProduct.Onclickproduct,Coffee,database,requireActivity())
                        // }, SubcategoryItem ,database, requireActivity())
                        binding.recycl3.adapter = adapter
                        binding.recycl3.layoutManager = GridLayoutManager(requireActivity(), 2)
                        binding.etsearch.addTextChangedListener {
                            //Log.e("TAGGGG", "edit text values -----${it}" )

                            adapter.filter.filter(it)
                        }


                    }
                }
            }
        })

    }


//                Log.d("Hiiii", apidata.toString())
//                binding.recycl1.adapter = MyAdapterCategory(object : MyAdapterCategory.Onclikk {
//                    override fun clikRvv(pos: Int) {
//                        Log.e("Tag", "$pos")
//                        if (pos == 0) {
//
//                            Log.e("Taggg", "hello")
//                            binding.recycl2.adapter = MyAdapterTwo(object : MyAdapterTwo.Clickkk {
//                                override fun clickRvvv(poszero: Int) {
//                                    // Log.d("clickkkkkkk",apidata.toString())
//                                    if (poszero == 0) {
//                                        binding.recycl3.layoutManager =
//                                            GridLayoutManager(requireActivity(), 4)
//                                        binding.recycl3.adapter =
//                                            MyAdapterProduct(
//                                                aarproductone,
//                                                database,
//                                                requireActivity()
//                                            )
//                                    }
//                                    if (poszero == 1) {
//                                        binding.recycl3.layoutManager =
//                                            GridLayoutManager(requireActivity(), 4)
//                                        binding.recycl3.adapter =
//                                            MyAdapterProduct(
//                                                aarproducttwo,
//                                                database,
//                                                requireActivity()
//                                            )
//                                    }
//                                }
//                            }, aarsubcategory, requireActivity())
//                            binding.recycl2.layoutManager =
//                                LinearLayoutManager(
//                                    requireContext(),
//                                    LinearLayoutManager.HORIZONTAL,
//                                    false
//                                )
//                        }
//                        if (pos == 1) {
//
//                            binding.recycl2.adapter = MyAdapterTwo(object : MyAdapterTwo.Clickkk {
//                                override fun clickRvvv(posone: Int) {
//                                    //Log.e("Tag","$posone")
//                                    if (posone == 0) {
//                                        binding.recycl3.layoutManager =
//                                            GridLayoutManager(requireActivity(), 4)
//                                        binding.recycl3.adapter =
//                                            MyAdapterProduct(
//                                                aarproductthree,
//                                                database,
//                                                requireActivity()
//                                            )
//                                    }
//                                    if (posone == 1) {
//                                        binding.recycl3.layoutManager =
//                                            GridLayoutManager(requireActivity(), 4)
//                                        binding.recycl3.adapter =
//                                            MyAdapterProduct(
//                                                aarproductfour,
//                                                database,
//                                                requireActivity()
//                                            )
//                                    }
//                                }
//                            }, aarsubcategoryone, requireActivity())
//                            binding.recycl2.layoutManager =
//                                LinearLayoutManager(
//                                    requireContext(),
//                                    LinearLayoutManager.HORIZONTAL,
//                                    false
//                                )
//
//                        }
//                        if (pos == 2) {
//                            binding.recycl2.adapter = MyAdapterTwo(object : MyAdapterTwo.Clickkk {
//                                override fun clickRvvv(posone: Int) {
//                                    Log.e("Tagg", "$posone")
//                                    if (posone == 0) {
//                                        binding.recycl3.layoutManager =
//                                            GridLayoutManager(requireActivity(), 4)
//                                        binding.recycl3.adapter =
//                                            MyAdapterProduct(
//                                                aarproductfive,
//                                                database,
//                                                requireActivity()
//                                            )
//                                    }
//                                    if (posone == 1) {
//                                        binding.recycl3.layoutManager =
//                                            GridLayoutManager(requireActivity(), 4)
//                                        binding.recycl3.adapter =
//                                            MyAdapterProduct(
//                                                aarproductsix,
//                                                database,
//                                                requireActivity()
//                                            )
//                                    }
//
//
//                                }
//                            }, aarsubcategorytwo, requireActivity())
//                            binding.recycl2.layoutManager =
//                                LinearLayoutManager(
//                                    requireContext(),
//                                    LinearLayoutManager.HORIZONTAL,
//                                    false
//                                )
//                        }
//                        if (pos == 3) {
//                            binding.recycl2.adapter = MyAdapterTwo(object : MyAdapterTwo.Clickkk {
//                                override fun clickRvvv(pospatty: Int) {
//                                    Log.e("Tagg", "$pospatty")
//                                    if (pospatty == 0) {
//                                        binding.recycl3.layoutManager =
//                                            GridLayoutManager(requireActivity(), 4)
//                                        binding.recycl3.adapter =
//                                            MyAdapterProduct(
//                                                aarproductseven,
//                                                database,
//                                                requireActivity()
//                                            )
//                                    }
//                                    if (pospatty == 1) {
//                                        binding.recycl3.layoutManager =
//                                            GridLayoutManager(requireActivity(), 4)
//                                        binding.recycl3.adapter =
//                                            MyAdapterProduct(
//                                                aarproducteight,
//                                                database,
//                                                requireActivity()
//                                            )
//                                    }
//                                }
//                            }, aarsubcategorythree, requireActivity())
//                            binding.recycl2.layoutManager =
//                                LinearLayoutManager(
//                                    requireContext(),
//                                    LinearLayoutManager.HORIZONTAL,
//                                    false)
//                        }
//
//
//
//                    }
//                }, apidata.sheet1, requireActivity())

//                val news = response.body()
//                apidata = response.body()!!
//
//                if (news != null) {
//
//                    Log.d("apppiii", news.sheet1.toString())
//                    var  adapter = MyAdapterCategory(object : MyAdapterCategory.Onclikk{
//                    },apidata.sheet1,requireActivity())
//                    binding.recycl1.adapter = adapter
//                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
//                    //binding.recycl1.layoutManager = LinearLayoutManager(this@FragmentHome.requireActivity())
//                }

//                val news = response.body()
//                apidata = response.body()!!
//                if (news != null) {
//
//                    Log.d("apppiii", news.sheet1.toString())
//                    var  adapter = MyAdapterCategory(object : MyAdapterCategory.Onclikk{
//                    },apidata.sheet1,requireActivity())
//                    binding.recycl1.adapter = adapter
//                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
//                     binding.recycl1.layoutManager = LinearLayoutManager(this@FragmentHome.requireActivity())
//                }


//                }
//
//
//            })
//
//
//        }
//    }


    private fun read_json_product() {
        var json: String? = null
        try {
            val inputStream: InputStream = requireContext().assets.open("Product.json")
            json = inputStream.bufferedReader().use { it.readText() }
            var jsonarr = JSONArray(json)
            for (i in 0..jsonarr.length() - 1) {
                var jsonobj = jsonarr.getJSONObject(i)
                aarproduct.add(
                    Coffee(
                        idProduct++,
                        //i,
                        jsonobj.getString("name"),
                        0,
                        jsonobj.getInt("price"),
                        jsonobj.getString("image"),
                    )


                )
            }
        } catch (e: IOException) {

        }
    }

    private fun read_json_category() {
        var json: String? = null
        try {
            val inputStream: InputStream = requireContext().assets.open("Category.json")
            json = inputStream.bufferedReader().use { it.readText() } // convert to string
            var jsonarr = JSONArray(json) // string converted to json array
            for (i in 0..jsonarr.length() - 1) {
                var jsonobj = jsonarr.getJSONObject(i) // get value object from json array
                aaarcategory.add(
                    Jsoncategorymodel(
                        /* jsonobj.getString("user")*/
                        jsonobj.getString("name"),  //get string from json object
                        jsonobj.getString("image")


                    )
                )
            }
//            jsonrecycle.adapter = CustomAdapter(aar, this)
//            jsonrecycle.layoutManager = LinearLayoutManager(this)
        } catch (e: IOException) {

        }
    }

    private fun read_json_subcategory() {
        var json: String? = null
        try {
            val inputStream: InputStream = requireContext().assets.open("Subcategory.json")
            json = inputStream.bufferedReader().use { it.readText() }
            var jsonarr = JSONArray(json)
            for (i in 0..jsonarr.length() - 1) {
                var jsonobj = jsonarr.getJSONObject(i)
                aarsubcategory.add(
                    JsonSubcategoryModel(
                        /* jsonobj.getString("user")*/
                        jsonobj.getString("name")


                    )
                )
            }
//            jsonrecycle.adapter = CustomAdapter(aar, this)
//            jsonrecycle.layoutManager = LinearLayoutManager(this)
        } catch (e: IOException) {

        }
    }

    private fun read_json_subcategoryone() {
        var json: String? = null
        try {
            val inputStream: InputStream = requireContext().assets.open("Subcategoryone.json")
            json = inputStream.bufferedReader().use { it.readText() }
            var jsonarr = JSONArray(json)
            for (i in 0..jsonarr.length() - 1) {
                var jsonobj = jsonarr.getJSONObject(i)
                aarsubcategoryone.add(
                    JsonSubcategoryModel(
                        /* jsonobj.getString("user")*/
                        jsonobj.getString("name")

                    )
                )
            }
//            jsonrecycle.adapter = CustomAdapter(aar, this)
//            jsonrecycle.layoutManager = LinearLayoutManager(this)
        } catch (e: IOException) {

        }
    }

    private fun read_json_subcategorytwo() {
        var json: String? = null
        try {
            val inputStream: InputStream = requireContext().assets.open("Subcategorytwo.json")
            json = inputStream.bufferedReader().use { it.readText() }
            var jsonarr = JSONArray(json)
            for (i in 0..jsonarr.length() - 1) {
                var jsonobj = jsonarr.getJSONObject(i)
                aarsubcategorytwo.add(
                    JsonSubcategoryModel(
                        /* jsonobj.getString("user")*/
                        jsonobj.getString("name")

                    )
                )
            }
//            jsonrecycle.adapter = CustomAdapter(aar, this)
//            jsonrecycle.layoutManager = LinearLayoutManager(this)

        } catch (e: IOException) {

        }
    }

    private fun read_json_productone() {
        var json: String? = null
        try {
            val inputStream: InputStream = requireContext().assets.open("Productone.json")
            json = inputStream.bufferedReader().use { it.readText() }
            var jsonarr = JSONArray(json)
            for (i in 0..jsonarr.length() - 1) {
                var jsonobj = jsonarr.getJSONObject(i)
                aarproductone.add(
                    Coffee(
                        /* jsonobj.getString("user")*/
                        i,

                        jsonobj.getString("name"),
                        0,
                        jsonobj.getInt("price"),
                        jsonobj.getString("image"),
                    )
                )
            }
//            jsonrecycle.adapter = CustomAdapter(aar, this)
//            jsonrecycle.layoutManager = LinearLayoutManager(this)
        } catch (e: IOException) {

        }
    }

    private fun read_json_producttwo() {
        var json: String? = null
        try {
            val inputStream: InputStream = requireContext().assets.open("Producttwo.json")
            json = inputStream.bufferedReader().use { it.readText() }
            var jsonarr = JSONArray(json)
            for (i in 0..jsonarr.length() - 1) {
                var jsonobj = jsonarr.getJSONObject(i)
                aarproducttwo.add(
                    Coffee(
                        /* jsonobj.getString("user")*/
                        i,

                        jsonobj.getString("name"),
                        0,
                        jsonobj.getInt("price"),
                        jsonobj.getString("image"),
                    )
                )
            }
//            jsonrecycle.adapter = CustomAdapter(aar, this)
//            jsonrecycle.layoutManager = LinearLayoutManager(this)
        } catch (e: IOException) {

        }
    }

    private fun read_json_productthree() {
        var json: String? = null
        try {
            val inputStream: InputStream = requireContext().assets.open("Productthree.json")
            json = inputStream.bufferedReader().use { it.readText() }
            var jsonarr = JSONArray(json)
            for (i in 0..jsonarr.length() - 1) {
                var jsonobj = jsonarr.getJSONObject(i)
                aarproductthree.add(
                    Coffee(
                        /* jsonobj.getString("user")*/
                        i,

                        jsonobj.getString("name"),
                        0,
                        jsonobj.getInt("price"),
                        jsonobj.getString("image"),
                    )
                )
            }
//            jsonrecycle.adapter = CustomAdapter(aar, this)
//            jsonrecycle.layoutManager = LinearLayoutManager(this)
        } catch (e: IOException) {

        }
    }

    private fun read_json_productfour() {
        var json: String? = null
        try {
            val inputStream: InputStream = requireContext().assets.open("Productfour.json")
            json = inputStream.bufferedReader().use { it.readText() }
            var jsonarr = JSONArray(json)
            for (i in 0..jsonarr.length() - 1) {
                var jsonobj = jsonarr.getJSONObject(i)
                aarproductfour.add(
                    Coffee(
                        /* jsonobj.getString("user")*/
                        i,

                        jsonobj.getString("name"),
                        0,
                        jsonobj.getInt("price"),
                        jsonobj.getString("image"),
                    )
                )
            }
//            jsonrecycle.adapter = CustomAdapter(aar, this)
//            jsonrecycle.layoutManager = LinearLayoutManager(this)
        } catch (e: IOException) {

        }
    }

    private fun read_json_productfive() {
        var json: String? = null
        try {
            val inputStream: InputStream = requireContext().assets.open("Productfive.json")
            json = inputStream.bufferedReader().use { it.readText() }
            var jsonarr = JSONArray(json)
            for (i in 0..jsonarr.length() - 1) {
                var jsonobj = jsonarr.getJSONObject(i)
                aarproductfive.add(
                    Coffee(
                        /* jsonobj.getString("user")*/
                        i,

                        jsonobj.getString("name"),
                        0,
                        jsonobj.getInt("price"),
                        jsonobj.getString("image"),
                    )
                )
            }
//            jsonrecycle.adapter = CustomAdapter(aar, this)
//            jsonrecycle.layoutManager = LinearLayoutManager(this)
        } catch (e: IOException) {

        }
    }

    private fun read_json_productsix() {
        var json: String? = null
        try {
            val inputStream: InputStream = requireContext().assets.open("Productsix.json")
            json = inputStream.bufferedReader().use { it.readText() }
            var jsonarr = JSONArray(json)
            for (i in 0..jsonarr.length() - 1) {
                var jsonobj = jsonarr.getJSONObject(i)
                aarproductsix.add(
                    Coffee(
                        /* jsonobj.getString("user")*/
                        i,

                        jsonobj.getString("name"),
                        0,
                        jsonobj.getInt("price"),
                        jsonobj.getString("image"),
                    )
                )
            }

        } catch (e: IOException) {

        }
    }

    private fun read_json_productseven() {
        var json: String? = null
        try {
            val inputStream: InputStream = requireContext().assets.open("Productseven.json")
            json = inputStream.bufferedReader().use { it.readText() }
            var jsonarr = JSONArray(json)
            for (i in 0..jsonarr.length() - 1) {
                var jsonobj = jsonarr.getJSONObject(i)
                aarproductseven.add(
                    Coffee(
                        /* jsonobj.getString("user")*/
                        i,

                        jsonobj.getString("name"),
                        0,
                        jsonobj.getInt("price"),
                        jsonobj.getString("image"),
                    )
                )
            }

        } catch (e: IOException) {

        }
    }

    private fun read_json_producteight() {
        var json: String? = null
        try {
            val inputStream: InputStream = requireContext().assets.open("Producteight.json")
            json = inputStream.bufferedReader().use { it.readText() }
            var jsonarr = JSONArray(json)
            for (i in 0..jsonarr.length() - 1) {
                var jsonobj = jsonarr.getJSONObject(i)
                aarproducteight.add(
                    Coffee(
                        /* jsonobj.getString("user")*/
                        i,
                        jsonobj.getString("name"),
                        0,
                        jsonobj.getInt("price"),
                        jsonobj.getString("image"),
                    )
                )
            }

        } catch (e: IOException) {

        }
    }

    private fun read_json_subcategorythree() {
        var json: String? = null
        try {
            val inputStream: InputStream = requireContext().assets.open("Subcategorythree.json")
            json = inputStream.bufferedReader().use { it.readText() }
            var jsonarr = JSONArray(json)
            for (i in 0..jsonarr.length() - 1) {
                var jsonobj = jsonarr.getJSONObject(i)
                aarsubcategorythree.add(
                    JsonSubcategoryModel(
                        /* jsonobj.getString("user")*/
                        jsonobj.getString("name")
                    )
                )
            }
//            jsonrecycle.adapter = MyAdapterCategory(aaarcategory)
//            jsonrecycle.layoutManager = LinearLayoutManager(this)
            // binding.recycl1.adapter = MyAdapterCategory(aaarcategory,json,requireActivity())
//            jsonrecycle.layoutManager = LinearLayoutManager(this)
        } catch (e: IOException) {

        }
    }


    fun getData() {
        database.CoffeeDAO().getCoffee().observe(viewLifecycleOwner, Observer {
            //Log.d("chanchal", it.toString())
            // Log.e("Tag",coffee[position].id.toString())
        })
    }




}

