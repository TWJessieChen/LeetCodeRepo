package `Missing Number`

import utils.ListNode

/**
 *
 * 解題思路
 * 根據陣列大小
 * 我們可以簡單地先計算出沒有缺少數字時的總和
 * 然後減去實際的總和
 * 就可以計算出缺少的數字
 * 這樣的演算法
 * 時間複雜度會是 O(n)
 * (nums.size * (nums.size + 1)) / 2 : 特殊的算法
 *
 * 網站 : https://leetcode.com/problems/missing-number/
 *
 * */

fun missingNumber(nums: IntArray) = (nums.size * (nums.size + 1)) / 2 - nums.sum()

fun main() {
    /**
     * Example 1:
     * Input: nums = [3,0,1]
     * Output: 2
     * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
     */
    println(missingNumber(intArrayOf(3,0,1)))

    /**
     * Example 2:
     * Input: nums = [0,1]
     * Output: 2
     * Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
     */
    println(missingNumber(intArrayOf(0,1)))

    /**
     * Example 2:
     * Input: nums = [9,6,4,2,3,5,7,0,1]
     * Output: 8
     * Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
     */
    println(missingNumber(intArrayOf(9,6,4,2,3,5,7,0,1)))

}