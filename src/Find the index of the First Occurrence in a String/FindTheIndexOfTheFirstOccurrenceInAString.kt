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
 *
 * 輸入參數
 * 	•	haystack = “leetcode”
 * 長度 = 8
 * 	•	needle = “leeto”
 * 長度 = 5
 *
 * 由於我們只需要檢查 haystack 中的起始位置從 0 到 (8 - 5) = 3，因此 i 的範圍是 0, 1, 2, 3。
 *
 *程式執行步驟
 *
 * i = 0
 * 	•	從 haystack 的索引 0 開始，取長度為 5 的子字串：
 * 	•	子字串 = haystack.substring(0, 0+5) = “leetc”
 * 	•	將 “leetc” 與 needle “leeto” 逐個字符比較：
 * 	•	j = 0: ‘l’ vs ‘l’ → 相同
 * 	•	j = 1: ‘e’ vs ‘e’ → 相同
 * 	•	j = 2: ‘e’ vs ‘e’ → 相同
 * 	•	j = 3: ‘t’ vs ‘t’ → 相同
 * 	•	j = 4: ‘c’ vs ‘o’ → 不同
 * 	•	結果：不完全匹配，found 設置為 false
 * 	•	i = 0 的檢查失敗，繼續下一個位置
 *
 * 	i = 1
 * 	•	從 haystack 的索引 1 開始，取長度為 5 的子字串：
 * 	•	子字串 = haystack.substring(1, 1+5) = “eetco”
 * 	•	將 “eetco” 與 needle “leeto” 比較：
 * 	•	j = 0: ‘e’ vs ‘l’ → 不同
 * 	•	結果：直接不匹配（第一個字符就不同），found 為 false
 * 	•	i = 1 的檢查失敗
 *
 * 	i = 2
 * 	•	從 haystack 的索引 2 開始，取長度為 5 的子字串：
 * 	•	子字串 = haystack.substring(2, 2+5) = “etcod”
 * 	•	索引 2: ‘e’
 * 	•	索引 3: ‘t’
 * 	•	索引 4: ‘c’
 * 	•	索引 5: ‘o’
 * 	•	索引 6: ‘d’
 * 	•	比較 “etcod” 與 “leeto”：
 * 	•	j = 0: ‘e’ vs ‘l’ → 不同
 * 	•	結果：不匹配，found 為 false
 * 	•	i = 2 的檢查失敗
 *
 * 	i = 3
 * 	•	從 haystack 的索引 3 開始，取長度為 5 的子字串：
 * 	•	子字串 = haystack.substring(3, 3+5) = “tcode”
 * 	•	索引 3: ‘t’
 * 	•	索引 4: ‘c’
 * 	•	索引 5: ‘o’
 * 	•	索引 6: ‘d’
 * 	•	索引 7: ‘e’
 * 	•	比較 “tcode” 與 “leeto”：
 * 	•	j = 0: ‘t’ vs ‘l’ → 不同
 * 	•	結果：不匹配，found 為 false
 * 	•	i = 3 的檢查失敗
 *
 * 	結果
 * 	•	經過所有可能的起始位置 (i = 0,1,2,3) 都沒有找到一個子字串與 needle “leeto” 完全匹配
 * 	•	因此，程式最終返回 -1
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