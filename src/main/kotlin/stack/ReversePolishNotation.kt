package stack

import java.util.Stack

class ReversePolishNotation {
    fun evalRPN(tokens: Array<String>): Int {


        val stack: Stack<Int> = Stack()

        for (i in 0 until tokens.size) {


            if (tokens[i].contains("*/+-")) {
                when (tokens[i]) {
                    "*" -> {
                        val secondElement = stack.pop()
                        val firstElement = stack.pop()
                        val result = firstElement * secondElement
                        stack.push(result)

                    }

                    "/" -> {

                        val secondElement = stack.pop()
                        val firstElement = stack.pop()
                        val result = firstElement / secondElement
                        stack.push(result)

                    }

                    "+" -> {
                        val secondElement = stack.pop()
                        val firstElement = stack.pop()
                        val result = firstElement + secondElement
                        stack.push(result)
                    }

                    "-" -> {
                        val secondElement = stack.pop()
                        val firstElement = stack.pop()
                        val result = firstElement - secondElement
                        stack.push(result)

                    }
                }
            } else {
                stack.push(tokens[i].toInt())
            }


        }
        return stack.pop()
    }
}