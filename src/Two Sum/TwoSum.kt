package `Two Sum`

/**
 *
 * 解題思路
 * 這題要加快的重點
 * 是想到利用 hashMap 搜尋比較快（log(n)）的特點
 * 來加快我們找到 a 和 target - a 的時間
 *
 * 建立一個 hashMap
 * 當我們讀取 nums[i] 時
 * 在這個 hashMap 裏面搜尋是否存在 target - nums[i]
 * 如果沒有的話，將 nums[i] 放入 hashMap 並繼續往下
 * 這樣的話，只需要從頭到尾遍歷一次陣列
 * 即可找到答案
 *
 *  網站 : https://leetcode.com/problems/two-sum/
 *
 * */

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = hashMapOf<Int, Int>()
    for (i in nums.indices) {
        if (map.containsKey(target - nums[i])) {
            val tmp = map[target - nums[i]]!!.toInt()
            return intArrayOf(tmp, i)
        }
        map[nums[i]] = i
    }
    throw IllegalArgumentException("No two sum solution")
}

fun printResult(nums: IntArray) {
    for(index in 0 until nums.size) {
        println(index)
    }
}

fun main() {
    /**
     * Example 1:
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     */
    val number_test1: IntArray = intArrayOf(2,7,11,15)
    val r1 = twoSum(number_test1,9)
    printResult(r1)

    /**
     * Example 2:
     * Input: nums = [3,2,4], target = 6
     * Output: [1,2]
     */
    val number_test2: IntArray = intArrayOf(3,2,4)
    val r2 = twoSum(number_test2,6)
    printResult(r2)

    /**
     * Example 3:
     * Input: nums = [3,3], target = 6
     * Output: [0,1]
     */
    val number_test3: IntArray = intArrayOf(3,3)
    val r3 = twoSum(number_test3,6)
    printResult(r3)

}

