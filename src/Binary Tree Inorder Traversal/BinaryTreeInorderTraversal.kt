package `Binary Tree Inorder Traversal`

/**
 *
 * 解題思路(Easy)
 *
 * 網站 : https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 *
 *  題目設計目的
 * 	1.	基本樹遍歷概念
 * 	•	中序遍歷 (Inorder Traversal) 是二元樹三種經典遍歷 (前序、後序、中序) 之一，可幫助你熟悉樹的遞迴結構及其在演算法中的運用。
 * 	2.	遞迴與迭代
 * 	•	題目特別指出：遞迴版本很直觀，是否能用迭代（非遞迴）方式實現？這考驗你對資料結構 (如堆疊) 與遞迴本質的理解。
 * 	3.	樹的構造與邊界情況
 * 	•	可能出現空樹 ([])，或僅有一個節點 ([1])，以及更複雜的樹形結構，需要對各種情況做正確處理。
 *
 *  中序遍歷的定義
 *
 * 對於一棵二元樹的中序遍歷順序為：
 * 	1.	先遍歷左子樹 (Inorder)
 * 	2.	訪問當前節點
 * 	3.	再遍歷右子樹 (Inorder)
 *
 * 例如：
 * 	•	對於樹 [1,null,2,3] (圖示為根節點 1 沒有左子樹，右子樹是 2，而 2 的左子樹是 3)，
 * 中序遍歷結果為 [1,3,2]。
 *
 * 範例內容解釋
 * 	•	樹的構造：
 * 	•	根節點的值為 1。
 * 	•	根節點的左子節點為 2，右子節點為 3。
 * 	•	節點 2 又有左右子節點：左邊為 4，右邊為 5。
 * 	•	中序遍歷順序：
 * 	1.	先從根節點 1 開始，進入左子樹。
 * 	2.	在節點 2 處，繼續往左，直到節點 4（沒有左子節點），先訪問 4。
 * 	3.	返回節點 2，訪問 2，然後進入節點 2 的右子樹，訪問 5。
 * 	4.	返回根節點 1，訪問 1。
 * 	5.	最後進入根節點 1 的右子樹，訪問節點 3。
 * 結果依序為 [4, 2, 5, 1, 3]。
 * 	•	程式呼叫：
 * 	•	在 main() 中建立樹，然後呼叫 inorderTraversal(root) 取得遍歷結果，最後印出結果。
 *
 * 程式流程與思路詳細解釋
 * 	1.	TreeNode 類別定義
 * 	•	此處使用 value 作為節點數值，不使用反引號包住的 val。
 * 	•	每個節點都有 left 與 right 子節點，預設為 null。
 * 	2.	buildTreeFromLevelOrder 函式
 * 	•	根據給定的 List<Int?>（層序表示）建立二元樹。
 * 	•	如果列表為空或第一個元素為 null，則返回 null（空樹）。
 * 	•	利用一個隊列依序建立每個節點的左右子節點。
 * 	•	例如，對於 Example 1 的 [1, null, 2, 3]，會建立如下樹：
 *
 * 	    1
 *      \
 *       2
 *      /
 *     3
 *
 *  3.	inorderTraversal 函式
 * 	•	以迭代方式實現中序遍歷：
 * 	•	初始化一個空堆疊和一個結果列表。
 * 	•	從根節點開始，先向左走到底並將沿途節點推入堆疊。
 * 	•	當沒有左子節點時，彈出堆疊頂節點並將其數值加入結果列表，然後轉向該節點的右子樹。
 * 	•	重複上述步驟直到遍歷完整棵樹。
 * 	•	最終返回結果列表，即中序遍歷的節點值順序。
 * 	4.	main 函式與範例呼叫
 * 	•	分別建立四個範例的二元樹：
 * 	•	Example 1: 層序 [1, null, 2, 3] → 預期中序輸出：[1, 3, 2]
 * 	•	Example 2: 層序 [1,2,3,4,5,null,8,null,null,6,7,9] → 預期中序輸出：[4,2,6,5,7,1,3,9,8]
 * 	•	Example 3: 空列表 → 輸出空列表 []
 * 	•	Example 4: 層序 [1] → 輸出 [1]
 * 	•	呼叫 inorderTraversal 函式取得各範例的中序遍歷結果，並印出檢查。
 *
 *
 *
 * */

// 定義二元樹節點，使用 value 而非反引號包住的 `val`
class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

/**
 * 根據層序表示建立二元樹
 * values：List<Int?> 表示層序遍歷結果，null 表示該位置無節點
 */
fun buildTreeFromLevelOrder(values: List<Int?>): TreeNode? {
    if (values.isEmpty() || values[0] == null) return null

    val root = TreeNode(values[0]!!)
    val queue = ArrayDeque<TreeNode>()
    queue.addLast(root)
    var i = 1

    while (i < values.size && queue.isNotEmpty()) {
        val current = queue.removeFirst()
        // 處理左子節點
        if (i < values.size && values[i] != null) {
            current.left = TreeNode(values[i]!!)
            queue.addLast(current.left!!)
        }
        i++
        // 處理右子節點
        if (i < values.size && values[i] != null) {
            current.right = TreeNode(values[i]!!)
            queue.addLast(current.right!!)
        }
        i++
    }
    return root
}

/**
 * 以「迭代」方式實現中序遍歷
 * 遍歷順序：左子樹 -> 當前節點 -> 右子樹
 */
fun inorderTraversal(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    val stack = ArrayDeque<TreeNode>()
    var current = root

    while (current != null || stack.isNotEmpty()) {
        // 1. 不斷向左子樹深入，將沿途節點壓入堆疊
        while (current != null) {
            stack.addLast(current)
            current = current.left
        }
        // 2. 左子樹走到底後，彈出堆疊頂端節點，加入結果
        val node = stack.removeLast()
        result.add(node.value)
        // 3. 將指標移動到右子樹，重複上述步驟
        current = node.right
    }

    return result
}

fun main() {
    /*
       範例樹的結構如下：

              1
             / \
            2   3
           / \
          4   5

       中序遍歷的順序：
       - 先訪問最左側節點 4
       - 回到節點 2，再訪問 2 的右子樹 5
       - 回到節點 1，再訪問右子樹 3

       最終中序遍歷結果應為：[4, 2, 5, 1, 3]
    */

    // 建立樹節點
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left?.left = TreeNode(4)
    root.left?.right = TreeNode(5)

    // 呼叫 inorderTraversal 函式並取得結果
    val inorderResult = inorderTraversal(root)
    println("Inorder Traversal: $inorderResult")


    /**
     * Example 1:
    // Input: root = [1,null,2,3]
    // 樹的層序表示：[1, null, 2, 3]
    // 對應的樹結構：
    //      1
    //       \
    //        2
    //       /
    //      3
    // 中序遍歷順序：先訪問根 1 的左子樹 (空) → 訪問 1 →
    // 進入右子樹 2，再遍歷 2 的左子樹 → 訪問 3，再返回 2 的值
    // 最終結果：[1,3,2]
    */
    val tree1 = buildTreeFromLevelOrder(listOf(1, null, 2, 3))
    val result1 = inorderTraversal(tree1)
    println("Example 1 Inorder Traversal: $result1") // 預期輸出: [1, 3, 2]

    /**
     * Example 2:
    // Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
    // 層序表示：1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9
    // (注意：具體樹結構根據此層序建立)
    // 預期中序結果為：[4,2,6,5,7,1,3,9,8]
     */
    val tree2 = buildTreeFromLevelOrder(listOf(1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9))
    val result2 = inorderTraversal(tree2)
    println("Example 2 Inorder Traversal: $result2") // 預期輸出: [4,2,6,5,7,1,3,9,8]

    /**
     * Example 3:
    // Input: root = []
    // 空樹，預期輸出: []
     */
    val tree3 = buildTreeFromLevelOrder(emptyList())
    val result3 = inorderTraversal(tree3)
    println("Example 3 Inorder Traversal: $result3") // 預期輸出: []

    /**
     * Example 4:
    // Input: root = [1]
    // 單個節點的樹，預期輸出: [1]
     */
    val tree4 = buildTreeFromLevelOrder(listOf(1))
    val result4 = inorderTraversal(tree4)
    println("Example 4 Inorder Traversal: $result4") // 預期輸出: [1]

}