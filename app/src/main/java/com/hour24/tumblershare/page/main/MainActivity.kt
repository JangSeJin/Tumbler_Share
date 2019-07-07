package com.hour24.tumblershare.page.main

import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.hour24.tumblershare.R
import com.hour24.tumblershare.page.near.activity.NearShopActivity
import com.hour24.tumblershare.page.notification.NotificationActivity
import kotlinx.android.synthetic.main.main_activity.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        ll_near.setOnClickListener {
            val intent = Intent(this@MainActivity, NearShopActivity::class.java)
            startActivity(intent)
        }

        ll_qr.setOnClickListener {
            val dialog = QRDialog(this@MainActivity)
            dialog.show()
        }

        rl_notification.setOnClickListener {
            val intent = Intent(this@MainActivity, NotificationActivity::class.java)
            startActivity(intent)
        }

        runOnUiThread {
            setCountUp(tv_total, 16996)
        }

        runOnUiThread {
            wave_view.addDefaultWaves(2, 1)
            wave_view.startAnimation()
        }
    }

    override fun onResume() {
        super.onResume()
        runOnUiThread {
            wave_view.resumeAnimation()
        }
    }

    override fun onPause() {
        wave_view.pauseAnimation()
        super.onPause()
    }

    private fun setCountUp(view: TextView, count: Int) {

        ValueAnimator().run {

            setObjectValues(0, count)
            addUpdateListener { animation ->
                view.text = animation.animatedValue.toString()
            }
            interpolator =
                AnimationUtils.loadInterpolator(
                    this@MainActivity,
                    android.R.anim.decelerate_interpolator
                )
            duration = 1500
            start()

        }
    }
}
