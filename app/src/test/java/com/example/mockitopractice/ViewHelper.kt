package com.example.mockitopractice

import android.view.View
import org.mockito.Mockito

class ViewHelper<T>(var mockView: T) {

    fun verify(closure: (T) -> Unit) {
        closure.invoke(Mockito.verify(mockView))
    }



}