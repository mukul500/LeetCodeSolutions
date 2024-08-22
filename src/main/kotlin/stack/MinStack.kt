package stack

import java.util.*


class MinStack {


    private val stack: Stack<Int> = Stack()
    private val treeMap = TreeMap<Int, Int>()
    fun push(`val`: Int) {
        stack.push(`val`)
        treeMap.addNumber(`val`)
    }

    fun pop() {
        val number = stack.pop()
        treeMap.removeNumber(number)
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return treeMap.getMinimum()
    }

    private fun TreeMap<Int, Int>.removeNumber(value: Int) {
        if (this.contains(value)) {
            val currentValue = this[value]
            if (currentValue!! <= 1) {
                this.remove(value)
            } else {
                this[value] = currentValue - 1
            }
        }
    }

    private fun TreeMap<Int, Int>.getMinimum(): Int {
        return this.firstEntry().key
    }

    private fun TreeMap<Int, Int>.addNumber(value: Int) {
        if (this.contains(value)) {
            val currentValue = this[value]
            this[value] = currentValue!! + 1
        } else {
            this[value] = 1
        }
    }
}

class MinStack2 {
    private val stack: Stack<Int> = Stack()
    private val minStack: Stack<Int> = Stack()

    fun push(`val`: Int) {
        stack.push(`val`)
        if (minStack.isEmpty() || `val` <= minStack.peek()) {
            minStack.push(`val`)
        }
    }

    fun pop() {
        val number = stack.pop()
        if (number == minStack.peek()) {
            minStack.pop()
        }
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return minStack.peek()
    }
}


/**
 * Done in the 2nd time after 1 year
 */
class MinStack3 {

    private val primaryStack: Stack<Int> = Stack()
    private val minStack:
            Stack<Int> = Stack()


    fun push(`val`: Int) {
        if (minStack.isEmpty() || `val` <= minStack.peek()) {
            minStack.push(`val`)
        }
        primaryStack.push(`val`)
    }


    fun pop() {
        if (primaryStack.peek() == minStack.peek()) {
            minStack.pop()
        }
        primaryStack.pop()
    }

    fun top(): Int {
        return primaryStack.peek()
    }

    fun getMin(): Int {
        return minStack.peek()
    }
}
