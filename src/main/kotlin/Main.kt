import linkedlist.ListNode
import linkedlist.RemoveNthNodeFromLinkedList
import linkedlist.ReverseLinkedList2
import tree.PathSum2
import tree.`Sum Root to Leaf Numbers`
import tree.SymmetricTree
import tree.TreeNode

fun main(args: Array<String>) {

    val removeNthNodeFromLinkedList = RemoveNthNodeFromLinkedList()
    val listNode = ListNode(1).apply { next = ListNode(2) }
    println(removeNthNodeFromLinkedList.removeNthFromEnd(listNode, 1))

}