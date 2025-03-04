import array.OrangesRotting
import array.OrangesRottingBFS
import linkedlist.ListNode
import linkedlist.RemoveNthNodeFromLinkedList
import linkedlist.ReorderList
import linkedlist.ReverseLinkedList2
import tree.PathSum2
import tree.`Sum Root to Leaf Numbers`
import tree.SymmetricTree
import tree.TreeNode

fun main(args: Array<String>) {

    val orangeRotting = OrangesRottingBFS()
    var grid = arrayOf(
        intArrayOf(2, 2),
        intArrayOf(1, 1),
        intArrayOf(0, 0),
        intArrayOf(2, 0)
    )
    println(orangeRotting.orangesRotting(grid))

}