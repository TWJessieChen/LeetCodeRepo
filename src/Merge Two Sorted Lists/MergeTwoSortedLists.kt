package `Merge Two Sorted Lists`

import utils.ListNode


/**
 *
 * 解題思路
 * 這題和 Add Two Numbers 類似
 * 主要考的是針對 linked list 的操作
 *
 * 網站 : https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * */

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null && l2 == null) {
        return null
    }
    if (l1 == null) {
        return l2
    }
    if (l2 == null) {
        return l1
    }
    var temp = ListNode(-1)
    val ret = temp
    var localL1 = l1
    var localL2 = l2
    while (localL1 != null && localL2 != null) {
        if (localL1.value < localL2.value) {
            temp.next = localL1
            localL1 = localL1.next
        } else {
            temp.next = localL2
            localL2 = localL2.next
        }
        temp = temp.next!!
    }
    temp.next = localL1 ?: localL2
    return ret.next
}

fun main() {
    /**
     * Example 1:
     * Input: list1 = [1,2,4], list2 = [1,3,4]
     * Output: [1,1,2,3,4,4]
     */

    println(
        mergeTwoLists(ListNode.quickList(arrayListOf(1,2,4)),
        ListNode.quickList(arrayListOf(1,3,4)))
    )

    /**
     * Example 2:
     * Input: list1 = [], list2 = []
     * Output: []
     */
    println(
        mergeTwoLists(ListNode.quickList(arrayListOf()),
            ListNode.quickList(arrayListOf()))
    )

    /**
     * Example 3:
     * Input: list1 = [], list2 = [0]
     * Output: [0]
     */
    println(
        mergeTwoLists(ListNode.quickList(arrayListOf(0)),
            ListNode.quickList(arrayListOf()))
    )

}