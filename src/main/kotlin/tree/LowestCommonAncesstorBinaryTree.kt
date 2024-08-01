package tree

import java.util.LinkedList
import java.util.Queue
import java.util.Stack

class LowestCommonAncesstorBinaryTree {

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        val pTraverseList = root.traverseTree(p)
        val qTraverseList = root.traverseTree(q)

        println(pTraverseList)
        println(qTraverseList)
        val finalList = pTraverseList.intersect(qTraverseList)
        if (finalList.isNotEmpty()) {
            return finalList.last()
        }
        return null
    }


    private fun TreeNode?.traverseTree(itemNode: TreeNode?): Set<TreeNode?> {
        val queue: Queue<TreeNode?> = LinkedList()
        queue.offer(this)
        val traverseList = mutableListOf<TreeNode?>()

        while (queue.isNotEmpty()) {
            val currentNode = queue.poll() ?: break
            traverseList.add(currentNode)
            if (currentNode.`val` == itemNode?.`val`) {
                break
            } else {
                queue.offer(currentNode.right)
                queue.offer(currentNode.left)
            }
        }
        return traverseList.toSet()
    }
}