package `Sqrt(X)`

/**
 *
 * 解題思路(Easy)
 *
 * 網站 : https://leetcode.com/problems/sqrtx/
 *
 *
 * 題目設計目的
 * 	1.	基礎算法應用：
 * 此題主要考察二分搜尋算法的應用，要求你在一個單調增的序列中查找一個特定條件（i² ≤ x）的最大值。
 * 	2.	數值處理與邊界條件：
 * 	•	需要處理 x 為 0 或 1 等邊界情況。
 * 	•	當 x 為較大數時，直接用暴力法或內建函數可能不夠高效，因此考驗你對數學性質的理解。
 * 	3.	避免內建方法：
 * 題目要求不能使用內建的指數或開根號函數，迫使你設計自己的算法。
 *
 * 解題思路與流程
 * 	1.	特例處理：
 * 如果 x 小於 2（也就是 0 或 1），則平方根就等於 x 本身，直接返回。
 * 	2.	確定搜尋範圍：
 * 	•	對於 x ≥ 2，其平方根一定小於等於 x/2。
 * 	•	因此可以設定二分搜尋的左右邊界：
 * 	•	left = 1
 * 	•	right = x / 2
 * 	3.	二分搜尋過程：
 * 	•	在 left 與 right 之間找出最大的數 mid，滿足 mid² ≤ x。
 * 	•	為了避免乘法可能導致的整數溢位，可用 mid <= x / mid 來判斷 mid² 是否小於等於 x。
 * 	•	若條件滿足，則將結果設為 mid，並向右區間尋找更大的滿足條件的數（left = mid + 1）；
 * 	•	否則，將 right 調整為 mid - 1。
 * 	4.	返回結果：
 * 最終 result 就是 x 的平方根向下取整的值。
 *
 *舉例說明
 *
 * Example 1: x = 4
 * 	•	初始狀態：
 * 	•	x = 4
 * 	•	left = 1, right = 4 / 2 = 2, result = 0
 * 	•	第一次迴圈：
 * 	•	mid = 1 + (2 - 1) / 2 = 1
 * 	•	判斷：1 <= 4 / 1 → 1 <= 4 (滿足)
 * 	•	更新：result = 1, left = mid + 1 = 2
 * 	•	第二次迴圈：
 * 	•	left = 2, right = 2
 * 	•	mid = 2 + (2 - 2) / 2 = 2
 * 	•	判斷：2 <= 4 / 2 → 2 <= 2 (滿足)
 * 	•	更新：result = 2, left = mid + 1 = 3
 * 	•	退出迴圈：
 * 	•	此時 left = 3, right = 2 (不滿足 left <= right)
 * 	•	返回 result = 2
 * 	•	輸出： 2
 *
 *Example 2: x = 8
 * 	•	初始狀態：
 * 	•	x = 8
 * 	•	left = 1, right = 8 / 2 = 4, result = 0
 * 	•	第一次迴圈：
 * 	•	mid = 1 + (4 - 1) / 2 = 2
 * 	•	判斷：2 <= 8 / 2 → 2 <= 4 (滿足)
 * 	•	更新：result = 2, left = mid + 1 = 3
 * 	•	第二次迴圈：
 * 	•	left = 3, right = 4
 * 	•	mid = 3 + (4 - 3) / 2 = 3
 * 	•	判斷：3 <= 8 / 3 → 3 <= 2 (不滿足)
 * 	•	更新：right = mid - 1 = 2
 * 	•	退出迴圈：
 * 	•	現在 left = 3, right = 2，不再滿足條件
 * 	•	返回 result = 2
 * 	•	輸出： 2
 *
 * 這裡，8 的真實平方根約為 2.82842，而向下取整為 2。
 *
 * 小結
 * 	•	核心思路：
 * 	•	從 1 到 x/2 進行二分搜尋，尋找最大的整數 mid，使得 mid² ≤ x。
 * 	•	為避免乘法溢位，使用 mid <= x / mid 判斷條件。
 * 	•	當 x 為 0 或 1 時直接返回 x。
 * 	•	設計目的：
 * 	•	測試對二分搜尋算法的理解和應用。
 * 	•	考察邊界條件和數值溢位處理技巧。
 * 	•	讓你在不使用內建開根號函數的情況下實現數學運算。
 * 	•	執行範例：
 * 	•	x = 4 → 返回 2
 * 	•	x = 8 → 返回 2
 *
 * 以上就是詳細的程式流程、解題思路、題目設計目的以及具體的範例執行說明和 Kotlin 實現。
 *
 * */

fun mySqrt(x: Int): Int {
    // 如果 x 小於 2，則平方根就是 x 本身
    if (x < 2) return x

    var left = 1
    var right = x / 2  // 對於 x >= 2，平方根一定 <= x/2
    var result = 0

    // 二分搜尋，在 [left, right] 中尋找最大的 mid 使得 mid^2 <= x
    while (left <= right) {
        val mid = left + (right - left) / 2  // 防止溢出
        // 判斷 mid^2 是否小於等於 x：用 mid <= x / mid 避免乘法溢位
        if (mid <= x / mid) {
            result = mid      // mid 是一個候選答案
            left = mid + 1    // 嘗試找更大的數
        } else {
            right = mid - 1   // mid 太大，向左尋找
        }
    }

    return result
}

fun main() {
    /**
     * Example 1:
     * Input: x = 4
     * Output: 2
     * Explanation: The square root of 4 is 2, so we return 2.
     */
    println(mySqrt(4))

    /**
     * Example 2:
     * Input: x = 8
     * Output: 2
     * Explanation: The square root of 8 is 2.82842...,
     * and since we round it down to the nearest integer, 2 is returned.
     */
    println(mySqrt(8))

}