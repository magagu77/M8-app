package com.m6.pruebas

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreference =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val user = sharedPreference.getString("user","");
        val pass = sharedPreference.getString("password","")
        val def = sharedPreference.getBoolean("default", false)
        val btnSignIn: Button = findViewById(R.id.btnSignIn);
        val txtUsername:EditText = findViewById(R.id.txtUsername);
        txtUsername.setText(user)
        val txtPassword: EditText = findViewById(R.id.txtPassword);
        txtPassword.setText(pass)
        val remember: CheckBox = findViewById(R.id.checkBox)
        remember.isChecked = def
        val editor = sharedPreference.edit()
        btnSignIn.setOnClickListener {
            val userName: String = txtUsername.getText().toString();
            val password:String = txtPassword.getText().toString();
            if (userName.equals("admin") && password.equals("admin")){
                Log.i("testMarc", "Login correcte" + userName)
                editor.clear().commit();
                if(remember.isChecked()) {
                    editor.putString("user", userName);
                    editor.putString("password", password)
                    editor.putBoolean("default", true)
                    editor.commit()
                }
                var intent = Intent(this, BottomNavigation::class.java);
                startActivity(intent);
            }else{
                Log.i("testMarc", "Login KO");
            }

        }
    }
}