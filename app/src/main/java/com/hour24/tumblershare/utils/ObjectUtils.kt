package com.hour24.tumblershare.utils

object ObjectUtils {

    fun isEmpty(s: Any?): Boolean {
        if (s == null) {
            return true
        }
        if (s is String && s.trim { it <= ' ' }.isEmpty()) {
            return true
        }
        if (s is Map<*, *>) {
            return s.isEmpty()
        }
        if (s is List<*>) {
            return s.isEmpty()
        }
        return if (s is Array<*>) {
            s.size == 0
        } else false
    }

}
