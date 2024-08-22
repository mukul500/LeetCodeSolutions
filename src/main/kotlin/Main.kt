import array.AbsoluteSort
import binarysearch.*
import dp.CoinChange
import dp.CoinChangeBFS
import dp.HouseRobber
import hashing.`Group Anagrams`
import hashing.`Word Pattern`
import map.MyHashMap
import stack.MinStack
import strings.BinaryAddition
import strings.LongestPalindromeSubString
import tree.BinaryTreeLevelOrderTraversel
import tree.TreeNode

fun main(args: Array<String>) {

   val pattern  = arrayOf(0).toIntArray()
    val hash = HouseRobber()
    println(hash.rob(pattern))
}