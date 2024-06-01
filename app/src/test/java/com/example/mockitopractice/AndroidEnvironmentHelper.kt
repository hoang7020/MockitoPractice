package com.example.mockitopractice

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.LocaleList
import android.util.DisplayMetrics
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class AndroidEnvironmentHelper {

    private var mockContext: Context = mock(Context::class.java)
    private var mockResources: Resources = mock(Resources::class.java)
    private var mockDisplayMetrics: DisplayMetrics = mock(DisplayMetrics::class.java)
    private var mockConfiguration: Configuration = mock(Configuration::class.java)
    private var mockLocale: LocaleList = mock(LocaleList::class.java)

    fun mockContext(mock: Context): AndroidEnvironmentHelper {
        mockContext = mock
        return this
    }

    fun mockResources(mock: Resources): AndroidEnvironmentHelper {
        mockResources = mock
        return this
    }

    fun mockDisplayMetrics(mock: DisplayMetrics): AndroidEnvironmentHelper {
        mockDisplayMetrics = mock
        return this
    }

    fun mockConfiguration(mock: Configuration): AndroidEnvironmentHelper {
        mockConfiguration = mock
        return this
    }

    fun mockLocaleList(mock: LocaleList): AndroidEnvironmentHelper {
        mockLocale = mock
        return this
    }

    fun mockStringResource(vararg value: String): AndroidEnvironmentHelper {
        `when`(mockResources.getString(anyInt())).then { invocation ->
            val index = invocation.arguments[0] as Int
            value[index]
        }

        return this
    }

    fun generateAndroidEnvironment(): AndroidEnvironmentHelper {
        `when`(mockContext.resources).thenReturn(mockResources)
        `when`(mockResources.displayMetrics).thenReturn(mockDisplayMetrics)
        `when`(mockResources.configuration).thenReturn(mockConfiguration)
        `when`(mockConfiguration.locales).thenReturn(mockLocale)
        return this
    }

    fun executeWithContext(closures: (context: Context) -> Unit) {
        closures.invoke(mockContext)
    }

    fun executeWithResources(closures: (resources: Resources) -> Unit) {
        closures.invoke(mockResources)
    }

}