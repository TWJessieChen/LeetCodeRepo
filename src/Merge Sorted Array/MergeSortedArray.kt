package `Merge Sorted Array`

/**
 *
 * 解題思路(Easy)
 * 這題和 Merge Sorted Array 類似
 *
 * 網站 : https://leetcode.com/problems/merge-sorted-array/description/
 *
 * 題目設計目的
 * 	1.	合併排序陣列：
 * 	•	題目要求將兩個已排序的陣列合併成一個排序好的陣列，但要求結果存放在第一個陣列中（nums1），這考驗你對原地修改陣列的能力。
 * 	2.	時間複雜度要求：
 * 	•	題目要求算法的時間複雜度為 O(m+n)（m、n 分別是兩個陣列的元素數量），這意味著你需要一次遍歷就完成合併，不能使用額外的排序步驟。
 * 	3.	邊界處理：
 * 	•	nums1 的長度為 m+n，其中前 m 個元素是有效數據，後 n 個預留空間（初始化為 0），需要正確利用這些空間存放合併結果。
 * 	•	題目還考察對空陣列或某一陣列為空的情況的處理。
 *
 *  解題思路與流程
 *
 * 我們採用從後向前的雙指標法，原因如下：
 * 	•	為什麼從後向前？
 * 	•	由於 nums1 有足夠的空間存放合併後的結果，我們可以從陣列尾部開始填寫。這樣在填寫過程中不需要移動 nums1 中原有的數據。
 * 	•	定義三個指標：
 * 	•	i 指向 nums1 中有效數據的最後一個元素（索引 m-1）。
 * 	•	j 指向 nums2 的最後一個元素（索引 n-1）。
 * 	•	k 指向 nums1 的最後一個位置（索引 m+n-1）。
 * 	•	合併過程：
 * 	1.	比較 nums1[i] 和 nums2[j]，較大的數放到 nums1[k]，然後相應指標（i 或 j）和 k 都向前移動一位。
 * 	2.	當其中一個陣列遍歷完後（例如 nums2 還有剩餘數值），把剩餘的部分直接填入 nums1 中。注意：若 nums1 剩餘，則不用處理，因為它們已在正確位置。
 *
 *程式流程與詳細解釋
 * 	1.	初始化指標
 * 	•	i = m - 1：指向 nums1 中有效數據的最後一個元素。
 * 	•	j = n - 1：指向 nums2 的最後一個元素。
 * 	•	k = m + n - 1：指向 nums1 的最後一個位置（包括預留的 0）。
 * 	2.	從後向前合併
 * 	•	進入 while 迴圈，條件為 i >= 0 && j >= 0。
 * 	•	在迴圈中：
 * 	•	如果 nums1[i] > nums2[j]，將 nums1[i] 放入 nums1[k]，然後 i–；否則，將 nums2[j] 放入 nums1[k]，然後 j–。
 * 	•	每次操作後 k 都減 1，表示填寫下一個位置。
 * 	•	這樣保證較大的數字被正確放在後面，保持非遞減順序。
 * 	3.	處理剩餘元素
 * 	•	當 nums2 還有剩餘（即 j >= 0）時，進入第二個 while 迴圈，直接把剩餘的 nums2 元素放入 nums1 中。
 * 	•	如果 nums1 還有剩餘則無需處理，因為它們已經在正確位置。
 * 	4.	主函式 main()
 * 	•	包含三個示例：
 * 	•	Example 1: 兩個非空陣列合併，最終結果應為 [1,2,2,3,5,6]。
 * 	•	Example 2: nums2 為空，結果保持 nums1 原值 [1]。
 * 	•	Example 3: nums1 沒有有效數據（m = 0），nums2 為 [1]，結果應直接變為 [1]。
 *
 * ⸻
 *
 * 舉例如何執行
 *
 * Example 1 詳細步驟
 * 	•	初始狀態：
 * 	•	nums1 = [1, 2, 3, 0, 0, 0], m = 3
 * 	•	nums2 = [2, 5, 6], n = 3
 * 	•	指標：i = 2, j = 2, k = 5
 * 	•	第一輪迴圈：
 * 	•	比較 nums1[2] = 3 與 nums2[2] = 6
 * 	•	3 < 6 → 將 nums1[5] 置為 6
 * 	•	更新：j = 1, k = 4
 * 	•	nums1 變成 [1,2,3,0,0,6]
 * 	•	第二輪迴圈：
 * 	•	i = 2, j = 1, k = 4
 * 	•	比較 nums1[2] = 3 與 nums2[1] = 5
 * 	•	3 < 5 → 將 nums1[4] 置為 5
 * 	•	更新：j = 0, k = 3
 * 	•	nums1 變成 [1,2,3,0,5,6]
 * 	•	第三輪迴圈：
 * 	•	i = 2, j = 0, k = 3
 * 	•	比較 nums1[2] = 3 與 nums2[0] = 2
 * 	•	3 > 2 → 將 nums1[3] 置為 3
 * 	•	更新：i = 1, k = 2
 * 	•	nums1 變成 [1,2,3,3,5,6]
 * 	•	第四輪迴圈：
 * 	•	i = 1, j = 0, k = 2
 * 	•	比較 nums1[1] = 2 與 nums2[0] = 2
 * 	•	2 <= 2 → 將 nums1[2] 置為 2
 * 	•	更新：j = -1, k = 1
 * 	•	nums1 變成 [1,2,2,3,5,6]
 * 	•	退出第一個迴圈：
 * 	•	j < 0，退出迴圈
 * 	•	結果：
 * 	•	nums1 已被填滿為 [1,2,2,3,5,6]
 *
 * ⸻
 *
 * 小結
 * 	•	核心思路：
 * 從後向前利用雙指標進行比較與填寫，確保不需要額外空間即可合併兩個排序好的陣列。
 *
 * */

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    // 初始化指標
    var i = m - 1       // nums1 有效數據的最後一個位置
    var j = n - 1       // nums2 的最後一個位置
    var k = m + n - 1   // nums1 的最後一個位置

    // 從後向前進行合併，直到其中一個陣列耗盡
    while (i >= 0 && j >= 0) {
        if (nums1[i] > nums2[j]) {
            nums1[k] = nums1[i]
            i--
        } else {
            nums1[k] = nums2[j]
            j--
        }
        k--
    }

    // 如果 nums2 還有剩餘，直接填入 nums1
    // (如果 nums1 還有剩餘，不需要處理，因為它已經在正確的位置)
    while (j >= 0) {
        nums1[k] = nums2[j]
        j--
        k--
    }
}

fun main() {
    /**
     * Example 1:
     * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * Output: [1,2,2,3,5,6]
     * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
     * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
     */

    val nums1Ex1 = intArrayOf(1, 2, 3, 0, 0, 0)
    val nums2Ex1 = intArrayOf(2, 5, 6)
    merge(nums1Ex1, 3, nums2Ex1, 3)
    println("Example 1: ${nums1Ex1.joinToString(prefix = "[", postfix = "]", separator = ", ")}")

    /**
     * Example 2:
     * Input: nums1 = [1], m = 1, nums2 = [], n = 0
     * Output: [1]
     * Explanation: The arrays we are merging are [1] and [].
     * The result of the merge is [1].
     */
    val nums1Ex2 = intArrayOf(1)
    val nums2Ex2 = intArrayOf()  // 空陣列
    merge(nums1Ex2, 1, nums2Ex2, 0)
    println("Example 2: ${nums1Ex2.joinToString(prefix = "[", postfix = "]", separator = ", ")}")

    /**
     * Example 3:
     * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
     * Output: [1]
     * Explanation: The arrays we are merging are [] and [1].
     * The result of the merge is [1].
     * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
     */
    val nums1Ex3 = intArrayOf(0)  // 預留空間
    val nums2Ex3 = intArrayOf(1)
    merge(nums1Ex3, 0, nums2Ex3, 1)
    println("Example 3: ${nums1Ex3.joinToString(prefix = "[", postfix = "]", separator = ", ")}")

}