package com.example.mockitopractice

import android.os.LocaleList
import android.view.View
import android.widget.TextView
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SampleMock {

    @Mock
    lateinit var mockProduct: Product

    @Spy
    lateinit var spyCart: Cart

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun test_mockChain() {
        val mockLocaleList = Mockito.mock(LocaleList::class.java)
        Mockito.`when`(mockLocaleList.size()).thenReturn(22)

        AndroidEnvironmentHelper()
            .mockStringResource("Chau", "len", "ba")
            .generateAndroidEnvironment()
            .executeWithContext {
                println(it.resources.getString(0))
                println(it.resources.getString(1))
                println(it.resources.getString(2))
            }
    }

    @Test
    fun test_mockView() {
        val mockTextView = Mockito.mock(TextView::class.java)
        mockTextView.visibility = View.GONE
        mockTextView.text = "A"
        ViewHelper<TextView>(mockTextView)
            .verify {
                it.visibility = View.GONE
                it.text = "A"
            }
    }

    @Test
    fun test_product() {
        mockProduct.name = "Dua Hau"
        println("Product name: ${mockProduct.name}")
        verify(mockProduct).name = "Dua Hau"

    }

    @Test
    fun test_product_2() {
        val mockProduct2 = Mockito.mock(Product::class.java)
        mockProduct2.name = "Dua Hau"
        println("Product name: ${mockProduct2.name}")
        verify(mockProduct2).name = "Dua Hau"

    }

    @Test
    fun test_product_3() {
        val product = Product(id = 1, name = "Dua Hau", price = 10000, quantity = 10)
        spyCart.products.add(product)
        spyCart.products.add(product)
        println("Product size: ${spyCart.products.size}")

        val list = mutableListOf(product, product, product)
        doReturn(list).`when`(spyCart).products
        println("Product size: ${spyCart.products.size}")
    }

}