import algo.calculateSHA256Checksum
import array.*
import binarysearch.*
import dp.*
import hashing.`Group Anagrams`
import hashing.`Word Pattern`
import map.MyHashMap
import stack.MinStack
import strings.BinaryAddition
import strings.LongestPalindromeSubString
import tree.BinaryTreeLevelOrderTraversel
import tree.TreeNode
import java.io.File

fun main(args: Array<String>) {
  var precalculatedSHA = "bf86440bd9752acfbf3a1b6bde79a68c7f2d728b6c0bf2ff7607201068de221d"
  var sha = calculateSHA256Checksum(File("/Users/mukulbanga/Documents/LeetCodeSolutions/src/main/kotlin/app-bodyWear-release_126.apk"))
    println(sha)
    if(precalculatedSHA == sha) {
        println("SHA matches")
    } else {
        println("SHA does not match")
    }
}