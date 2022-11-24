package com.m6.pruebas

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.m6.pruebas.DB.PokemonDBHelper

class MainActivity : AppCompatActivity() {

    companion object {
        lateinit var dbHelper:PokemonDBHelper
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnSignIn: Button = findViewById(R.id.btnSignIn);
        var txtUsername:EditText = findViewById(R.id.txtUsername);
        var txtPassword: EditText = findViewById(R.id.txtPassword);

        btnSignIn.setOnClickListener {
            val userName: String = "1";
            val password:String = "1";
            if (userName.equals("1") && password.equals("1")){
            //if(txtUsername.getText().toString() == "1" && txtPassword.getText().toString()=="1"){
                Log.i("testMarc", "Login correcte" + userName);

                var intent = Intent(this, BottomNavigation::class.java);
                startActivity(intent);
            }else{
                Log.i("testMarc", "Login KO");
            }

        }
    }
}