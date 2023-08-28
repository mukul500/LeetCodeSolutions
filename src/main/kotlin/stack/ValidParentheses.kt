package stack

import java.util.EmptyStackException
import java.util.Stack

class ValidParentheses {
    fun isValid(s: String): Boolean {

        // First check if the string is empty
        if (s.isEmpty()) return true

        // Check if the string is odd means it is not valid there is bracket missing
        if (s.length % 2 != 0) return false

        //We Declare a Stack to store the characters
        val stack = Stack<Char>()

        //We Iterate through the string
        for (i in s.indices) {

            //If the character is an opening bracket, we push the closing bracket to the stack
            stack.pushClosingBracket(s[i])

            //If the character is a closing bracket
            if (s[i].isClosingBracket()) {
                //If the stack is not empty and the character is equal to the top of the stack, we pop the top of the stack
                if (stack.isNotEmpty() && s[i] == stack.peek()) {
                    stack.pop()
                }
                //If the stack is empty or the character is not equal to the top of the stack, we return false
                else {
                    return false
                }
            }
        }
        //If the stack is empty, we return true
        return stack.isEmpty()
    }


    //This function is used to check if the character is a closing bracket
    private fun Char.isClosingBracket(): Boolean {
        return (this == ']' || this == '}' || this == ')')
    }

    //This function is used to push the closing bracket to the stack
    private fun Stack<Char>.pushClosingBracket(char: Char) {
        if (char == '(') this.push(')')
        if (char == '{') this.push('}')
        if (char == '[') this.push(']')
    }

}