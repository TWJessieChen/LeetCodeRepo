package `Remove Duplicates from Sorted List`

/**
 *
 * 解題思路(Easy)
 *
 * 網站 : https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * 題目設計目的
 * 	1.	考察鏈結串列操作：
 * 這道題目主要考察如何遍歷單向鏈結串列，並在遍歷過程中修改節點的連接關係。由於鏈結串列是動態資料結構，熟悉節點操作（如跳過某些節點）非常重要。
 * 	2.	利用排序性質簡化問題：
 * 題目已經保證鏈結串列是已排序的（升序），因此重複的元素一定會相鄰。這樣就可以使用一個簡單的遍歷方式，當發現相鄰兩個節點值相同時，將後面的重複節點跳過。
 * 	3.	動手操作：
 * 這題還可以考察如何處理邊界情況，例如空鏈結串列或只有一個節點的情況，並且要求在原地修改鏈結串列而非建立新鏈結串列。
 *
 *解題思路
 * 	1.	初始化與特例處理
 * 	•	如果鏈結串列為空，直接返回 null。
 * 	•	設定一個指標（例如 current）指向 head。
 * 	2.	遍歷鏈結串列
 * 	•	由於鏈結串列已排序，所以只需要檢查 current 與 current.next 的值是否相同：
 * 	•	如果相同，則說明 current.next 是重複節點，將 current 的 next 指向 current.next.next，從而跳過重複節點。
 * 	•	如果不同，則直接將 current 移動到下一個節點。
 * 	3.	返回結果
 * 	•	遍歷完整個鏈結串列後，所有重複節點都已被跳過，返回 head 即可。
 *
 *程式流程與詳細解釋
 * 	1.	ListNode 類別定義：
 * 	•	class ListNode(var value: Int) 定義節點，包含一個整數屬性 value 與一個指向下一個節點的 next。
 * 	•	toString() 方法用於將鏈結串列轉換為字串形式，例如 "1->2->3"，方便在 main() 中印出檢查結果。
 * 	2.	deleteDuplicates 函式：
 * 	•	參數 head 為鏈結串列的頭節點。
 * 	•	使用一個指標 current 從頭開始遍歷鏈結串列。
 * 	•	在 while 迴圈中，當 current 與 current.next 都不為 null 時，檢查兩者的值是否相同：
 * 	•	若相同：將 current.next 指向 current.next.next，這樣就跳過了重複的節點。
 * 	•	若不同：將 current 移動到下一個節點。
 * 	•	最終返回 head，表示已處理完所有重複節點。
 * 	3.	buildLinkedList 輔助函式：
 * 	•	根據給定的整數陣列建立一個鏈結串列，便於後續測試。
 * 	4.	main 函式：
 * 	•	分別建立兩個測試例子：
 * 	•	Example 1: 輸入陣列 [1,1,2]，原始鏈結串列為 1->1->2，刪除重複後變成 1->2。
 * 	•	Example 2: 輸入陣列 [1,1,2,3,3]，原始鏈結串列為 1->1->2->3->3，刪除重複後變成 1->2->3。
 * 	•	印出原始鏈結串列與處理後的結果，方便檢查正確性。
 *
 *
 * 舉例範例如何執行
 *
 * Example 1 執行流程
 * 	•	初始陣列： [1,1,2]
 * 	•	利用 buildLinkedList 建立鏈結串列：
 * 	•	形成鏈結串列：1 -> 1 -> 2
 * 	•	呼叫 deleteDuplicates(list1)：
 * 	•	指標 current 初始指向第一個節點（值 1）。
 * 	•	檢查 current.value (1) 與 current.next.value (1)：相等 → 跳過重複節點
 * 	•	設置 current.next = current.next.next，鏈結變成 1 -> 2
 * 	•	將 current 移動到下一節點（值 2）。
 * 	•	此時 current.next 為 null，迴圈結束。
 * 	•	返回處理後的鏈結串列，結果為：1 -> 2
 * 	•	印出結果：Example 1 - After Deleting Duplicates: 1->2
 *
 * Example 2 執行流程
 * 	•	初始陣列： [1,1,2,3,3]
 * 	•	建立鏈結串列：1 -> 1 -> 2 -> 3 -> 3
 * 	•	呼叫 deleteDuplicates(list2)：
 * 	•	指標 current 指向第一個節點（值 1）。
 * 	•	比較第一個節點（1）與第二個節點（1）：相等 → 跳過，鏈結變成：1 -> 2 -> 3 -> 3
 * 	•	移動 current 到下一節點（值 2）。
 * 	•	比較 2 與其下一節點（值 3）：不相等，移動 current 到節點（值 3）。
 * 	•	比較節點（值 3）與下一節點（值 3）：相等 → 跳過重複，鏈結變成：1 -> 2 -> 3
 * 	•	移動 current，但此時 current.next 為 null，迴圈結束。
 * 	•	返回結果：1 -> 2 -> 3
 * 	•	印出結果：Example 2 - After Deleting Duplicates: 1->2->3
 *
 *小結
 * 	•	核心思路：
 * 由於鏈結串列已排序，重複元素必定相鄰，因此只需遍歷一次鏈結串列，
 * 檢查當前節點與下一個節點是否相同，若相同則跳過重複節點，達到刪除重複的目的。
 *
 * */

// 定義單向鏈結串列節點類別
class ListNode(var value: Int) {
    var next: ListNode? = null

    // 輔助方法：將鏈結串列轉換為字串形式，方便輸出檢查
    override fun toString(): String {
        val sb = StringBuilder()
        var curr: ListNode? = this
        while (curr != null) {
            sb.append(curr.value)
            if (curr.next != null) {
                sb.append("->")
            }
            curr = curr.next
        }
        return sb.toString()
    }
}

// 刪除排序鏈結串列中的重複節點，僅保留一個
fun deleteDuplicates(head: ListNode?): ListNode? {
    var current = head
    // 遍歷鏈結串列
    while (current != null && current.next != null) {
        // 若當前節點與下一個節點值相同，跳過下一個節點
        if (current.value == current.next!!.value) {
            current.next = current.next!!.next
        } else {
            // 若不同則移動到下一個節點
            current = current.next
        }
    }
    return head
}

// 輔助函式：根據整數陣列建立鏈結串列
fun buildLinkedList(arr: IntArray): ListNode? {
    if (arr.isEmpty()) return null
    val dummy = ListNode(0)
    var current = dummy
    for (num in arr) {
        current.next = ListNode(num)
        current = current.next!!
    }
    return dummy.next
}


fun main() {
    /**
     * Example 1:
     * Input: head = [1,1,2]
     * Output: [1,2]
     */
    val arr1 = intArrayOf(1, 1, 2)
    val list1 = buildLinkedList(arr1)
    println("Example 1 - Original List: $list1")
    val result1 = deleteDuplicates(list1)
    println("Example 1 - After Deleting Duplicates: $result1")

    /**
     * Example 2:
     * Input: head = [1,1,2,3,3]
     * Output: [1,2,3]
     */
    val arr2 = intArrayOf(1, 1, 2, 3, 3)
    val list2 = buildLinkedList(arr2)
    println("Example 2 - Original List: $list2")
    val result2 = deleteDuplicates(list2)
    println("Example 2 - After Deleting Duplicates: $result2")

}