package `Implement strStr`


/**
 *
 * 解題思路
 * 這題要加快的重點
 * 是想到利用 hashMap 搜尋比較快（log(n)）的特點
 * 來加快我們找到 a 和 target - a 的時間
 *
 * 這邊我們要將字串當作陣列進行處理
 * 實作 strStr 時盡量避免呼叫太過底層的函數
 *
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * Clarification:
 *  What should we return when needle is an empty string? This is a great question to ask during an interview.
 *  For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 *
 *  網站 : https://leetcode.com/problems/implement-strstr/
 *
 * */

fun strStr(haystack: String, needle: String): Int {
    var i = 0
    while (true) {
        var j = 0
        while (true) {
            if (j == needle.length) return i
            if (i + j == haystack.length) return -1
            if (needle[j] != haystack[i + j]) break
            j++
        }
        i++
    }
}

fun main() {
    /**
     * Example 1:
     * Input: haystack = "hello", needle = "ll"
     * Output: 2
     */
    println(strStr("hello", "ll"))

    /**
     * Example 2:
     * Input: haystack = "aaaaa", needle = "bba"
     * Output: -1
     */
    println(strStr("aaaaa", "bba"))

}