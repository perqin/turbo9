package com.perqin.turbo9search

import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author perqin
 */
class MatchAppUnitTest {
    @Test
    fun matchAppTest() {
        val titleEn = "WeChat"
        val titleCn = "WeiXin"
        val pkg = "com.tencent.mm"
        val wechatApp = App(listOf(
                App.MatchableString(titleEn, 2),
                App.MatchableString(titleCn, 2),
                App.MatchableString(pkg, 1)
        ))
        val result1 = matchApp(wechatApp, "")
        assertEquals("", result1.matchedString)
        assertEquals(0, result1.score)
        val result2 = matchApp(wechatApp, "92")
        assertEquals(titleEn, result2.matchedString)
        assertArrayEquals(arrayOf(0, 2), result2.highlightIndices)
        assertEquals(result2.score, 400)
        val result3 = matchApp(wechatApp, "924")
        assertEquals(titleEn, result3.matchedString)
        assertArrayEquals(arrayOf(0, 2, 3), result3.highlightIndices)
        assertEquals(420, result3.score)
        val result4 = matchApp(wechatApp, "8362368")
        assertEquals(pkg, result4.matchedString)
        assertArrayEquals(arrayOf(4, 5, 6, 7, 8, 9, 10), result4.highlightIndices)
        assertEquals(70, result4.score)
        val result5 = matchApp(wechatApp, "233333333")
        assertEquals("", result5.matchedString)
        assertEquals(-1, result5.score)
    }
}
