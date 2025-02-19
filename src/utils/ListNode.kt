package utils


class ListNode(var value: Int = -1, var next: ListNode? = null) {
    override fun toString(): String {
        return "$value -> ${next.toString()}"
    }

    companion object {
        // 快速生成鏈結串列，用於測試
        fun quickList(nodes: List<Int>): ListNode? {
            val dummy = ListNode()
            nodes.reversed().forEach {
                dummy.next = ListNode(it, dummy.next)
            }
            return dummy.next
        }
    }
}