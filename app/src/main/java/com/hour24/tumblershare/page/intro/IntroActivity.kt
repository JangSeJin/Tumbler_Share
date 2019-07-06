package com.hour24.tumblershare.page.intro

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.hour24.tumblershare.R
import com.hour24.tumblershare.page.main.MainActivity


class IntroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intro_activity)

        Handler().postDelayed({

            val intent = Intent(this@IntroActivity, MainActivity::class.java)
            startActivity(intent)
            finish()

        }, 100)

    }
}
