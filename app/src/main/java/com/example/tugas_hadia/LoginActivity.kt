package com.example.tugas_hadia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager.BadTokenException
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.tugas_hadia.helper.constant
import com.example.tugas_hadia.helper.prefHelp

class LoginActivity : AppCompatActivity() {
    lateinit var prefHelp: prefHelp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        prefHelp = prefHelp(this)

        val btn_login:Button = findViewById(R.id.btn_login)
        val edtname:EditText = findViewById(R.id.edtname)
        val edtpass:EditText = findViewById(R.id.edtpass)

        btn_login.setOnClickListener {
            if (edtname.text.isNotEmpty() && edtpass.text.isNotEmpty()) {
                saveSession( edtname.text.toString(), edtpass.text.toString() )
                showMessage( "Login Berhasil" )
                moveIntent()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (prefHelp.getBoolean( constant.PREF_IS_LOGIN )) {
            moveIntent()
        }
    }

    private fun saveSession(username: String, password: String){
        prefHelp.put( constant.PREF_USERNAME, username )
        prefHelp.put( constant.PREF_PASSWORD, password )
        prefHelp.put( constant.PREF_IS_LOGIN, true)
    }

    private fun moveIntent(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}