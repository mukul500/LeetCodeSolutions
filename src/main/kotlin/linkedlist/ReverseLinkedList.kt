package linkedlist


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


class ReverseLinkedList {
    fun reverseList(head: ListNode?): ListNode? {

        // We check if the head is null we return null
        if (head == null) {
            return null
        }

        // We create a front node with the head value
        //We use the Front node as a end node and previous node will have the reference to the next node
        var frontNode = ListNode(head.`val`)
        // We create a back node with the next value
        var backNode = head.next


        // We iterate through the list
        while (backNode != null) {
            // We create a temp node to store the next node
            val tempNode = backNode.next
            // We set the next node of the back node to the front node
            backNode.next = frontNode
            // We set the front node to the back node
            frontNode = backNode
            // We set the back node to the temp node
            backNode = tempNode
        }

        // We return the front node
        return frontNode
    }
}