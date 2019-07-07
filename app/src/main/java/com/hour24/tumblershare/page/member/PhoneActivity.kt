package com.hour24.tumblershare.page.member

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.hour24.tumblershare.R
import com.hour24.tumblershare.page.main.MainActivity
import kotlinx.android.synthetic.main.phone_activity.*


class PhoneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.phone_activity)

        bt_confirm.setOnClickListener {
            val intent = Intent(this@PhoneActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}
