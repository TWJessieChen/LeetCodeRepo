package `Search Insert Position`

import utils.ListNode

/**
 *
 * 解題思路
 * 這一題考的是對陣列的處理
 *
 * 網站 : https://leetcode.com/problems/search-insert-position/
 *
 * */

fun searchInsert(nums: IntArray, target: Int): Int {
    nums.forEachIndexed { i, _ ->
        if (nums[i] == target) return i
        if (i == 0 && target < nums[i]) return 0
        if (i > 0 && target > nums[i-1] && target < nums[i]) return i
    }
    return nums.size
}

fun main() {
    /**
     * Example 1:
     * Input: nums = [1,3,5,6], target = 5
     * Output: 2
     * Explanation:
     */
    println(searchInsert(intArrayOf(1,3,5,6), 5))

    /**
     * Example 2:
     * Input: nums = [1,3,5,6], target = 2
     * Output: 1
     * Explanation:
     */
    println(searchInsert(intArrayOf(1,3,5,6), 2))

    /**
     * Example 2:
     * Input: nums = [1,3,5,6], target = 7
     * Output: 4
     * Explanation:
     */
    println(searchInsert(intArrayOf(1,3,5,6), 7))

}