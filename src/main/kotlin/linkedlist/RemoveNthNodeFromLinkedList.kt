package linkedlist

class RemoveNthNodeFromLinkedList {

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var back = head

        var size = 0

        var currentHead = head
        while (currentHead != null) {
            size++
            currentHead = currentHead.next
        }
        currentHead = head
        var counter = 0
        if (size == n) return head?.next

        while (currentHead != null) {
            if ((size - n) == counter) {
                back?.next = currentHead.next
                break
            }
            back = currentHead
            currentHead = currentHead.next
            counter++
        }
        return head
    }
}


class RemoveNthNodeFromLinkedList2 {

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var back = head

        var slowPointer = head
        var fastPointer = head
        for (i in 0 until n) {
            fastPointer = fastPointer?.next
        }

        if (fastPointer == null) {
            return slowPointer?.next
        }

        while (fastPointer != null) {
            back = slowPointer
            slowPointer = slowPointer?.next
            fastPointer = fastPointer.next
        }
        back?.next = slowPointer?.next
        return head
    }
}