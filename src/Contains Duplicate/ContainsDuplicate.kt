package `Contains Duplicate`

import utils.ListNode

/**
 *
 * 解題思路
 * 這一題的目標是找出陣列內出現多於一次的元素
 * 利用 List 內建的函數
 * 可以很直觀地解決這些邏輯
 * Kotlin 參考解答
 * 先用 toList() 將陣列轉換成 List
 * 然後使用 List 內建的函數處理
 *
 * 網站 : https://leetcode.com/problems/contains-duplicate/
 *
 * */

fun containsDuplicate(nums: IntArray): Boolean {
    return nums
        .toList()
        .groupingBy { it }
        .eachCount()
        .any { it.value > 1 }
}

fun main() {
    /**
     * Example 1:
     * Input: nums = [1,2,3,1]
     * Output: true
     * Explanation:
     */
    println(containsDuplicate(intArrayOf(1,2,3,1)))

    /**
     * Example 2:
     * Input: nums = [1,2,3,4]
     * Output: false
     * Explanation:
     */
    println(containsDuplicate(intArrayOf(1,2,3,4)))

    /**
     * Example 2:
     * Input: nums = [1,1,1,3,3,4,3,2,4,2]
     * Output: true
     * Explanation:
     */
    println(containsDuplicate(intArrayOf(1,1,1,3,3,4,3,2,4,2)))

}