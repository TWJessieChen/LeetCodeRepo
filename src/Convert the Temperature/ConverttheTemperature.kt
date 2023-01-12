package `Convert the Temperature`

import utils.ListNode

/**
 *
 * 解題思路
 * 本題練習的是針對 linked list 的操作
 * 在 Kotlin 解題需要注意的是 val 是關鍵字
 * 所以需要 以 `` 標記
 *
 * 網站 : https://leetcode.com/problems/add-two-numbers/
 *
 * */

fun convertTemperature(celsius: Double): MutableList<Double> {
    return mutableListOf<Double>().apply {
        add(celsius + 273.15)
        add(celsius * 1.80 + 32.00)
    }
}

fun main() {
    /**
     * Example 1:
     * Input: celsius = 36.50
     * Output: [309.65000,97.70000]
     * Explanation: Temperature at 36.50 Celsius converted in Kelvin is 309.65 and converted in Fahrenheit is 97.70.
     */
    println(convertTemperature(36.50))

    /**
     * Example 2:
     * Input: celsius = 122.11
     * Output: [395.26000,251.79800]
     * Explanation: Temperature at 122.11 Celsius converted in Kelvin is 395.26 and converted in Fahrenheit is 251.798.
     */
    println(convertTemperature(122.11))


}