package `Roman to Integer`


/**
 *
 * 解題思路
 * 這題的處理是字串處理
 * 我們可以使用 mapOf() 和字串的 indices 來進行處理
 *
 * 網站 : https://leetcode.com/problems/regular-expression-matching/
 *
 * */

fun romanToInt(s: String): Int {
    var result = 0
    val map = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )
    for (i in s.indices) {
        val s1 = map[s[i]] ?: continue
        if (i + 1 == s.length) {
            result += s1
            continue
        }
        val s2 = map[s[i + 1]] ?: continue
        if (s1 >= s2) {
            result += s1
        } else {
            result -= s1
        }
    }
    return result
}

fun main() {
    /**
     * Example 1:
     * Input: s = "III"
     * Output: 3
     * Explanation: III = 3.
     */
    println(romanToInt("III"))

    /**
     * Example 2:
     * Input: s = "LVIII"
     * Output: 58
     * Explanation: L = 50, V= 5, III = 3.
     */
    println(romanToInt("LVIII"))

    /**
     * Example 3:
     * Input: s = "MCMXCIV"
     * Output: 1994
     * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     */
    println(romanToInt("MCMXCIV"))

}