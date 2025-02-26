package `Find the index of the First Occurrence in a String`

import utils.ListNode

/**
 *
 * 解題思路(Easy)
 *
 * 網站 : https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 *
 *舉例說明
 *
 * 範例 1
 * 	•	輸入:
 * 	•	haystack = “sadbutsad”
 * 	•	needle = “sad”
 * 	•	執行步驟:
 * 	•	i = 0:
 * 	•	從 haystack[0] 開始取長度為 3 的子字串 “sad”
 * 	•	比較 “sad” 與 needle “sad” → 完全匹配
 * 	•	返回 0
 * 	•	輸出: 0
 *
 * 範例 2
 * 	•	輸入:
 * 	•	haystack = “leetcode”
 * 	•	needle = “leeto”
 * 	•	執行步驟:
 * 	•	i = 0:
 * 	•	從 haystack[0] 取子字串 “leetc”
 * 	•	比較 “leetc” 與 needle “leeto” → 比較到第 4 個字符 “c” 與 “o” 不匹配
 * 	•	i = 1:
 * 	•	從 haystack[1] 取子字串 “eetcod”（注意這裡實際上取的是 “eetco”，因為 needle 長度為 5）
 * 	•	“eetco” 與 “leeto” 不匹配
 * 	•	繼續檢查其他位置，均無匹配
 * 	•	最後返回 -1
 * 	•	輸出: -1
 *
 * 	總結
 * 	•	思路:
 * 	•	利用雙層迴圈遍歷 haystack 的每個可能起始位置，並逐字符檢查與 needle 是否匹配。
 * 	•	一旦找到匹配的子字串，直接返回起始索引；若遍歷完都未找到匹配，返回 -1。
 * 	•	流程:
 * 	1.	判斷 needle 是否為空。
 * 	2.	外層迴圈遍歷可能的起始位置。
 * 	3.	內層迴圈檢查從當前位置開始的子字串是否與 needle 相同。
 * 	4.	找到匹配則返回索引，否則返回 -1。
 *
 * 這樣的解法雖然是暴力搜尋，但對於題目限制 (haystack 長度最多 10^4) 是可接受的。
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