package com.example.framgianguyenvulan.kotlinbeginning

import com.example.framgianguyenvulan.kotlinbeginning.extensions.toDateString
import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.DateFormat

/**
 * Created by FRAMGIA\nguyen.vu.lan on 10/23/17.
 */
class ExtensionsTest {
    @Test
    fun testLongToDateString() {
        assertEquals("Oct 19, 2015", 1445275635000.toDateString());
    }

    @Test fun testDateStringFullFormat() {
        assertEquals("Monday, October 19, 2015", 1445275635000L.toDateString(DateFormat.FULL))
    }
}