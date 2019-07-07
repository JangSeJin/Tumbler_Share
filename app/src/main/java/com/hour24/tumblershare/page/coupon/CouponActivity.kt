package com.hour24.tumblershare.page.coupon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hour24.tumblershare.R
import kotlinx.android.synthetic.main.coupon_activity.*

class CouponActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.coupon_activity                                                                                 )

        rl_back.setOnClickListener {
            finish()
        }
    }
}
