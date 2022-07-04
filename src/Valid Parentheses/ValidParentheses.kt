package `Valid Parentheses`


/**
 *
 * 解題思路
 * 這題可以很簡單的用 stack 來進行處理
 * 在 Kotlin 裏面，我們可以用 Deque 來協助我們建立一個 stack
 *
 * 網站 : https://leetcode.com/problems/valid-parentheses/
 *
 * */

fun isValid(s: String): Boolean {
    var deque = ArrayDeque<Char>()

    for (i in 0..s.length-1) {
        var character = s.get(i)
        println(character)
        if (character == '(' || character == '[' || character == '{')
        {
            deque.addFirst(character)
            continue;
        }
        if (deque.isEmpty()) {
            return false;
        }
        when (character) {
            ')' -> if (deque.first() == '(') {deque.removeFirst()} else { return false }
            ']' -> if (deque.first() == '[') {deque.removeFirst()} else { return false }
            '}' -> if (deque.first() == '{') {deque.removeFirst()} else { return false }
            else -> return false
        }
    }
    if(!deque.isEmpty()){
        return false
    }
    return true
}

fun main() {
    /**
     * Example 1:
     * Input: s = "()"
     * Output: true
     */
    println(isValid("()"))

    /**
     * Example 2:
     * Input: s = "()[]{}"
     * Output: true
     */
    println(isValid("()[]{}"))

    /**
     * Example 3:
     * Input: s = "(]"
     * Output: false
     */
    println(isValid("(]"))

}


