package `Add Two Numbers`

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

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    // p1, p2 現在是可為 null，才能在迴圈中安全地往下走
    var p1 = l1
    var p2 = l2
    var carry = 0
    val dummy = ListNode(0)
    var current = dummy

    while (p1 != null || p2 != null || carry != 0) {
        // 若 p1 或 p2 為 null，就取 0
        val x = p1?.value ?: 0
        val y = p2?.value ?: 0
        val sum = x + y + carry

        carry = sum / 10
        current.next = ListNode(sum % 10)
        current = current.next!!

        // 往下走時，也要用安全呼叫
        p1 = p1?.next
        p2 = p2?.next
    }

    return dummy.next
}

fun main() {
    /**
     * Example 1:
     * Input: l1 = [2,4,3], l2 = [5,6,4]
     * Output: [7,0,8]
     * Explanation: 342 + 465 = 807.
     */
    println(addTwoNumbers(ListNode.quickList(arrayListOf(2, 4, 3))!!,
        ListNode.quickList(arrayListOf(5, 6, 4))!!))

    /**
     * Example 2:
     * Input: l1 = [0], l2 = [0]
     * Output: [0]
     */
    println(addTwoNumbers(ListNode.quickList(arrayListOf(0))!!,
        ListNode.quickList(arrayListOf(0))!!))

    /**
     * Example 3:
     * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * Output: [8,9,9,9,0,0,0,1]
     */
    println(addTwoNumbers(ListNode.quickList(arrayListOf(9,9,9,9,9,9,9))!!,
        ListNode.quickList(arrayListOf(9,9,9,9))!!))

}