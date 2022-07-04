package `Regular Expression Matching`


/**
 *
 * 解題思路
 * 這一題考驗的是實作 Regex
 * 雖然這題難度被標記為 Hard
 * 不過利用 Kotlin 已有的 Regex 實作
 * 可以很簡單的回答出這一題
 *
 * 網站 : https://leetcode.com/problems/regular-expression-matching/
 *
 * */


fun isMatch(s: String, p: String) =
    p.toRegex().matches(s)

fun main() {
    /**
     * Example 1:
     * Input: s = "aa", p = "a"
     * Output: false
     * Explanation: "a" does not match the entire string "aa".
     */
    println(isMatch("aa" ,"a"))

    /**
     * Example 2:
     * Input: s = "aa", p = "a*"
     * Output: true
     * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
     */
    println(isMatch("aa" ,"a*"))

    /**
     * Example 3:
     * Input: s = "ab", p = ".*"
     * Output: true
     * Explanation: ".*" means "zero or more (*) of any character (.)".
     */
    println(isMatch("ab" ,".*"))

}