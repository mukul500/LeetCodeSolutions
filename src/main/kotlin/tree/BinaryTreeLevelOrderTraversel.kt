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

        if (root == null)
            return traverselOrder.toList()
        else {
            traverselOrder.add(listOf(root.`val`))
            queue.offer(root)
        }


        while (queue.isNotEmpty()) {
            val currentLevelNode = mutableListOf<TreeNode>()
            val currentLevelValue = mutableListOf<Int>()
            while (queue.isNotEmpty()){
                val node = queue.poll()
                if(node.left !=null){
                    currentLevelNode.add(node.left!!)
                    currentLevelValue.add(node.left!!.`val`)
                }
                if(node.right != null){
                    currentLevelNode.add(node.right!!)
                    currentLevelValue.add(node.right!!.`val`)
                }
            }
            currentLevelNode.forEach {
                queue.offer(it)
            }

            if(currentLevelValue.isNotEmpty()){
                traverselOrder.add(currentLevelValue)
            }
        }
        return traverselOrder
    }
}