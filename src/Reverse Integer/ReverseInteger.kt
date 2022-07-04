package `Reverse Integer`

/**
 *
 * 解題思路
 * 這題有幾種不同解法
 * 這邊選擇的做法是先將數字轉換成字串
 * 然後翻轉後轉回數字
 * 如果是負數的話，要記得先變成正數，之後再轉換回負數
 * 最後，如果翻轉後數字超過 Int 的大小
 * 根據題目設定要回傳零
 *
 * 網站 : https://leetcode.com/problems/reverse-integer/
 *
 * */

fun reverse(x: Int): Int {
    val ret = if (x < 0) {
        (x * -1L).toString().reversed().toLong() * -1
    } else {
        x.toString().reversed().toLong()
    }
    return if (ret > 0x7fffffff || ret < -0x7fffffff) 0 else ret.toInt()
}

fun printResult(number: Int) {
    println(number)
}

fun main() {
    /**
     * Example 1:
     * Input: x = 123
     * Output: 321
     */
    val number_test1: Int = 123
    val r1 = reverse(number_test1)
    printResult(r1)

    /**
     * Example 2:
     * Input: x = -123
     * Output: -321
     */
    val number_test2: Int = -123
    val r2 = reverse(number_test2)
    printResult(r2)

    /**
     * Example 3:
     * Input: x = 120
     * Output: 21
     */
    val number_test3: Int = 120
    val r3 = reverse(number_test3)
    printResult(r3)


}