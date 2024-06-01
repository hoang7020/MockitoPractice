package com.example.mockitopractice

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UserTest {

    @Mock
    lateinit var userInfo: UserInfo

    @InjectMocks
    var user: User = User()

    @Before
    fun setup(){
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun test_injectMock() {
        Mockito.`when`(userInfo.userId).thenReturn("001")
        Mockito.`when`(userInfo.userName).thenReturn("hoangpham")
        Mockito.`when`(userInfo.password).thenReturn("123456")

        assertEquals("001", user.userInfo?.userId)
        assertEquals("hoangpham", user.userInfo?.userName)
        assertEquals("123456", user.userInfo?.password)
    }
}
