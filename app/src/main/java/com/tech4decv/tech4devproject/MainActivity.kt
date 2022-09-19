package com.tech4decv.tech4devproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var tablayout : TabLayout
    private lateinit var viewPager: ViewPager2



    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tablayout=findViewById(R.id.tab)
        viewPager = findViewById(R.id.viewPager)

        viewPager.adapter= MainPageAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(tablayout, viewPager){ tab, position ->
            when(position){
                0 -> tab.text= "ITEMS"
                1 -> tab.icon= getDrawable(R.drawable.ic_baseline_add_shopping_cart_24)

            }
            viewPager.currentItem=0
        }.attach()
    }
}