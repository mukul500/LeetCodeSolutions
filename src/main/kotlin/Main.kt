import array.OrangesRotting
import array.OrangesRottingBFS
import graphs.DetectCycleInGraph
import linkedlist.ListNode
import linkedlist.RemoveNthNodeFromLinkedList
import linkedlist.ReorderList
import linkedlist.ReverseLinkedList2
import tree.*

fun main(args: Array<String>) {

    val detectCycle = DetectCycleInGraph()
    val edges = listOf<Pair<Int, Int>>(
    )
    println(detectCycle.hasCycle(edges))
}