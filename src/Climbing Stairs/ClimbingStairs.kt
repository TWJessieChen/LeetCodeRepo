package `Climbing Stairs`

/**
 *
 * 解題思路(Easy)
 *
 * 網站 : https://leetcode.com/problems/climbing-stairs/description/
 *
 *
 *題目解釋
 *
 * 題目描述：
 * 	•	假設你正在爬樓梯，到達樓頂需要 n 步。
 * 	•	每次你可以選擇爬 1 步或 2 步。
 * 	•	要求求出到達樓頂的所有不同爬法數量。
 *
 * 例如：
 * 	•	當 n = 2 時，有 2 種爬法：
 * 	1.	1 步 + 1 步
 * 	2.	2 步
 * 	•	當 n = 3 時，有 3 種爬法：
 * 	1.	1 步 + 1 步 + 1 步
 * 	2.	1 步 + 2 步
 * 	3.	2 步 + 1 步
 *
 *題目設計的目的
 * 	1.	動態規劃與斐波那契數列：
 * 	•	這題其實本質上是計算斐波那契數列的一個變形。你可以發現要到達第 n 層，你可以從第 n-1 層（再加一步）或從第 n-2 層（再加兩步）爬上來，因此解法可用動態規劃或斐波那契數列來解決。
 * 	2.	優化空間與時間：
 * 	•	題目限制 n 的值最大為 45，使用簡單的迭代方法即可解決，但也可以進一步思考空間複雜度優化，例如僅用兩個變數存儲上一個狀態的值。
 * 	3.	理解遞迴關係：
 * 	•	學習如何從遞迴思維轉換成迭代實現，這是面試中常考的一個題型。
 *
 *解題思路
 * 	1.	建立遞迴關係：
 * 	•	令 f(n) 為爬到第 n 層的爬法數量，則：
 * f(n) = f(n-1) + f(n-2)
 * 這是因為爬到 n 層可以從 n-1 層（爬 1 步）或 n-2 層（爬 2 步）到達。
 * 	•	基本情況：
 * f(1) = 1
 * f(2) = 2
 * 	2.	迭代實現：
 * 	•	從 3 到 n 依次計算 f(n)，可以使用一個迴圈並只保留最近兩個狀態的數值。
 *
 *舉例範例如何執行
 *
 * Example 1: n = 2
 * 	•	輸入: n = 2
 * 	•	由於 n <= 2，程式直接返回 2。
 * 	•	輸出: 2
 *
 * Example 2: n = 3
 * 	•	輸入: n = 3
 * 	•	初始化: prev = 1, curr = 2
 * 	•	進入迴圈 (i = 3):
 * 	•	next = 1 + 2 = 3
 * 	•	更新: prev = 2, curr = 3
 * 	•	返回 curr = 3
 * 	•	輸出: 3
 *
 * 其他示例: n = 4
 * 	•	輸入: n = 4
 * 	•	初始化: prev = 1, curr = 2
 * 	•	迴圈 i = 3:
 * 	•	next = 1 + 2 = 3
 * 	•	更新: prev = 2, curr = 3
 * 	•	迴圈 i = 4:
 * 	•	next = 2 + 3 = 5
 * 	•	更新: prev = 3, curr = 5
 * 	•	返回 curr = 5
 * 	•	輸出: 5
 * (代表 4 層的爬法：1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2)
 *
 *小結
 * 	•	核心思路：
 * 	•	到達第 n 層的爬法數量 f(n) = f(n-1) + f(n-2)，這與斐波那契數列類似。
 * 	•	利用迭代方法（或動態規劃）從底層逐步推算出答案。
 *
 * */
fun climbStairs(n: Int): Int {
    // 當 n 為 1 或 2 時直接返回結果
    if (n <= 2) return n

    // 使用兩個變數保存 f(n-2) 與 f(n-1)
    var prev = 1  // f(1)
    var curr = 2  // f(2)

    // 從 3 到 n 迭代計算
    for (i in 3..n) {
        val next = prev + curr  // f(i) = f(i-1) + f(i-2)
        prev = curr             // 更新 f(i-2)
        curr = next             // 更新 f(i-1)
    }
    return curr
}

fun main() {
    /**
     * Example 1:
     * Input: n = 2
     * Output: 2
     * Explanation: There are two ways to climb to the top.
     * 1. 1 step + 1 step
     * 2. 2 steps
     */
    val n1 = 2
    println("For n = $n1, number of distinct ways: ${climbStairs(n1)}")

    /**
     * Example 2:
     * Input: n = 3
     * Output: 3
     * Explanation: There are three ways to climb to the top.
     * 1. 1 step + 1 step + 1 step
     * 2. 1 step + 2 steps
     * 3. 2 steps + 1 step
     */
    val n2 = 3
    println("For n = $n2, number of distinct ways: ${climbStairs(n2)}")

}