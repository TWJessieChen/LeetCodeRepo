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

fun addTwoNumbers(a: ListNode, b: ListNode): ListNode {
    val dummy = ListNode()
    var cur: ListNode = dummy
    var pa: ListNode? = a
    var pb: ListNode? = b
    var sum: Int
    var carry = 0
    while (pa != null || pb != null) {
        sum = carry
        if (pa != null) {
            sum += pa.value
            pa = pa.next
        }
        if (pb != null) {
            sum += pb.value
            pb = pb.next
        }
        carry = sum / 10
        cur.next = ListNode(sum % 10)
        cur = cur.next as ListNode
    }
    if (carry > 0) {
        cur.next = ListNode(carry)
    }

    return dummy.next!!
}

fun main() {
    /**
     * Example 1:
     * Input: l1 = [2,4,3], l2 = [5,6,4]
     * Output: [7,0,8]
     * Explanation: 342 + 465 = 807.
     */
    println(addTwoNumbers(ListNode.quickList(arrayListOf(2, 4, 3)),
            ListNode.quickList(arrayListOf(5, 6, 4))))

    /**
     * Example 2:
     * Input: l1 = [0], l2 = [0]
     * Output: [0]
     */
    println(addTwoNumbers(ListNode.quickList(arrayListOf(0)),
        ListNode.quickList(arrayListOf(0))))

    /**
     * Example 3:
     * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * Output: [8,9,9,9,0,0,0,1]
     */
    println(addTwoNumbers(ListNode.quickList(arrayListOf(9,9,9,9,9,9,9)),
        ListNode.quickList(arrayListOf(9,9,9,9))))

}