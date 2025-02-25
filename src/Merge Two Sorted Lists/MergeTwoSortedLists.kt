package `Merge Two Sorted Lists`

import utils.ListNode


/**
 *
 * 解題思路(Easy)
 * 這題和 Add Two Numbers 類似
 * 主要考的是針對 linked list 的操作
 *
 * 網站 : https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * 題目解釋
 *
 * 你有兩個已排序(非遞減順序)的單向鏈結串列：list1 與 list2。需要將它們合併成一個新的「已排序」的鏈結串列，並回傳該新鏈結串列的頭節點。
 * 	•	已排序表示：list1 和 list2 中的節點值都按從小到大的順序排列。
 * 	•	合併表示：將兩條鏈結串列的節點串接在一起（不需要新建節點，直接利用原本的節點）。
 * 	•	回傳結果：合併後的新串列，也必須是從小到大排序。
 *
 * 範例
 * 	1.	Example 1
 * 	•	Input: list1 = [1,2,4], list2 = [1,3,4]
 * 	•	Output: [1,1,2,3,4,4]
 * 	•	合併後的結果是依序擷取較小的節點，形成 [1,1,2,3,4,4]。
 * 	2.	Example 2
 * 	•	Input: list1 = [], list2 = []
 * 	•	Output: []
 * 	•	兩條鏈結串列皆為空，合併後依然是空串列。
 * 	3.	Example 3
 * 	•	Input: list1 = [], list2 = [0]
 * 	•	Output: [0]
 * 	•	其中一條鏈結串列為空，因此結果直接是另一條不為空的串列。
 *
 * 	解題思路
 *
 * 合併兩個已排序串列的核心，就是同時遍歷 list1 與 list2，每次從兩條鏈結串列的「頭部」取出較小的節點，串接到結果串列末端，並將指標往後移動。直到至少有一條串列走到末端後，再把剩餘的節點串上去。
 *
 * 這裡介紹迭代與遞歸兩種常見解法。
 *
 * 解法一：迭代 (Iterative)(使用此解法)
 * 	1.	虛擬頭節點 (dummy head)
 * 	•	建立一個「虛擬頭節點」(dummy node)，用 current 指標指向它。這個節點本身不存任何有意義的值，目的是在串列最前面作為佔位，以便在程式中簡化對「頭節點」的處理。
 * 	2.	遍歷並合併
 * 	•	同時遍歷 list1 與 list2：
 * 	•	比較當前節點的值：list1.val 與 list2.val
 * 	•	若 list1.val <= list2.val，則把 list1 的節點接到 current.next，並將 list1 往後移一位
 * 	•	否則，把 list2 的節點接到 current.next，並將 list2 往後移一位
 * 	•	最後將 current 往後移到剛接上的節點位置
 * 	3.	處理剩餘節點
 * 	•	當其中一條串列走到末端後，另一條串列可能還有尚未處理的節點。
 * 	•	直接把剩下的那一段串接到結果串列末端。
 * 	4.	回傳結果
 * 	•	由於有虛擬頭節點，最終結果的頭節點是 dummy.next。
 *
 * 時間複雜度
 * 	•	O(m + n)，其中 m, n 分別為 list1 與 list2 的長度，因為每個節點只會被處理一次。
 *
 *解法二：遞歸 (Recursive)
 * 	1.	遞歸思路
 * 	•	若 list1 或 list2 有一條為空，則直接返回另一條(因為沒有可比較的了)。
 * 	•	否則，判斷 list1.val 與 list2.val 大小，取較小的那個節點作為結果串列的頭節點，並遞歸合併剩餘部分。
 * 	2.	程式碼簡潔
 * 	•	遞歸方法的程式碼往往比較短，但要留意遞歸深度（對於題目範圍 0~50 個節點，沒有問題）。
 *
 * fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
 *     // 如果其中一條串列為空，直接返回另一條
 *     if (list1 == null) return list2
 *     if (list2 == null) return list1
 *
 *     // 若 list1 的值更小
 *     return if (list1.`val` <= list2.`val`) {
 *         list1.next = mergeTwoLists(list1.next, list2)
 *         list1
 *     } else {
 *         list2.next = mergeTwoLists(list1, list2.next)
 *         list2
 *     }
 * }
 *
 *
 * 小結
 * 	•	題目：合併兩個已排序的鏈結串列，並保持結果串列依舊有序。
 * 	•	解法：
 * 	•	迭代：使用虛擬頭節點，循環比較節點值，將較小的節點接到結果串列後面。
 * 	•	遞歸：根據較小的節點，遞歸合併剩下的節點。
 * 	•	時間複雜度：O(m + n)，m 與 n 分別為兩條串列的長度。
 * 	•	空間複雜度：
 * 	•	迭代：O(1) 額外空間(不計輸出串列空間)。
 * 	•	遞歸：O(m + n)（因為遞歸呼叫堆疊深度可達 m+n）。
 *
 * */

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    // 建立一個虛擬頭節點(dummy)，方便在結果串列前端插入節點
    val dummy = ListNode(0)
    var current = dummy

    var p1 = l1
    var p2 = l2

    // 同時遍歷 p1, p2
    while (p1 != null && p2 != null) {
        // 比較當前節點的 value，將較小的接到結果串列後
        if (p1.value <= p2.value) {
            current.next = p1
            p1 = p1.next
        } else {
            current.next = p2
            p2 = p2.next
        }
        current = current.next!!
    }

    // 若其中一條串列尚未走完，直接串接剩餘部分
    if (p1 != null) {
        current.next = p1
    } else if (p2 != null) {
        current.next = p2
    }

    // 結果串列的頭節點在 dummy.next
    return dummy.next
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