package com.example.mockitopractice

import android.view.View
import android.widget.TextView
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ViewExtensionKtTest {

    @Test
    fun test_setTextVisible_notNull() {
        val mockTextView = Mockito.mock(TextView::class.java)
        mockTextView.setTextVisible("Test")
        assertEquals(View.VISIBLE, mockTextView.visibility)

        /** not run because it is a mock, visible status is not actual set to mock **/
        //assertEquals("Test", mockTextView.text)

        verify(mockTextView).visibility = View.VISIBLE
        verify(mockTextView).text = "Test"
    }

    @Test
    fun test_setTextVisible_null() {
        val mockTextView = Mockito.mock(TextView::class.java)
        mockTextView.setTextVisible(null)

        /** not run because it is a mock, visible status is not actual set to mock **/
        //assertEquals(View.GONE, mockTextView.visibility)

        verify(mockTextView).visibility = View.GONE
    }


}