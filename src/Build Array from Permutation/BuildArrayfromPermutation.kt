package `Build Array from Permutation`

import utils.ListNode

/**
 *
 * 解題思路
 * 這一題處理的是陣列
 * 建立一個新陣列
 * 並符合題目要求的ans[i] = nums[nums[i]] 即可
 * 迴圈的部分我們可以選用 for 迴圈
 * 或者比較函式編程風格的 forEachIndexed
 *
 * 網站 : https://leetcode.com/problems/build-array-from-permutation/
 *
 * */

fun buildArray(nums: IntArray): IntArray {
    val ans = MutableList(nums.size) { 0 }
    for (i in nums.indices) {
        ans[i] = nums[nums[i]]
    }
    return ans.toIntArray()
}

fun main() {
    /**
     * Example 1:
     * Input: nums = [0,2,1,5,3,4]
     * Output: [0,1,2,4,5,3]
     * Explanation: The array ans is built as follows:
     * ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
     * = [nums[0], nums[2], nums[1], nums[5], nums[3], nums[4]]
     * = [0,1,2,4,5,3]
     *
     */

    buildArray(intArrayOf(0,2,1,5,3,4)).fold("[") { output, item -> "$output $item" }.also { println("$it ]") }
//    println(buildArray(intArrayOf(0,2,1,5,3,4)))

    /**
     * Example 2:
     * Input: nums = [5,0,1,2,3,4]
     * Output: [4,5,0,1,2,3]
     * Explanation: The array ans is built as follows:
     * ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
     * = [nums[5], nums[0], nums[1], nums[2], nums[3], nums[4]]
     * = [4,5,0,1,2,3]
     *
     */

    buildArray(intArrayOf(5,0,1,2,3,4)).fold("[") { output, item -> "$output $item" }.also { println("$it ]") }
//    println(buildArray(intArrayOf(5,0,1,2,3,4)))


}