package `longest  substring  without repeating characters`

/**
 *
 * 題目與解題思路(Medium)
 *
 * 網站 : https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 *	1.	使用滑動視窗
 * 	•	我們維持一個視窗區間 [start, i]，代表當前不包含重複字元的子字串。
 * 	2.	紀錄字元索引
 * 	•	使用 indexMap 儲存每個字元最後一次出現的位置。
 * 	3.	遇到重複字元時調整視窗
 * 	•	當遇到字元 c 已經出現在 indexMap 中，且其索引大於或等於 start 時，表示當前視窗中有重複。
 * 	•	這時將 start 調整到 indexMap[c] + 1，確保新的視窗不包含這個重複字元。
 * 	4.	更新最大長度
 * 	•	每一步計算當前視窗的長度 i - start + 1，並更新 maxLength。
 *
 * 	此題使用所謂的滑動視窗技巧進行解題
 *
 * 	滑動視窗的工作流程
 * 以「不含重複字元的最長子字串」問題為例，流程如下：
 * 	1.	初始化：
 * 	•	定義兩個指標：start 用來標記當前視窗的起始位置，i（或 end）用來遍歷字串。
 * 	•	建立一個資料結構（例如 HashMap）來紀錄每個字元最後出現的位置。
 * 	2.	擴展視窗：
 * 	•	以 i 為迭代指標，從字串左側開始向右遍歷。每遇到一個字元，就嘗試將其加入當前視窗中。
 * 	3.	檢查重複：
 * 	•	當新加入的字元已經存在於當前視窗（即字元出現的位置大於或等於 start）時，代表視窗內出現了重複字元。
 * 	•	此時，需要「收縮」視窗：將 start 移動到重複字元上一次出現位置的下一位，以確保新的視窗不包含重複字元。
 * 	4.	更新結果：
 * 	•	每一步都計算當前視窗的大小，即 i - start + 1，並更新最大長度（或其他需要的結果）。
 * 	5.	持續調整：
 * 	•	遍歷整個字串，動態地調整視窗，最終能夠找到滿足條件的最長子字串。
 *
 * 這樣的解法可以在一次遍歷中解出問題，時間複雜度為 O(n)，非常適合題目中字串長度較大的情況。
 *
 * 以 s = "abcabcbb" 為例：
 * 	•	初始時，start = 0，maxLength = 0。
 * 	•	當 i = 0 時，字元為 'a'，未重複，視窗變為 "a"，maxLength 更新為 1。
 * 	•	當 i = 1 時，字元為 'b'，視窗變為 "ab"，maxLength 更新為 2。
 * 	•	當 i = 2 時，字元為 'c'，視窗變為 "abc"，maxLength 更新為 3。
 * 	•	當 i = 3 時，字元為 'a'，但 'a' 在當前視窗中已存在（索引 0），因此必須調整 start 至 0 + 1 = 1，視窗變為 "bca"。
 * 	•	之後持續往右，每當遇到重複字元時都會更新 start，保證視窗內沒有重複字元。
 * 	•	最終遍歷完所有字元，得到的 maxLength 為 3。
 *
 *
 * 假設字串為 "abcabcbb"：
 * 	1.	初始狀態：start = 0，maxLength = 0，indexMap = {}。
 * 	2.	i = 0, c = ‘a’：
 * 	•	indexMap 中沒有 ‘a’，直接更新 indexMap['a'] = 0。
 * 	•	更新 maxLength = max(0, 0 - 0 + 1) = 1。
 * 	3.	i = 1, c = ‘b’：
 * 	•	‘b’ 未出現過，更新 indexMap['b'] = 1。
 * 	•	更新 maxLength = max(1, 1 - 0 + 1) = 2。
 * 	4.	i = 2, c = ‘c’：
 * 	•	‘c’ 未出現過，更新 indexMap['c'] = 2。
 * 	•	更新 maxLength = max(2, 2 - 0 + 1) = 3。
 * 	5.	i = 3, c = ‘a’：
 * 	•	‘a’ 出現過且 indexMap['a'] = 0，且 0 >= start (0)，因此更新 start = 0 + 1 = 1。
 * 	•	更新 indexMap['a'] = 3。
 * 	•	當前視窗變成從 index 1 到 3，長度 3 - 1 + 1 = 3，maxLength 仍為 3。
 * 	6.	後續 i：
 * 	•	以此類推，每遇到重複字元，都會調整 start，並更新 indexMap 與 maxLength。
 *
 * 最終，經過整個字串的遍歷後，maxLength 就會是 3，這也是題目所要求的不重複子字串的最大長度。
 *
 *
 * */

fun lengthOfLongestSubstring(s: String): Int {
    var maxLength = 0         // 儲存最長子字串的長度
    var start = 0             // 視窗起始位置
    val indexMap = mutableMapOf<Char, Int>()  // 紀錄每個字元最後出現的位置

    for ((i, c) in s.withIndex()) {
        // 如果字元 c 已經出現過，且在當前視窗內
        if (c in indexMap && indexMap[c]!! >= start) {
            // 將視窗的起點移到重複字元的下一個位置
            start = indexMap[c]!! + 1
        }
        // 更新字元 c 的最新出現位置
        indexMap[c] = i
        // 更新最大長度
        maxLength = maxOf(maxLength, i - start + 1)
    }

    return maxLength
}

fun main() {
    /**
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     */
    println(lengthOfLongestSubstring("abcabcbb"))

    /**
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     */
    println(lengthOfLongestSubstring("bbbbb"))

    /**
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */
    println(lengthOfLongestSubstring("pwwkew"))

}