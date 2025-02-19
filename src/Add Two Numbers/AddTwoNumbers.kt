package `Add Two Numbers`

import utils.ListNode

/**
 *
 * 解題思路(Medium)
 * 本題練習的是針對 linked list 的操作
 * 在 Kotlin 解題需要注意的是 val 是關鍵字
 * 所以需要 以 `` 標記(這題不使用反引號保留字作法)
 *
 * 網站 : https://leetcode.com/problems/add-two-numbers/
 *
 * 整體來說，Add Two Numbers 的核心在於「逐位相加」與「處理進位」。
 * 因為串列已經是「反序」儲存，所以可以從頭到尾同時加，不用像一般字串還要先反轉。
 * 最後只要用一個虛擬頭節點來簡化串列的連接，就能輕鬆完成整個加總並返回結果。
 *
 * 解題思路
 * 	1.	指標遍歷
 * 	•	用 p1、p2 分別指向 l1、l2 的起始節點。
 * 	•	每次取出 p1 與 p2 當前節點的數值，若節點為 null，則視為 0。
 * 	2.	進位 (carry) 處理
 * 	•	設一個變數 carry（初始為 0），用來儲存每次相加的進位。
 * 	•	每輪計算 sum = x + y + carry，其中 x、y 分別是 p1、p2 的節點值（或 0）。
 * 	•	更新 carry = sum / 10，以及該位數字 digit = sum % 10。
 * 	3.	建立結果串列
 * 	•	用一個「虛擬頭節點」(dummy) 來簡化操作，最後真正回傳 dummy.next。
 * 	•	把每次計算出的 digit 存入新節點，連到結果串列的尾端。
 * 	4.	推進指標
 * 	•	每次迴圈結束後，p1、p2 分別移到下一個節點（若有）。
 * 	•	繼續迴圈直到 p1、p2 均為 null 且 carry 為 0 才停止。
 * 	5.	返回結果
 * 	•	完成迴圈後，結果串列已完整建好。
 * 	•	回傳 dummy.next 作為最終的加總結果。
 *
 * 	主要實作細節
 * 	1.	避免空指標
 * 	•	建議把 p1、p2 宣告為 ListNode? 型別，迴圈條件為 while (p1 != null || p2 != null || carry != 0) { ... }。
 * 	•	取值時用 (p1?.value ?: 0)、移動時用 p1 = p1?.next。
 * 	•	這樣就不會因為 p1、p2 到達尾端而拋出空指標異常。
 * 	2.	虛擬頭節點 (dummy)
 * 	•	新建一個節點 dummy = ListNode(0)。
 * 	•	用 current 指向結果串列尾端，每次新建節點時 current.next = ListNode(digit) 並更新 current = current.next!!。
 * 	•	最後回傳 dummy.next。
 * 	3.	時間與空間複雜度
 * 	•	時間複雜度：O(max(m, n))，其中 m、n 是兩個串列的長度。
 * 	•	空間複雜度：O(max(m, n))，結果串列可能比原串列多一個節點（最高位進位）。
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