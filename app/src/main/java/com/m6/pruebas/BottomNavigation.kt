package com.m6.pruebas

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.m6.pruebas.DB.PokemonDBHelper
import com.m6.pruebas.fragments.FormFragment
import com.m6.pruebas.fragments.ListFragment

class BottomNavigation : AppCompatActivity() {
    companion object {
        lateinit var dbHelper: PokemonDBHelper;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bottom_nav)

        dbHelper = PokemonDBHelper(this)

        loadFragment(FormFragment(dbHelper))

        val bottomNav: BottomNavigationView = findViewById(R.id.main_menu)
        bottomNav.setOnItemSelectedListener { item: MenuItem ->

            when (item.itemId) {
                R.id.nav_home -> {
                    loadFragment(FormFragment(dbHelper))
                    true
                }
                R.id.nav_list -> {
                    loadFragment(ListFragment(dbHelper))
                    true
                }
                else -> {false}
            }
        }
    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onDestroy() {
        dbHelper.close()
        super.onDestroy()
    }

}