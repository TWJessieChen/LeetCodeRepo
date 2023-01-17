package `Ransom Note`

import utils.ListNode

/**
 *
 * 解題思路
 * 這一題考的是對陣列的處理
 * 我們可以先建立一個 IntArray
 * 然後利用 apply 撰寫內部邏輯
 * 最後判斷是否滿足條件
 *
 * 網站 : https://leetcode.com/problems/ransom-note/
 *
 * */

fun canConstruct(r: String, m: String) = IntArray(26).apply {
    m.forEach { this[it - 'a']++ }
    r.forEach { if (this[it - 'a'] == 0) return false else this[it - 'a']-- }
}.isNotEmpty()

fun main() {
    /**
     * Example 1:
     * Input: ransomNote = "a", magazine = "b"
     * Output: false
     * Explanation:
     */
    println(canConstruct("a", "b"))

    /**
     * Example 2:
     * Input: ransomNote = "aa", magazine = "ab"
     * Output: false
     * Explanation:
     */
    println(canConstruct("aa", "ab"))

    /**
     * Example 2:
     * Input: ransomNote = "aa", magazine = "aab"
     * Output: true
     * Explanation:
     */
    println(canConstruct("aa", "aab"))

}