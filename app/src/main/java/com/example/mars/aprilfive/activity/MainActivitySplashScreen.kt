package com.example.mars

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mars.R
import java.lang.Exception

class MainActivitySplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_splash_screen)
        val screen = object:Thread(){
            override fun run() {
                try{
                Thread.sleep(1000)
    Log.e("chanchuuu","5")
                val intent = Intent(baseContext, NavigationDrwaerActivity::class.java)
                    Log.e("chanchuuu","6")
                startActivity(intent)
                    finish()
            }catch (e:Exception){
                e.printStackTrace()

                }            }

        }

screen.start()
    }
}