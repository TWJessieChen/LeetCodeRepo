package `Median of the two sorted arrays`

/**
 *
 * 解題思路(Medium) 但我覺接近Hard等級
 *
 * 網站 : https://leetcode.com/problems/median-of-two-sorted-arrays/
 *
 * 題目目標
 *
 * 給定兩個已排序的數組 nums1 和 nums2，要求在不合併兩個數組的情況下，以 O(log(m+n)) 的時間複雜度找出合併後的中位數。
 * 	•	若合併後總數為奇數，中位數為中間那個數。
 * 	•	若為偶數，中位數為中間兩個數的平均值。
 *
 * 解題思路總結
 * 	1.	保證較短數組進行二分搜尋
 * 	•	為了縮小搜尋範圍，先確保 nums1 是較短的數組。如果不是，交換兩個數組。
 * 	2.	劃分兩個數組
 * 	•	設 m 為 nums1 長度，n 為 nums2 長度，計算 halfLen = (m + n + 1) / 2。
 * 	•	我們的目標是將兩個數組劃分為左右兩部分，使得左邊總共包含 halfLen 個元素，且保證左半邊的最大值 ≤ 右半邊的最小值。
 * 	3.	利用二分搜尋找分割點
 * 	•	在 nums1 中進行二分搜尋，令 i 為 nums1 的分割點，j = halfLen - i 為 nums2 的分割點。
 * 	•	調整 i 的過程中檢查以下兩個條件：
 * 	•	如果 i 太小（i < m 且 nums2[j-1] > nums1[i]），則將 imin 更新為 i + 1。
 * 	•	如果 i 太大（i > 0 且 nums1[i-1] > nums2[j]），則將 imax 更新為 i - 1。
 * 	•	當上述條件都不再滿足時，表示找到了合適的分割點。
 * 	4.	計算中位數
 * 	•	定義左半邊的最大值 maxLeft：
 * 	•	若 i == 0，則 maxLeft = nums2[j-1]；
 * 	•	若 j == 0，則 maxLeft = nums1[i-1]；
 * 	•	否則，maxLeft = max(nums1[i-1], nums2[j-1])。
 * 	•	如果 (m+n) 為奇數，直接返回 maxLeft。
 * 	•	如果為偶數，再計算右半邊的最小值 minRight：
 * 	•	若 i == m，則 minRight = nums2[j]；
 * 	•	若 j == n，則 minRight = nums1[i]；
 * 	•	否則，minRight = min(nums1[i], nums2[j])。
 * 	•	中位數 = (maxLeft + minRight) / 2.0。
 *
 * 例子說明
 *
 * 以以下例子來解釋：
 *
 * 例子 1
 * 	•	Input: nums1 = [1, 3], nums2 = [2]
 * 	•	m = 2, n = 1
 * 	•	因為 nums1 長度大於 nums2，所以交換順序後讓較短數組作為 nums1（或者直接在程式中處理，確保 m ≤ n）。
 * 	•	合併後應有 3 個數，因此 halfLen = (2+1+1)/2 = 2。
 * 	•	二分搜尋在較短數組上找分割點，最終分割點將使左半邊包含 [1,2]，右半邊包含 [3]。
 * 	•	maxLeft 為 2（左邊最大值），因為總數為奇數，故中位數即為 2。
 *
 * 例子 2
 * 	•	Input: nums1 = [1, 2], nums2 = [3, 4]
 * 	•	m = 2, n = 2
 * 	•	halfLen = (2+2+1)/2 = 5/2 = 2
 * 	•	二分搜尋在 nums1 上進行：
 * 	•	假設初始選擇 i = 1，則 j = 2 - 1 = 1。
 * 	•	檢查條件發現 nums1[0] = 1 和 nums2[0] = 3，因此需調整分割點（具體細節依條件而定）。
 * 	•	最終找到正確分割點：i = 1, j = 1 或 i = 2, j = 0（取決於邊界處理）。
 * 	•	假設正確分割點為：nums1 劃分為 [1] 和 [2]，nums2 劃分為 [3] 和 [4]。
 * 	•	maxLeft = max(1, 3) = 3，minRight = min(2, 4) = 2（此處需根據正確的分割點進行判斷，實際上正確分割點應能讓左右兩邊數字對調使得 maxLeft = 2, minRight = 3）。
 * 	•	中位數 = (2 + 3) / 2 = 2.5。
 *
 * （注意：例子 2 中，實際正確分割點通常會選擇使得左半邊為 [1,2]，右半邊為 [3,4]，最終 maxLeft = 2，minRight = 3。）
 *
 * 結論
 *
 * 此解法利用二分搜尋在較短數組上找出一個正確的劃分點，使得兩個數組的左半邊（共 halfLen 個元素）中的最大值不大於右半邊的最小值，從而能在 O(log(min(m, n))) 的時間內求出中位數。
 * 	•	若總數為奇數，中位數即為左半邊最大值。
 * 	•	若為偶數，中位數則是左半邊最大值與右半邊最小值的平均值。
 *
 * 這就是解題思路與例子的詳細解釋。
 *
 * */

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    // 保證 nums1 是較短的陣列，這樣二分搜尋的範圍會更小
    if (nums1.size > nums2.size) {
        return findMedianSortedArrays(nums2, nums1)
    }

    val m = nums1.size
    val n = nums2.size
    var imin = 0
    var imax = m
    // halfLen 是左半部分的總元素數 (包含可能多出的一個在奇數情況)
    val halfLen = (m + n + 1) / 2

    // 在 nums1 上進行二分搜尋，找到合適的分割點 i
    while (imin <= imax) {
        val i = (imin + imax) / 2          // nums1 分割位置
        val j = halfLen - i                // nums2 分割位置，使得左半邊元素總數為 halfLen

        // 調整 i 的位置：
        // 如果 i 還沒達到 nums1 結尾，且 nums2[j-1] 大於 nums1[i]，表示 i 太小
        if (i < m && nums2[j - 1] > nums1[i]) {
            imin = i + 1
        }
        // 如果 i 大於 0，且 nums1[i-1] 大於 nums2[j]，表示 i 太大
        else if (i > 0 && nums1[i - 1] > nums2[j]) {
            imax = i - 1
        }
        // 找到了合適的分割點
        else {
            // 找到左半邊的最大值
            val maxLeft = when {
                i == 0 -> nums2[j - 1]       // 如果 i == 0，表示 nums1 左側沒有元素
                j == 0 -> nums1[i - 1]       // 如果 j == 0，表示 nums2 左側沒有元素
                else -> maxOf(nums1[i - 1], nums2[j - 1])
            }

            // 如果總數量為奇數，則中位數即為左半邊的最大值
            if ((m + n) % 2 == 1) {
                return maxLeft.toDouble()
            }

            // 找右半邊的最小值
            val minRight = when {
                i == m -> nums2[j]           // 如果 i == m，表示 nums1 右側沒有元素
                j == n -> nums1[i]           // 如果 j == n，表示 nums2 右側沒有元素
                else -> minOf(nums1[i], nums2[j])
            }

            // 如果總數量為偶數，中位數為左半邊最大值與右半邊最小值的平均值
            return (maxLeft + minRight) / 2.0
        }
    }

    // 如果程式能走到這裡，表示輸入有誤
    throw IllegalArgumentException("Input arrays are not valid")
}

fun main() {
    /**
     * Example 1:
     * Input: nums1 = [1,3], nums2 = [2]
     * Output: 2.00000
     * Explanation: merged array = [1,2,3] and median is 2.
     */
    val nums1Example1 = intArrayOf(1, 3)
    val nums2Example1 = intArrayOf(2)
    println(findMedianSortedArrays(nums1Example1, nums2Example1))

    /**
     * Example 2:
     * Input: nums1 = [1,2], nums2 = [3,4]
     * Output: 2.50000
     * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
     */
    val nums1Example2 = intArrayOf(1, 2)
    val nums2Example2 = intArrayOf(3, 4)
    println(findMedianSortedArrays(nums1Example2, nums2Example2))

}