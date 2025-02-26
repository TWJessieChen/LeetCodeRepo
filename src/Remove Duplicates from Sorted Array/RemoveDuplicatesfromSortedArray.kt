package `Remove Duplicates from Sorted Array`

import utils.ListNode

/**
 *
 * 解題思路
 * 利用陣列已經排序好這件事情
 * 我們可以只比對原本陣列前後的元素
 * 撰寫時要注意最尾端的元素如何調整
 *
 * 網站 : https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 *程式思路詳細解釋
 * 	1.	空陣列檢查
 * 	•	一開始檢查陣列是否為空：
 *      若 nums 為空，表示沒有元素，直接返回 0。
 * 	2.	初始化慢指標
 * 	•	設定 slow = 0，表示第一個元素（nums[0]）預設為第一個不重複的元素。
 * 	•	快指標 fast 從索引 1 開始，逐一檢查後續元素。
 * 	3.	使用雙指標遍歷陣列
 * 	•	利用 for (fast in 1 until nums.size) 進行循環：
 * 	•	每次將 nums[fast] 與 nums[slow] 進行比較。
 * 	•	如果兩者不同：
 * 	•	表示找到一個新的不重複元素。
 * 	•	先將 slow 加一，然後將這個新元素 nums[fast] 存放到 nums[slow] 位置上。
 * 	•	如果兩者相同，則表示該元素為重複，不做任何操作，直接讓 fast 移至下一個元素。
 * 	4.	計算結果
 * 	•	循環結束後，slow 所在的索引表示最後一個不重複元素的位置，由於索引是從 0 開始，因此不重複元素的總數為 slow + 1。
 * 	•	最後返回該值。
 *
 * 舉例說明
 *
 * 以兩個例子來展示如何執行這個演算法。
 *
 * 範例 1
 * 輸入: nums = [1, 1, 2]
 * 	•	初始狀態：
 * 	•	陣列: [1, 1, 2]
 * 	•	slow = 0，nums[0] = 1
 * 	•	fast = 1:
 * 	•	比較 nums[1] 與 nums[slow] → nums[1] = 1 與 nums[0] = 1
 * 	•	相等，表示是重複，不做操作
 * 	•	狀態不變：slow = 0
 * 	•	fast = 2:
 * 	•	比較 nums[2] 與 nums[slow] → nums[2] = 2 與 nums[0] = 1
 * 	•	不相等，表示找到了新元素
 * 	•	將 slow 增加 1：slow = 1
 * 	•	將新元素放入位置 1：nums[1] = nums[2]，即 nums[1] = 2
 * 	•	陣列變為 [1, 2, 2] （後面的值不重要）
 * 	•	結束循環：
 * 	•	返回 slow + 1 = 1 + 1 = 2
 * 	•	最終結果：不重複元素的數量為 2，且前兩個元素為 [1, 2]
 *
 * 範例 2
 * 輸入: nums = [0,0,1,1,1,2,2,3,3,4]
 * 	•	初始狀態：
 * 	•	陣列: [0,0,1,1,1,2,2,3,3,4]
 * 	•	slow = 0，nums[0] = 0
 * 	•	fast = 1:
 * 	•	比較 nums[1] 與 nums[0] → nums[1] = 0, nums[0] = 0
 * 	•	相等 → 不操作
 * 	•	fast = 2:
 * 	•	比較 nums[2] 與 nums[slow] → nums[2] = 1, nums[0] = 0
 * 	•	不相等 → 新元素 1
 * 	•	slow++ → slow = 1
 * 	•	更新：nums[1] = 1
 * 	•	陣列變成 [0,1,1,1,1,2,2,3,3,4]
 * 	•	fast = 3:
 * 	•	比較 nums[3] 與 nums[slow] → nums[3] = 1, nums[1] = 1
 * 	•	相等 → 不操作
 * 	•	fast = 4:
 * 	•	比較 nums[4] 與 nums[slow] → nums[4] = 1, nums[1] = 1
 * 	•	相等 → 不操作
 * 	•	fast = 5:
 * 	•	比較 nums[5] 與 nums[slow] → nums[5] = 2, nums[1] = 1
 * 	•	不相等 → 新元素 2
 * 	•	slow++ → slow = 2
 * 	•	更新：nums[2] = 2
 * 	•	陣列變成 [0,1,2,1,1,2,2,3,3,4]
 * 	•	fast = 6:
 * 	•	比較 nums[6] 與 nums[slow] → nums[6] = 2, nums[2] = 2
 * 	•	相等 → 不操作
 * 	•	fast = 7:
 * 	•	比較 nums[7] 與 nums[slow] → nums[7] = 3, nums[2] = 2
 * 	•	不相等 → 新元素 3
 * 	•	slow++ → slow = 3
 * 	•	更新：nums[3] = 3
 * 	•	陣列變成 [0,1,2,3,1,2,2,3,3,4]
 * 	•	fast = 8:
 * 	•	比較 nums[8] 與 nums[slow] → nums[8] = 3, nums[3] = 3
 * 	•	相等 → 不操作
 * 	•	fast = 9:
 * 	•	比較 nums[9] 與 nums[slow] → nums[9] = 4, nums[3] = 3
 * 	•	不相等 → 新元素 4
 * 	•	slow++ → slow = 4
 * 	•	更新：nums[4] = 4
 * 	•	陣列變成 [0,1,2,3,4,2,2,3,3,4]
 * 	•	結束循環：
 * 	•	返回 slow + 1 = 4 + 1 = 5
 * 	•	結果：前 5 個位置為 [0,1,2,3,4]，代表有 5 個不重複元素。
 *
 *
 * 	    小結
 * 	•	程式利用雙指標（慢指標 slow 與快指標 fast）在原地移除重複項目。
 * 	•	每當 fast 指向的新元素與 slow 指向的元素不同，就把 fast 的值放到 slow 的下一個位置，並將 slow 向前移動。
 * 	•	最後返回 slow + 1 即為不重複元素的數量，並且陣列前 slow + 1 的位置存放著所有不重複的元素（順序與原本相同）。
 * */

fun removeDuplicates(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    var slow = 0  // 慢指標，指向最後一個不重複元素所在的位置
    // fast 指標從第二個元素開始遍歷
    for (fast in 1 until nums.size) {
        // 如果發現當前 fast 指向的元素與 slow 指向的元素不同，則表示找到了新元素
        if (nums[fast] != nums[slow]) {
            slow++  // 將慢指標移到下一個位置
            nums[slow] = nums[fast]  // 將新元素放到 slow 指向的位置
        }
    }
    // 最後慢指標所在的位置 (0-based) 加1 就是不重複元素的總數
    return slow + 1
}

fun main() {
    /**
     * Example 1:
     * Input: nums = [1,1,2]
     * Output: 2, nums = [1,2,_]
     * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     */
    val number_test1: IntArray = intArrayOf(1,1,2)
    println(removeDuplicates(number_test1))

    /**
     * Example 2:
     * Input: nums = [0,0,1,1,1,2,2,3,3,4]
     * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
     * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     */
    val number_test2: IntArray = intArrayOf(0,0,1,1,1,2,2,3,3,4)
    println(removeDuplicates(number_test2))

}