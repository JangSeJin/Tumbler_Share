package com.hour24.tumblershare.page.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hour24.tumblershare.R
import com.hour24.tumblershare.page.near.activity.NearShopActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val intent = Intent(this, NearShopActivity::class.java)
        startActivity(intent)

    }
}
