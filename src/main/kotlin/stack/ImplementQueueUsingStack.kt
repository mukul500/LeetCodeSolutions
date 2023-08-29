package stack

import java.util.*

class MyQueue() {

    private val initialStack: Stack<Int> = Stack()
    private var transformedStack: Stack<Int> = Stack()



    // Push element x to the back of queue.
    fun push(x: Int) {
        initialStack.push(x)
    }

    // Removes the element from in front of queue and returns that element.
    fun pop(): Int {
        if (transformedStack.isEmpty()) {
            moveInitialStackToTransformedStack()
        }
        return transformedStack.pop()
    }

    // Get the front element.

    fun peek(): Int {
        if (transformedStack.isEmpty()) {
            moveInitialStackToTransformedStack()
        }
        return transformedStack.peek()
    }

    // Returns whether the queue is empty.
    fun empty(): Boolean {
        return transformedStack.isEmpty() && initialStack.isEmpty()

    }

    // Moves all the elements from the initial stack to the transformed stack

    private fun moveInitialStackToTransformedStack() {
        while (initialStack.isNotEmpty()) {
            transformedStack.push(initialStack.pop())
        }
    }

}