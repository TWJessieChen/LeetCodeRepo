package `Find the index of the First Occurrence in a String`

import utils.ListNode

/**
 *
 * 解題思路(Easy)
 *
 * 網站 : https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 *
 *
 *
 *
 *
 * */

fun strStr(haystack: String, needle: String): Int {
    if (needle.length > haystack.length) {
        return -1
    }

    for (i in 0..haystack.length - needle.length) {
        var j = 0
        while (j < needle.length) {
            if (haystack[i + j] != needle[j]) {
                break
            }
            j++
        }
        if (j == needle.length) {
            return i
        }
    }

    return -1
}

fun main() {
    /**
     * Example 1:
     * Input: haystack = "sadbutsad", needle = "sad"
     * Output: 0
     * Explanation: "sad" occurs at index 0 and 6.
     * The first occurrence is at index 0, so we return 0.
     */
    println(strStr("sadbutsad","sad"))

    /**
     * Example 2:
     * Input: haystack = "leetcode", needle = "leeto"
     * Output: -1
     * Explanation: "leeto" did not occur in "leetcode", so we return -1.
     */
    println(strStr("leetcode","leeto"))

}