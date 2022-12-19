package com.m6.pruebas

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.m6.pruebas.DB.PokemonDBHelper
import com.m6.pruebas.fragments.FormFragment
import com.m6.pruebas.fragments.ListFragment
import com.m6.pruebas.fragments.SettingsFragment

class BottomNavigation : AppCompatActivity() {
    companion object {
        lateinit var dbHelper: PokemonDBHelper;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bottom_nav)
        setSupportActionBar(findViewById(R.id.toolbar))

        dbHelper = PokemonDBHelper(this)

        loadFragment(FormFragment(dbHelper))
        val toolbar: Toolbar = findViewById(R.id.toolbar)


        val bottomNav: BottomNavigationView = findViewById(R.id.main_menu)
        bottomNav.setOnItemSelectedListener { item: MenuItem ->

            when (item.itemId) {
                R.id.toolbar_settings -> {
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbarmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.toolbar_settings->{
                loadFragment(SettingsFragment())

            }
            R.id.toolbar_logout -> {
                val intent = Intent(this, MainActivity::class.java);
                startActivity(intent);
            }
        }
        return super.onOptionsItemSelected(item)
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