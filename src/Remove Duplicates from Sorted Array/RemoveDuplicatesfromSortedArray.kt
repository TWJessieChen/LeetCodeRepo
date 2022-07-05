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
 * */

fun removeDuplicates(nums: IntArray): Int {
    if (nums.isEmpty() || nums.size == 1) {
        return nums.size
    }
    var j = 0
    for (i in 0 until nums.size - 1) {
        if (nums[i] != nums[i + 1]) {
            nums[j] = nums[i]
            j++
        }
    }
    nums[j] = nums[nums.size - 1]
    j++
    return j
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