package `Number of 1 Bits`

/**
 *
 * 解題思路
 * 考驗的是對 binary operation 的熟悉程度
 *
 * 我們可以發現數字 n 和數字 n-1
 * 剛好會在結尾的所有 0 變成 1
 * 並將最接近尾端的 1 變成 0
 * 所以 n and (n-1)
 * 就會將最接近尾端的 1 變成 0
 *
 * 我們只要計算進行幾次操作之後 n 變成了 0
 * 就可以知道 n 原本包含了幾個 1 bits
 *
 * 網站 : https://leetcode.com/problems/number-of-1-bits/
 *
 * */

fun hammingWeight(n:Int):Int {
    var count = 0
    var input = n
    while(input != 0) {
        input = input and (input - 1)
        count++
    }
    return count
}


fun main() {
    /**
     * Explanation
     * Input: n = 00000000000000000000000000001011
     * Output: 3
     * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
     */
    println(hammingWeight(521))

    /**
     * Explanation
     * Input: n = 00000000000000000000000010000000
     * Output: 1
     * Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
     */
    println(hammingWeight(2097152))

    /**
     * Explanation
     * Input: n = 11111111111111111111111111111101
     * Output: 31
     * Explanation: The input binary string 11111111111111111111111111111101 has a total of three '1' bits.
     */
//    println(hammingWeight(4294967293))

}