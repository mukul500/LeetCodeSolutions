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
import tree.*

fun main(args: Array<String>) {
    var nQueen = NQueen()
    val finalBoard = nQueen.solveNQueens(4)
    println(finalBoard)

}