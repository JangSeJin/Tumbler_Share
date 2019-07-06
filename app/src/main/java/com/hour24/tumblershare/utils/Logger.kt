package com.hour24.tumblershare.utils

import android.util.Log

/**
 * @description Logger
 */
object Logger {

    // Black
    fun v(LOG_TAG: String, msg: String?) {
        if (msg != null) {
            Log.v(LOG_TAG, msg)
        }
    }

    // Blue
    fun d(LOG_TAG: String, msg: String?) {
        if (msg != null) {
            Log.d(LOG_TAG, msg)
        }
    }

    // Red
    fun e(LOG_TAG: String, msg: String?) {
        if (msg != null) {
            Log.e(LOG_TAG, msg)
        }
    }

    // Green
    fun i(LOG_TAG: String, msg: String?) {
        if (msg != null) {
            Log.i(LOG_TAG, msg)
        }
    }

    // Yellow
    fun w(LOG_TAG: String, msg: String?) {
        if (msg != null) {
            Log.w(LOG_TAG, msg)
        }
    }
}