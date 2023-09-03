package tree

import java.util.LinkedList
import java.util.Queue
import kotlin.math.max

class DiameterOfTree {
    fun diameterOfBinaryTree(root: TreeNode?): Int {

        var diameter = 0

        // We calculate the height of the tree and at the same time we calculate the diameter of the tree
        fun height(node: TreeNode?): Int {

            //We return 0 if the node is null
            if (node == null) {
                return 0

            }
            else {
                // We calculate the height of the left subtree
                val leftHeight = height(node.left)
                // We calculate the height of the right subtree
                val rightHeight = height(node.right)

                // We calculate the diameter of the tree in  every recursive call to find the maximum diameter from the current parent node
                diameter = maxOf((leftHeight + rightHeight), diameter)
                // We return the height of the tree
                return (maxOf(leftHeight, rightHeight) + 1)
            }
        }

        // We call the height function to calculate the height of the tree
        height(root)

        // We return the diameter of the tree
        return diameter

    }
}