package com.example.m4w1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.m4w1.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager = binding.viewPager
        val bottomNavigationView = binding.bottomNavigationView

        viewPager.adapter = ViewPagerAdapter(this)
        viewPager.isUserInputEnabled = false // Disable swipe navigation

        bottomNavigationView.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_first -> viewPager.currentItem = 0
                R.id.nav_second -> viewPager.currentItem = 1
                R.id.nav_third -> viewPager.currentItem = 2
            }
            true
        })
    }
}