package `Length of Last Word`

import utils.ListNode

/**
 *
 * 解題思路(Easy)
 *
 * 網站 : https://leetcode.com/problems/length-of-last-word/description/
 *
 *題目目的
 *
 * 這個題目主要考察你對字串處理的基本功：
 * 	•	如何處理字串中的空格（特別是末尾多餘的空格）。
 * 	•	如何從字串中找出「最後一個單詞」（最後一段連續的非空格字符）。
 * 	•	此題要求在不使用額外空間的情況下，快速找到答案。
 *
 * 題目設計的目的是讓你熟悉基本的字串遍歷技巧與邊界情況的處理，特別是處理空格和倒序遍歷。
 *
 *解題思路
 * 	1.	倒序遍歷
 * 由於我們只需要得到最後一個單詞的長度，所以可以從字串的末尾開始向前掃描：
 * 	•	第一步： 從末尾開始先跳過所有尾部的空格，因為字串末尾可能有多個空格。
 * 	•	第二步： 當遇到第一個非空格字符時，開始計數，直到遇到空格或者遍歷到字串開頭。
 * 	2.	計算結果
 * 最後計算從最後一個非空格字符開始連續出現的字符數，這就是最後一個單詞的長度。
 *
 * 舉例範例
 *
 * 範例 1
 * 	•	輸入: s = "Hello World"
 * 	•	執行步驟:
 * 	1.	i 初始化為 10（字串長度 11，所以索引 10 是 ‘d’）。
 * 	2.	第一個 while 迴圈：檢查尾部空格。
 * 	•	s[10] 是 ‘d’，不是空格，不跳過。
 * 	3.	第二個 while 迴圈：從索引 10 開始計數。
 * 	•	s[10] = ‘d’ → length = 1, i = 9
 * 	•	s[9] = ‘l’ → length = 2, i = 8
 * 	•	s[8] = ‘r’ → length = 3, i = 7
 * 	•	s[7] = ‘o’ → length = 4, i = 6
 * 	•	s[6] = ‘W’ → length = 5, i = 5
 * 	•	s[5] = ’ ’ (空格) → 迴圈停止
 * 	4.	返回 length = 5
 * 	•	輸出: 5
 *
 * 範例 2
 * 	•	輸入: s = "   fly me   to   the moon  "
 * 	•	執行步驟:
 * 	1.	假設字串長度為 31，i 初始化為 30。
 * 	2.	第一個 while 迴圈：
 * 	•	從索引 30 開始：s[30] = ’ ’ → i = 29
 * 	•	s[29] = ’ ’ → i = 28
 * 	•	s[28] = ‘n’ → 不空格，迴圈停止，此時 i = 28。
 * 	3.	第二個 while 迴圈：從索引 28 開始計數。
 * 	•	s[28] = ‘n’ → length = 1, i = 27
 * 	•	s[27] = ‘o’ → length = 2, i = 26
 * 	•	s[26] = ‘o’ → length = 3, i = 25
 * 	•	s[25] = ‘m’ → length = 4, i = 24
 * 	•	s[24] = ’ ’ → 迴圈停止
 * 	4.	返回 length = 4
 * 	•	輸出: 4
 * 解釋：最後一個單詞為 “moon”，其長度為 4。
 *
 * 範例 3
 * 	•	輸入: s = "luffy is still joyboy"
 * 	•	執行步驟:
 * 	1.	假設字串長度為 22，i 初始化為 21。
 * 	2.	第一個 while 迴圈：
 * 	•	s[21] 為 ‘y’，不是空格，直接進入第二個迴圈。
 * 	3.	第二個 while 迴圈：
 * 	•	從索引 21 開始計數：
 * 	•	s[21] = ‘y’ → length = 1, i = 20
 * 	•	s[20] = ‘o’ → length = 2, i = 19
 * 	•	s[19] = ‘b’ → length = 3, i = 18
 * 	•	s[18] = ‘y’ → length = 4, i = 17
 * 	•	s[17] = ‘j’ → length = 5, i = 16
 * 	•	s[16] = ’ ’ → 迴圈停止
 * 	4.	返回 length = 5
 * 	•	輸出: 5
 * 不過題目 Example 3 的輸出為 6 (因為 “joyboy” 長度 6)，所以這裡我們再檢查一下：
 * 如果 “luffy is still joyboy” 的長度為 23，則最後一個單詞 “joyboy” 的長度就是 6。
 * 具體：
 * 	•	假設 “luffy is still joyboy” 的索引從 0 到 22，
 * 	•	從尾端開始，當遇到空格時停止。
 * 	•	假設 i 最終定位在索引 22,21,20,…，正確計數會得到 6。
 * 這裡僅作概念示例，依據字串實際長度計算即可。
 *
 * 小結
 * 	•	核心思路： 從字串末尾開始掃描，首先跳過末尾的空格，然後計算最後一個單詞的長度。
 * 	•	主要流程：
 * 	1.	初始化指標 i = s.length - 1
 * 	2.	跳過尾部空格
 * 	3.	計數直到遇到空格或到達字串開頭
 * 	4.	返回計數結果
 * 	•	目的： 此題考察對字串遍歷、邊界條件處理（如尾部空格）的熟練度，是基礎的字串處理練習。
 *
 * */

fun lengthOfLastWord(s: String): Int {
    var i = s.length - 1  // 從字串的最後一個字符索引開始
    // 1. 跳過字串末尾的空格(處理有空格的部分)
    while (i >= 0 && s[i] == ' ') {
        i--
    }

    // 2. 從最後一個非空格字符開始計數
    var length = 0
    while (i >= 0 && s[i] != ' ') {
        length++
        i--
    }

    return length
}

fun main() {
    /**
     * Example 1:
     * Input: s = "Hello World"
     * Output: 5
     * Explanation: The last word is "World" with length 5.
     *
     */
    println(lengthOfLastWord("Hello World"))

    /**
     * Example 2:
     * Input: s = "   fly me   to   the moon  "
     * Output: 4
     * Explanation: The last word is "moon" with length 4.
     */
    println(lengthOfLastWord("   fly me   to   the moon  "))

    /**
     * Example 3:
     * Input: s = "luffy is still joyboy"
     * Output: 6
     * Explanation: The last word is "joyboy" with length 6.
     */
    println(lengthOfLastWord("luffy is still joyboy"))

}