package `Longest Common Prefix`

import utils.ListNode

/**
 *
 * 解題思路(Easy)
 *
 * 網站 : https://leetcode.com/problems/longest-common-prefix/description/
 *
 * 這題的目標是找出一個字串陣列中所有字串共同的「前綴字串」，也就是每個字串最前面連續相同的部分。如果沒有任何共同的前綴，則返回空字串 “”。
 *
 * 具體解釋
 * 	1.	前綴的定義
 * 	•	前綴是指一個字串最前面的一段連續字元。例如，“flower” 的前綴可以是 “f”、“fl”、“flo”、“flow” 等等，但不能跳著選取字元。
 * 	2.	題目要求
 * 	•	給定一個字串陣列，例如 [“flower”, “flow”, “flight”]，我們需要找出一個字串，它是每個字串開頭都出現的，且長度盡可能長。在這個例子中，“fl” 就是所有字串的共同前綴。
 * 	•	如果所有字串中沒有任何相同的開頭字元（例如 [“dog”, “racecar”, “car”]），則返回空字串 “”。
 * 	3.	解題難點與考量
 * 	•	如何有效地比較多個字串的前綴部分？
 * 常見的解法包括：
 * 	•	逐字元比較：以第一個字串作為參考，依序與其他字串的對應位置比較，直到發現不匹配的字元為止。
 * 	•	水平掃描或垂直掃描：垂直掃描法就是逐個字符位置進行比較。
 * 	•	考慮邊界條件：
 * 	•	陣列中可能只有一個字串，此時整個字串就是共同前綴。
 * 	•	某個字串可能為空，則共同前綴一定是空字串。
 * 	4.	範例說明
 * 	•	Example 1:
 * 	•	輸入: strs = [“flower”, “flow”, “flight”]
 * 	•	解釋:
 * “flower”、“flow”、“flight” 這三個字串從第一個字元開始比對：
 * 	•	第一個字元：都是 ‘f’
 * 	•	第二個字元：都是 ‘l’
 * 	•	第三個字元：分別為 ‘o’、‘o’、‘i’，發現不一致，因此共同前綴就到第二個字元為止。
 * 	•	輸出: “fl”
 * 	•	Example 2:
 * 	•	輸入: strs = [“dog”, “racecar”, “car”]
 * 	•	解釋:
 * 第一個字元分別為 ‘d’、‘r’、‘c’，沒有任何相同，因此沒有共同的前綴。
 * 	•	輸出: “”
 *
 * 總結
 *
 * 這題要求找出一個字串陣列中所有字串開頭連續相同的部分。如果存在共同前綴，返回那個前綴；如果不存在，返回空字串 “”。解法的核心在於逐一比較所有字串相同位置的字元，直到遇到不匹配為止。
 *
 * 舉例說明
 *
 * 例子 1:
 * 	•	輸入: ["flower", "flow", "flight"]
 * 	•	初始共同前綴: "flower"
 * 	•	比較 "flow" 與 "flower"：
 * 	•	"flow" 不以 "flower" 開頭 → 縮減 prefix 為 "flowe"
 * 	•	"flow" 不以 "flowe" 開頭 → 縮減 prefix 為 "flow"
 * 	•	"flow" 以 "flow" 開頭 → 保持 prefix = "flow"
 * 	•	接著比較 "flight" 與 "flow"：
 * 	•	"flight" 不以 "flow" 開頭 → 縮減 prefix 為 "flo"
 * 	•	"flight" 不以 "flo" 開頭 → 縮減 prefix 為 "fl"
 * 	•	"flight" 以 "fl" 開頭 → 最終 prefix = "fl"
 * 	•	返回: "fl"
 *
 * 例子 2:
 * 	•	輸入: ["dog", "racecar", "car"]
 * 	•	初始共同前綴: "dog"
 * 	•	比較 "racecar" 與 "dog"：
 * 	•	"racecar" 不以 "dog" 開頭 → 縮減 prefix 為 "do"
 * 	•	"racecar" 不以 "do" 開頭 → 縮減 prefix 為 "d"
 * 	•	"racecar" 不以 "d" 開頭 → 縮減 prefix 為 ""
 * 	•	一旦 prefix 變成空字串，就返回 ""
 * 	•	返回: ""
 *
 *
 * */

fun longestCommonPrefix(strs: Array<String>): String {
    // 若陣列為空，直接返回空字串
    if (strs.isEmpty()) return ""

    // 先把第一個字串當作初始的共同前綴
    var prefix = strs[0]

    // 從第二個字串開始檢查
    for (i in 1 until strs.size) {
        // 只要當前字串沒有以 prefix 為開頭，就不斷減少 prefix 的長度
        while (!strs[i].startsWith(prefix)) {
            // 將 prefix 縮減一個字元
            prefix = prefix.substring(0, prefix.length - 1)
            // 若 prefix 縮減到空字串，就表示沒有共同前綴
            if (prefix.isEmpty()) return ""
        }
    }
    return prefix
}

fun main() {
    /**
     * Example 1:
     * Input: strs = ["flower","flow","flight"]
     * Output: "fl"
     */
    val strs1 = arrayOf("flower", "flow", "flight")
    val result1 = longestCommonPrefix(strs1)
    println("Longest common prefix for ${strs1.joinToString(", ")}: $result1")  // 預期輸出: "fl"

    /**
     * Example 2:
     * Input: strs = ["dog","racecar","car"]
     * Output: ""
     * Explanation: There is no common prefix among the input strings.
     */
    val strs2 = arrayOf("dog", "racecar", "car")
    val result2 = longestCommonPrefix(strs2)
    println("Longest common prefix for ${strs2.joinToString(", ")}: $result2")  // 預期輸出: ""


}