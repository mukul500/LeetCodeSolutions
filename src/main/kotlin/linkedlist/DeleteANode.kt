package linkedlist

class DeleteANode {

    fun deleteNode(node: ListNode?) {

        if (node != null) {
            node.`val` = node.next!!.`val`
            node.next = node.next!!.next
        }
    }
}