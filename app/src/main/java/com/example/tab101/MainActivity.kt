package com.example.tab101

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

const val TAG = "TAB101"

class MainActivity : AppCompatActivity() {

    lateinit var tabLayout: TabLayout
    lateinit var message: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tab_layout)
        message = findViewById(R.id.message)

        val category = listOf("ทั้งหมด", "อาหาร", "ขนม", "เครื่องดื่ม")

        category.forEach {
            val t = tabLayout.newTab()
            t.text = it
            tabLayout.addTab(t)
        }

        tabLayout.addOnTabSelectedListener(object: OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val idx = tab.position
                val name = category.get(idx)
                message.text = "$idx -> $name"
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

    }
}