package com.example.tugas_hadia.Splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugas_hadia.LoginActivity
import com.example.tugas_hadia.R

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val background = object : Thread() {

            override fun run() {
                try {
                    Thread.sleep(3000)

                    val intent = Intent(baseContext, LoginActivity::class.java)
                    startActivity(intent)
                }catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            
        }
background.start()
    }
}