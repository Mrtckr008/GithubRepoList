package com.example.githubrepolist

import com.example.githubrepolist.utils.Util
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun check_substring() {
        val helloWords =  hashSetOf("hello", "hola","merhaba","ola","ciao")
        var isSubStringExist = false
        for (word in helloWords) {
            if (word.contains("merha"))
                isSubStringExist = true
        }
        assertEquals(true, isSubStringExist)
    }
}
