package linkedlist


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class ReverseLinkedList {
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }
        var frontNode = ListNode(head.`val`)
        var backNode = head.next



        while (backNode != null) {
            val tempNode = backNode.next
            backNode.next = frontNode
            frontNode = backNode
            backNode = tempNode
        }

        return frontNode
    }
}