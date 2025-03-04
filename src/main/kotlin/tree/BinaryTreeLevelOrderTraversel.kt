package tree

import com.sun.source.tree.Tree
import java.util.LinkedList
import java.util.Queue


/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 */
class BinaryTreeLevelOrderTraversel {

    fun levelOrder(root: TreeNode?): List<List<Int>> {

        val traverselOrder: ArrayList<List<Int>> = ArrayList()
        val queue: Queue<TreeNode> = LinkedList<TreeNode>()

        if (root == null) return traverselOrder.toList()
        else {
            traverselOrder.add(listOf(root.`val`))
            queue.offer(root)
        }


        while (queue.isNotEmpty()) {
            val currentLevelNode = mutableListOf<TreeNode>()
            val currentLevelValue = mutableListOf<Int>()
            while (queue.isNotEmpty()) {
                val node = queue.poll()
                if (node.left != null) {
                    currentLevelNode.add(node.left!!)
                    currentLevelValue.add(node.left!!.`val`)
                }
                if (node.right != null) {
                    currentLevelNode.add(node.right!!)
                    currentLevelValue.add(node.right!!.`val`)
                }
            }
            currentLevelNode.forEach {
                queue.offer(it)
            }

            if (currentLevelValue.isNotEmpty()) {
                traverselOrder.add(currentLevelValue)
            }
        }
        return traverselOrder
    }
}

class BinaryTreeLevelOrderTraversel2 {

    fun levelOrder(root: TreeNode?): List<List<Int>> {

        val list = ArrayList<List<Int>>()
        if (root == null) return list
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        list.add(listOf(root.`val`))
        while (queue.isNotEmpty()) {
            val currentLevel: Queue<TreeNode> = LinkedList()
            val leftRightList = mutableListOf<Int>()
            while (queue.isNotEmpty()) {
                val head = queue.poll()
                if (head.left != null) {
                    leftRightList.add(head.left!!.`val`)
                    currentLevel.add(head.left)
                }
                if (head.right != null) {
                    leftRightList.add(head.right!!.`val`)
                    currentLevel.add(head.right)
                }

            }
            if (leftRightList.isNotEmpty()) {
                list.add(leftRightList)
            }
            currentLevel.forEach {
                queue.add(it)
            }

        }
        return list
    }
}

class BinaryTreeLevelOrderTraversel3 {

    fun levelOrder(root: TreeNode?): List<List<Int>> {

        val finalList: MutableList<MutableList<Int>> = mutableListOf()
        fun traverseTree(node: TreeNode?, level: Int) {
            if (node == null) return
            if (level >= finalList.size) {
                finalList.add(level, mutableListOf())
            }
            finalList[level].add(node.`val`)
            traverseTree(node = node.left, level = level + 1)
            traverseTree(node = node.right, level = level + 1)
        }

        traverseTree(node = root, 0)
        return finalList

    }

}