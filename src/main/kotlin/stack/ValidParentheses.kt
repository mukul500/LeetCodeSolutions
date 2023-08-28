package stack

import java.util.EmptyStackException
import java.util.Stack

class ValidParentheses {
    fun isValid(s: String): Boolean {

        val stack = Stack<Char>()

        if(s.length % 2 !=0) return false

        for (i in s.indices) {
            stack.pushClosingBracket(s[i])
            try {
                if (s[i].isClosingBracket()) {
                    if (s[i] == stack.peek()) {
                        stack.pop()
                    } else {
                        return false
                    }
                }
            } catch (exce: EmptyStackException) {
                return false
            }

        }
        return stack.isEmpty()
    }

    private fun Char.isClosingBracket(): Boolean {
        return (this == ']' || this == '}' || this == ')')
    }

    private fun Stack<Char>.pushClosingBracket(char: Char) {
        if (char == '(') this.push(')')
        if (char == '{') this.push('}')
        if (char == '[') this.push(']')
    }

}