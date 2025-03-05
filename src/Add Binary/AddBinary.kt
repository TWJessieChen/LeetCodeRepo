package `Add Binary`

/**
 *
 * 解題思路(Easy)
 *
 * 網站 : https://leetcode.com/problems/add-binary/description/
 *
 * 題目設計目的
 * 	1.	二進位加法
 * 	•	題目要求你實現二進位加法，這是數學和計算機科學中的基本運算之一。你需要理解如何將兩個二進位數字逐位相加，並正確處理進位情況。
 * 	2.	字串處理
 * 	•	給定的是字串形式的二進位數，這意味著你不能直接利用數學運算符來加總（尤其當字串長度可能很大時）。需要手動模擬加法的過程。
 * 	3.	邊界條件的考察
 * 	•	處理不同長度的字串：兩個字串長度可能不同，必須能夠正確處理較短的字串“用0補齊”的情況。
 * 	•	處理最後的進位：如果最後還有進位，則需要在結果最前端加上額外的一位。
 *
 *
 * 解題思路與流程
 * 	1.	設定指標與初始變數
 * 	•	設定兩個指標，i 指向字串 a 的末尾，j 指向字串 b 的末尾。
 * 	•	初始化一個整數變數 carry 為 0，表示進位。
 * 	•	使用一個可變的字串構建器（例如 StringBuilder）來保存結果。
 * 	2.	從末尾開始逐位相加
 * 	•	當 i >= 0 或 j >= 0 或 carry > 0 時：
 * 	•	取得當前位上的數字（如果指標超出範圍則視為 0）。
 * 	•	將這兩個數字加上 carry 得到 sum。
 * 	•	當前位的結果為 sum % 2（模 2 的餘數，對應 0 或 1）。
 * 	•	更新 carry = sum / 2（整除 2 得到進位）。
 * 	•	將結果數字加入到 StringBuilder 中（注意這時候是從低位開始）。
 * 	•	指標分別左移（i-- 和 j--）。
 * 	3.	得到結果
 * 	•	由於結果是從低位開始累加，因此需要將字串反轉後返回。
 *
 *
 *舉例說明
 *
 * Example 1
 *
 * 輸入:
 * 	•	a = “11”
 * 	•	b = “1”
 *
 * 執行步驟:
 * 	1.	初始狀態:
 * 	•	i = 1, j = 0, carry = 0, result = “”
 * 	2.	第一輪迴圈 (i = 1, j = 0):
 * 	•	digitA = a[1] = ‘1’ → 1
 * 	•	digitB = b[0] = ‘1’ → 1
 * 	•	sum = 1 + 1 + 0 = 2
 * 	•	當前位結果 = 2 % 2 = 0
 * 	•	更新 carry = 2 / 2 = 1
 * 	•	將 0 加入 result，result = “0”
 * 	•	i– → 0, j– → -1
 * 	3.	第二輪迴圈 (i = 0, j = -1, carry = 1):
 * 	•	digitA = a[0] = ‘1’ → 1
 * 	•	digitB = j < 0，故 digitB = 0
 * 	•	sum = 1 + 0 + 1 = 2
 * 	•	當前位結果 = 2 % 2 = 0
 * 	•	更新 carry = 2 / 2 = 1
 * 	•	將 0 加入 result，result = “00”
 * 	•	i– → -1
 * 	4.	第三輪迴圈 (i = -1, j = -1, carry = 1):
 * 	•	digitA = 0, digitB = 0
 * 	•	sum = 0 + 0 + 1 = 1
 * 	•	當前位結果 = 1 % 2 = 1
 * 	•	更新 carry = 1 / 2 = 0
 * 	•	將 1 加入 result，result = “001”
 * 	•	i, j 均減到 -2（但迴圈結束，因為 carry = 0 且 i, j < 0）
 * 	5.	反轉結果:
 * 	•	result.reverse() → “100”
 * 	•	返回 “100”
 *
 * 輸出: “100”
 *
 * Example 2
 *
 * 輸入:
 * 	•	a = “1010”
 * 	•	b = “1011”
 *
 * 執行步驟概述:
 * 	1.	從最右端開始相加，逐位處理：
 * 	•	右起第一位：0 + 1 = 1 (carry 0)
 * 	•	第二位：1 + 1 = 2 → 寫 0, carry 1
 * 	•	第三位：0 + 0 + carry 1 = 1 (carry 0)
 * 	•	第四位：1 + 1 = 2 → 寫 0, carry 1
 * 	2.	如果進位存在，最前面加上 carry
 * 	3.	最後得到的結果字串（反轉前）可能為 “0101”，反轉後成為 “10101”。
 *
 * 輸出: “10101”
 *
 *
 * 小結
 * 	•	核心思路:
 * 	•	從兩個二進位字串的末尾開始加起來，利用進位變數正確處理進位。
 * 	•	利用 while 迴圈遍歷直到所有位數以及進位都處理完畢，最後反轉結果字串返回。
 *
 * */

fun addBinary(a: String, b: String): String {
    // 設定指標，從字串末尾開始
    var i = a.length - 1
    var j = b.length - 1
    var carry = 0
    val result = StringBuilder()

    // 當任一字串還有數字，或者進位不為 0，持續相加
    while (i >= 0 || j >= 0 || carry > 0) {
        // 如果指標在範圍內，取出相應數字，否則視為 0
        val digitA = if (i >= 0) a[i] - '0' else 0
        val digitB = if (j >= 0) b[j] - '0' else 0

        // 計算當前位的總和與進位
        val sum = digitA + digitB + carry
        val digit = sum % 2
        carry = sum / 2

        // 加入當前位結果，因為從最低位開始，所以最後需要反轉
        result.append(digit)

        i--
        j--
    }

    // 將結果反轉後返回字串
    return result.reverse().toString()
}

fun main() {
    /**
     * Example 1:
     * Input: a = "11", b = "1"
     * Output: "100"
     */
    println(addBinary("11","1"))

    /**
     * Example 2:
     * Input: a = "1010", b = "1011"
     * Output: "10101"
     */
    println(addBinary("1010","1011"))

}