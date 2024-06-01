package com.example.mockitopractice

import android.view.View
import android.widget.TextView

fun TextView.setTextVisible(message: String?, block: (() -> Unit)? = null) {
    if (!message.isNullOrEmpty()) {
        visibility = View.VISIBLE
        text = message
        block?.invoke()
    } else {
        visibility = View.GONE
    }
}