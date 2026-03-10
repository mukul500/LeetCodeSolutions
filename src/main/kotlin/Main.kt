import array.*
import graphs.DetectCycleInGraph
import graphs.NumberOfIsland
import graphs.ZeroOneMatrix
import linkedlist.ListNode
import linkedlist.RemoveNthNodeFromLinkedList
import linkedlist.ReorderList
import linkedlist.ReverseLinkedList2
import stack.CarFleets
import strings.DecodingString
import binarysearch.MedianOfTwoSortedArray
import graphs.ValidGraph
import tree.*

fun main(args: Array<String>) {

    val validGraph = ValidGraph()
    val edges: Array<IntArray> = arrayOf(
        intArrayOf(0, 1), // Edge between node 0 and node 1
        intArrayOf(1, 2), // Edge between node 1 and node 2
        intArrayOf(2, 3), // Edge between node 2 and node 3
        intArrayOf(3, 1),
        intArrayOf(1, 4),
    )
    println(validGraph.validTree(5, edges))
}