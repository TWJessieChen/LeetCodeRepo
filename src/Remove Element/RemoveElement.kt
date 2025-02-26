package `Remove Element`


/**
 *
 * 解題思路
 * 這一題考的是對陣列的處理
 *
 *  網站 : https://leetcode.com/problems/remove-element/
 *
 * 舉例說明
 *  範例 1
 *  輸入: nums = [3, 2, 2, 3], target = 3
 * 	•	初始狀態:
 * 	•	陣列：[3, 2, 2, 3]
 * 	•	slow = 0
 * 	•	fast = 0:
 * 	•	nums[0] = 3，等於 target，跳過，不做任何操作
 * 	•	slow 保持 0
 * 	•	fast = 1:
 * 	•	nums[1] = 2，不等於 target
 * 	•	將 nums[slow] 更新：nums[0] = 2
 * 	•	將 slow 加 1 → slow = 1
 * 	•	陣列變成：[2, 2, 2, 3]（後面的值暫時不重要）
 * 	•	fast = 2:
 * 	•	nums[2] = 2，不等於 target
 * 	•	更新：nums[slow] = nums[2] → nums[1] = 2
 * 	•	slow++ → slow = 2
 * 	•	陣列狀態依然為：[2, 2, 2, 3]
 * 	•	fast = 3:
 * 	•	nums[3] = 3，等於 target，跳過
 * 	•	slow 保持 2
 * 	•	結束:
 * 	•	返回 slow = 2
 * 	•	前 2 個元素為 [2, 2]，即為不等於 target 的元素
 *
 *  範例 2
 *  輸入: nums = [0,1,2,2,3,0,4,2], target = 2
 * 	•	初始狀態:
 * 	•	陣列：[0, 1, 2, 2, 3, 0, 4, 2]
 * 	•	slow = 0
 * 	•	fast = 0:
 * 	•	nums[0] = 0，不等於 2
 * 	•	更新：nums[slow] = 0
 * 	•	slow++ → slow = 1
 * 	•	fast = 1:
 * 	•	nums[1] = 1，不等於 2
 * 	•	更新：nums[1] = 1
 * 	•	slow++ → slow = 2
 * 	•	fast = 2:
 * 	•	nums[2] = 2，等於 2，跳過
 * 	•	slow 保持 2
 * 	•	fast = 3:
 * 	•	nums[3] = 2，等於 2，跳過
 * 	•	slow 保持 2
 * 	•	fast = 4:
 * 	•	nums[4] = 3，不等於 2
 * 	•	更新：nums[2] = 3
 * 	•	slow++ → slow = 3
 * 	•	fast = 5:
 * 	•	nums[5] = 0，不等於 2
 * 	•	更新：nums[3] = 0
 * 	•	slow++ → slow = 4
 * 	•	fast = 6:
 * 	•	nums[6] = 4，不等於 2
 * 	•	更新：nums[4] = 4
 * 	•	slow++ → slow = 5
 * 	•	fast = 7:
 * 	•	nums[7] = 2，等於 2，跳過
 * 	•	slow 保持 5
 * 	•	結束:
 * 	•	返回 slow = 5
 * 	•	前 5 個元素為 [0, 1, 3, 0, 4]（順序保留了原陣列中的順序），這即是不等於 2 的所有元素
 *
 *  小結
 * 	•	核心思路：
 * 	•	利用兩個指標：快指標遍歷每個元素，慢指標記錄不等於 target 的元素應該存放的位置。
 * 	•	當快指標遇到不等於 target 的元素時，將其放到慢指標位置，並移動慢指標；否則跳過。
 * 	•	最後，慢指標的位置即代表不等於 target 的元素個數 k，同時陣列前 k 個元素就是結果。
 * 	•	優點：
 * 	•	這個方法不需要額外空間 (空間複雜度 O(1))
 * 	•	只需一次遍歷 (時間複雜度 O(n))
 *
 * */

fun removeElement(nums: IntArray, target: Int): Int {
    var slow = 0 // 慢指標：指向下一個可放置不等於 target 的位置
    // 快指標遍歷整個陣列
    for (fast in nums.indices) {
        // 當前元素若不等於 target，就把它放到 slow 指標位置，並移動 slow
        if (nums[fast] != target) {
            nums[slow] = nums[fast]
            slow++
        }
    }
    // 返回不等於 target 的元素個數，即為 slow 的值
    return slow
}

fun main() {
    /**
     * Example 1:
     * Input: nums = [3,2,2,3], val = 3
     * Output: 2, nums = [2,2,_,_]
     * Explanation: Your function should return k = 2, with the first two elements of nums being 2.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     */
    val number_test1: IntArray = intArrayOf(3,2,2,3)
    println(removeElement(number_test1,3))


    /**
     * Example 2:
     * Input: nums = [0,1,2,2,3,0,4,2], val = 2
     * Output: 5, nums = [0,1,4,0,3,_,_,_]
     * Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
     * Note that the five elements can be returned in any order.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     */
    val number_test2: IntArray = intArrayOf(0,1,2,2,3,0,4,2)
    println(removeElement(number_test2,2))

}