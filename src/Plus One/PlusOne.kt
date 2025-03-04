package `Plus One`

import utils.ListNode

/**
 *
 * 解題思路(Easy)
 *
 * 網站 : https://leetcode.com/problems/plus-one/description/
 *
 *題目設計目的
 * 	1.	考察進位運算
 * 	•	題目要求將一個表示大整數的數組加一。這涉及到進位的概念，特別是當某一位數值達到 9 時，加 1 會導致該位變成 0，同時產生進位到前一位。
 * 	2.	處理特殊邊界情況
 * 	•	當整個陣列的所有位都是 9 時（例如 [9]、[9,9,9]），加一後需要增加一個新的最高位。例如 [9] 變成 [1,0]，這測試了如何處理陣列大小改變的情況。
 * 	3.	在原地修改數組
 * 	•	雖然題目允許返回新的陣列，但大多數解法可以就地修改原陣列（如果不需要擴展新位），這考察對陣列操作的熟練度。
 *
 * 	解題思路與流程
 * 	1.	從後向前遍歷
 * 	•	從最右邊（最低位）的數字開始加 1。這是因為加法的進位從最低位開始傳播。
 * 	2.	判斷是否需要進位
 * 	•	如果當前位數小於 9，則加 1 並且完成運算，不需要進位，直接返回數組。
 * 	•	如果當前位數等於 9，則加 1 後變成 10，我們將這位設置為 0，並將進位傳播到下一位。
 * 	3.	處理所有位均產生進位的情況
 * 	•	如果遍歷完整個陣列後，所有位都是 9，則每位都會變為 0，此時需要在陣列前端添加一個 1。例如 [9,9] 變成 [1,0,0]。
 *
 * 	程式流程詳細解釋
 * 	1.	從後向前遍歷
 * 	•	我們使用 digits.indices.reversed() 來從最後一個索引開始遍歷陣列。例如，如果 digits = [1, 2, 3]，則索引為 2、1、0。
 * 	2.	判斷每一位是否小於 9
 * 	•	若 digits[i] < 9：
 * 	•	表示加 1後不會產生進位，例如數字 3 加 1變成 4。
 * 	•	我們直接將該位加 1，並返回整個陣列。
 * 	•	若 digits[i] 為 9：
 * 	•	將該位設置為 0（因為 9+1=10，只保留 0），然後繼續進行下一位的處理（即向左傳播進位）。
 * 	3.	處理所有數字都是 9 的情況
 * 	•	如果整個迴圈執行完後，都沒有提前返回，則表示所有位均為 9。例如 [9,9,9]。
 * 	•	此時我們需要建立一個新的陣列，其大小比原陣列多 1，並將第一個元素設置為 1，其餘預設為 0，最終結果例如 [1,0,0,0]。
 *
 * 	舉例說明
 *
 * Example 1
 * 	•	輸入: digits = [1,2,3]
 * 	•	步驟:
 * 	1.	從最右邊開始：索引 2 → digits[2] = 3，因為 3 < 9，所以直接執行 digits[2]++，變成 4。
 * 	2.	返回陣列，此時 digits = [1,2,4]。
 * 	•	輸出: [1,2,4]
 *
 * Example 2
 * 	•	輸入: digits = [4,3,2,1]
 * 	•	步驟:
 * 	1.	從索引 3 開始：digits[3] = 1，1 < 9，所以 digits[3]++ 變成 2，返回陣列。
 * 	2.	結果為 [4,3,2,2]。
 * 	•	輸出: [4,3,2,2]
 *
 * Example 3
 * 	•	輸入: digits = [9]
 * 	•	步驟:
 * 	1.	從索引 0 開始：digits[0] = 9，9 等於 9，所以設置 digits[0] = 0。
 * 	2.	迴圈結束後，因為所有位（此處只有一位）都被置為 0，所以建立新陣列，大小為 2。
 * 	3.	設定 newDigits[0] = 1，新陣列預設其他位為 0，結果為 [1,0]。
 * 	•	輸出: [1,0]
 *
 * */

fun plusOne(digits: IntArray): IntArray {
    // 從最後一位開始向前遍歷
    for (i in digits.indices.reversed()) {
        if (digits[i] < 9) {
            // 如果當前位數小於 9，直接加 1 並返回結果
            digits[i]++
            return digits
        }
        // 如果數字等於 9，則設置該位為 0（相當於 9+1 = 10 的情況，記錄進位）
        digits[i] = 0
    }
    // 如果遍歷完畢，都處理完畢了，說明所有位都是 9，此時需要增加一個新的最高位 1
    val newDigits = IntArray(digits.size + 1)
    newDigits[0] = 1
    return newDigits
}

fun main() {
    /**
     * Example 1:
     * Input: digits = [1,2,3]
     * Output: [1,2,4]
     * Explanation: The array represents the integer 123.
     * Incrementing by one gives 123 + 1 = 124.
     * Thus, the result should be [1,2,4].
     */
    val digits1 = intArrayOf(1, 2, 3)
    val result1 = plusOne(digits1)
    println("Example 1: ${result1.joinToString(prefix = "[", postfix = "]", separator = ", ")}")

    /**
     * Example 2:
     * Input: digits = [4,3,2,1]
     * Output: [4,3,2,2]
     * Explanation: The array represents the integer 4321.
     * Incrementing by one gives 4321 + 1 = 4322.
     * Thus, the result should be [4,3,2,2].
     */
    val digits2 = intArrayOf(4, 3, 2, 1)
    val result2 = plusOne(digits2)
    println("Example 2: ${result2.joinToString(prefix = "[", postfix = "]", separator = ", ")}")

    /**
     * Example 3:
     * Input: digits = [9]
     * Output: [1,0]
     * Explanation: The array represents the integer 9.
     * Incrementing by one gives 9 + 1 = 10.
     * Thus, the result should be [1,0].
     */
    val digits3 = intArrayOf(9)
    val result3 = plusOne(digits3)
    println("Example 3: ${result3.joinToString(prefix = "[", postfix = "]", separator = ", ")}")

}