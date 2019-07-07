package com.hour24.tumblershare.page.notification

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hour24.tumblershare.R
import kotlinx.android.synthetic.main.notification_activity.*


class NotificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notification_activity)

        rl_back.setOnClickListener {
            finish()
        }


    }
}
