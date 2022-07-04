package `Palindrome Number`

import `Two Sum`.printResult
import `Two Sum`.twoSum

/**
 *
 * 解題思路
 * 這題類似於 Reverse Integer
 * 先將數字轉換成字串
 * 然後再進行判斷
 *
 * 網站 : https://leetcode.com/problems/palindrome-number/
 *
 * */

fun isPalindrome(x: Int) = when {
    x < 0 -> false
    else -> x.toString().reversed() == x.toString()
}

fun main() {
    /**
     * Example 1:
     * Input: x = 121
     * Output: true
     * Explanation: 121 reads as 121 from left to right and from right to left.
     */
    val number_test1: Int = 121
    val r1 = isPalindrome(number_test1)
    println(r1)

    /**
     * Input: x = -121
     * Output: false
     * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
     */
    val number_test2: Int = -121
    val r2 = isPalindrome(number_test2)
    println(r2)

    /**
     * Example 3:
     * Input: x = 10
     * Output: false
     * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
     */
    val number_test3: Int = 10
    val r3 = isPalindrome(number_test3)
    println(r3)

}