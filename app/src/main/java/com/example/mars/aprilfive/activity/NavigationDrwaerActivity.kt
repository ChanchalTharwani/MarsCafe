package com.example.mars

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codenamaste.activity.model.NavigationItemModel
import com.example.codenamaste.activity.touch_listener.ClickListener
import com.example.codenamaste.activity.touch_listener.RecyclerTouchListener
import com.example.mars.aprilfive.adapter.NavigationRVAdapter
import com.example.mars.aprilfive.fragment.FragmentCart
import com.example.mars.aprilfive.fragment.FragmentHistory
import com.example.mars.databinding.ActivityNavigationDrwaerBinding

class NavigationDrwaerActivity : AppCompatActivity() {
    private lateinit var binding  : ActivityNavigationDrwaerBinding
    private lateinit var adapter: NavigationRVAdapter
    private var items = arrayListOf(

        //list // navigation model bna rkha h phle usme values add kar rhe h
        NavigationItemModel(R.drawable.coldcoffee, "Menu"),
        NavigationItemModel(R.drawable.coldcoffee, "order"),
        NavigationItemModel(R.drawable.coldcoffee, "history"),
        NavigationItemModel(R.drawable.coldcoffee, "wallet"),
        NavigationItemModel(R.drawable.coldcoffee, "setting"),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // Log.e("chanchuuu","7")
        binding = DataBindingUtil.setContentView(this , R.layout.activity_navigation_drwaer)
        loadfragOne(FragmentHome())
//        loadfragTwo(FragmentCart())
        // Set the toolbar
//        setSupportActionBar(binding.activityMainToolbar)

        // Setup Recyclerview's Layout
        binding.navigationRv.layoutManager = LinearLayoutManager(this)
        binding.navigationRv.addOnItemTouchListener(RecyclerTouchListener(this, object :
            ClickListener {
            override fun onClick(view: View, position: Int) {
                when (position) {
                    0 -> {
                        //  Fragment home call
                        loadfragOne(FragmentHome())
                        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                            binding.drawerLayout.closeDrawer(GravityCompat.START)
                        }
                    }
                    1-> {

                        // # Cart  Fragment
                        loadfragTwo(FragmentCart())
                        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                            binding.drawerLayout.closeDrawer(GravityCompat.START)
                        }
                    }
                    2-> {

                        // # Cart  Fragment
                        loadfragThree(FragmentHistory())
                        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                            binding.drawerLayout.closeDrawer(GravityCompat.START)
                        }
                    }




                }
//                // Don't highlight the 'Profile' and 'Like us on Facebook' item row
//                if (position != 6 && position != 4) {
                    updateAdapter(position)
//                }
//                Handler().postDelayed({
//                    drawerLayout.closeDrawer(GravityCompat.START)
//                }, 200)
            }
        }))

        updateAdapter(1)

        // Close the soft keyboard when you open or close the Drawer
        val toggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.activityMainToolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        ) {
            override fun onDrawerClosed(drawerView: View) {
                // Triggered once the drawer closes
                super.onDrawerClosed(drawerView)
                try {
                    val inputMethodManager =
                        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                        inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
                } catch (e: Exception) {
                    e.stackTrace
                }
            }

            override fun onDrawerOpened(drawerView: View) {
                // Triggered once the drawer opens
                super.onDrawerOpened(drawerView)
                try {
                    val inputMethodManager =
                        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    inputMethodManager.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
                } catch (e: Exception) {
                    e.stackTrace
                }
            }
        }
        binding.drawerLayout.addDrawerListener(toggle)

        toggle.syncState()

    }

    private fun updateAdapter(highlightItemPos: Int) {
        adapter = NavigationRVAdapter(items, highlightItemPos)
        binding.navigationRv.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    fun loadfragOne(frag1: FragmentHome){
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.framelayout,frag1)
        ft.commit()
    }
    fun loadfragTwo(frag2:FragmentCart){
        val ftt = supportFragmentManager.beginTransaction()
        ftt.replace(R.id.framelayout,frag2)
        ftt.commit()

    }
    fun loadfragThree(frag3:FragmentHistory){
        val fttt = supportFragmentManager.beginTransaction()
        fttt.replace(R.id.framelayout,frag3)
        fttt.commit()

    }


    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            // Checking for fragment count on back stack
            if (supportFragmentManager.backStackEntryCount > 0) {
                // Go to the previous fragment
                supportFragmentManager.popBackStack()
            } else {
                // Exit the app
                super.onBackPressed()
            }
        }
    }

}