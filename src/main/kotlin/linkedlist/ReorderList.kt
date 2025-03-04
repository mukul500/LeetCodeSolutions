package linkedlist

class ReorderList {
    fun reorderList2(head: ListNode?): Unit {
        var middleOfTheLinkedList: ListNode? = null

        if (head == null) return
        var walker = head
        var runner = head.next?.next

        while (runner?.next != null) {
            walker = walker?.next
            runner = runner.next?.next
        }
        middleOfTheLinkedList = walker
        println("Middle of linkedlist ${middleOfTheLinkedList?.`val`}")


        val leftSideOfLinkedList = ListNode(head.`val`)
        var leftBuildPointer: ListNode? = leftSideOfLinkedList
        var pointer = head
        while (pointer != middleOfTheLinkedList) {
            pointer = pointer?.next
            leftBuildPointer?.next = ListNode(pointer?.`val`!!)
            leftBuildPointer = leftBuildPointer?.next
        }
        leftBuildPointer?.next = null

        val reversedRightSide = reverseList(middleOfTheLinkedList?.next)
        println("Reversed Right Side ${reversedRightSide?.`val`}")
//        middleOfTheLinkedList?.next = null

        var leftPointer: ListNode? = leftSideOfLinkedList
        var rightPointer = reversedRightSide
        var currentPointer = head


        while (leftPointer != null) {
            print("${leftPointer.`val`} -> ")
            leftPointer = leftPointer.next
        }
        leftPointer = leftSideOfLinkedList
        println("\n\n")
        while (rightPointer != null) {
            print("${rightPointer.`val`} -> ")
            rightPointer = rightPointer.next
        }
        rightPointer = reversedRightSide

        var count = 0

        println("Existing List\n\n")
        while (currentPointer != null) {
            print("${currentPointer.`val`} -> ")
            currentPointer = currentPointer.next
        }

        currentPointer = head
        while (leftPointer != null && rightPointer != null) {
            if (count % 2 == 0) {
                currentPointer?.`val` = leftPointer.`val`
                leftPointer = leftPointer.next

            } else {
                currentPointer?.`val` = rightPointer.`val`
                rightPointer = rightPointer.next
            }
            currentPointer = currentPointer?.next
            count++
        }

        while (leftPointer != null) {
            println("Left Pointer ${leftPointer.`val`}")
            println("Next Pointer ${leftPointer.next?.`val`} ")
            println("Current Pointer ${currentPointer?.`val`}")
            currentPointer?.`val` = leftPointer.`val`
            leftPointer = leftPointer.next
            if (leftPointer != null) {
                currentPointer = currentPointer?.next
            } else {
                currentPointer?.next = null
            }
        }
        while (rightPointer != null) {
            currentPointer?.`val` = rightPointer.`val`
            rightPointer = rightPointer.next
            if (rightPointer != null) {
                currentPointer = currentPointer?.next
            } else {
                currentPointer?.next = null
            }
        }

        currentPointer?.next = null
        var pointerNew = head
        print("\n\n")
        while (pointerNew != null) {
            print("${pointerNew.`val`} -> ")
            pointerNew = pointerNew.next
        }

    }


    fun reorderList(head: ListNode?): Unit {
        val middleNode = findMiddleNode(head)
        val rightSide = middleNode?.next
        val reversedRightSide = reverseList(rightSide)
        middleNode?.next = null
        merge2Lists(head, reversedRightSide)

    }

    private fun printNodes(node: ListNode?) {
        var pointer = node
        while (pointer != null) {
            print("${pointer.`val`} ->")
            pointer = pointer.next
        }
        println()
    }

    private fun merge2Lists(leftSideStart: ListNode?, rightSideStart: ListNode?) {
        var currentPointer = leftSideStart
        var leftPointer = leftSideStart?.next
        var rightPointer = rightSideStart

        while (leftPointer != null && rightPointer != null) {
            currentPointer?.next = rightPointer
            rightPointer = rightPointer.next
            currentPointer = currentPointer?.next
            currentPointer?.next = leftPointer
            leftPointer = leftPointer.next
            currentPointer = currentPointer?.next
        }

        while (leftPointer != null) {
            currentPointer?.next = leftPointer
            leftPointer = leftPointer.next
            currentPointer = currentPointer?.next
        }
        while (rightPointer != null) {
            currentPointer?.next = rightPointer
            rightPointer = rightPointer.next
            currentPointer = currentPointer?.next
        }

    }

    private fun findMiddleNode(head: ListNode?): ListNode? {
        if (head == null) return null
        var walker = head
        var runner = head
        while (runner?.next != null) {
            walker = walker?.next
            runner = runner.next?.next
        }
        return walker
    }

    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) return null
        var reversedList = ListNode(head.`val`)
        reversedList.next = null
        var next = head.next
        while (next != null) {
            val temp = next.next
            next.next = reversedList
            reversedList = next
            next = temp

        }
        return reversedList
    }

}