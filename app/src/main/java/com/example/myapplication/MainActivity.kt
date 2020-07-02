package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import com.example.myapplication.fragments.FavoritesFragment
import com.example.myapplication.fragments.HomeFragment
import com.example.myapplication.fragments.SearchFragment
import com.example.myapplication.fragments.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        Handler().postDelayed({
            val intent = Intent(this@MainActivity, homeact::class.java)
            startActivity(intent)
            finish()
        }, 3000)



        val homeFragment = HomeFragment()
        val favoritesFragment = FavoritesFragment ()
        val settingsFragment = SettingsFragment()
        val searchFragment = SearchFragment()

        makeCurrentFragment(homeFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_resmenu -> makeCurrentFragment(homeFragment)
                R.id.ic_favorites -> makeCurrentFragment(favoritesFragment)
                R.id.ic_settings -> makeCurrentFragment(settingsFragment)
                R.id.ic_search -> makeCurrentFragment(searchFragment)

            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply    {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}