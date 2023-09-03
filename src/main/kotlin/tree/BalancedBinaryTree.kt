package tree

import kotlin.math.abs

class BalancedBinaryTree {

    fun isBalanced(root: TreeNode?): Boolean {

        return isBalance(root)

    }

    private fun isBalance(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        if (root.left == null && root.right == null) {
            return true
        }
        return isBalance(root.left) && isBalance(root.right) && (height(root.left) - height(root.right)) <= 1
    }

    private fun height(node: TreeNode?): Int {

        //We return 0 if the node is null
        if (node == null) {
            return 0

        }
        else {
            // We calculate the height of the left subtree
            val leftHeight = height(node.left)
            // We calculate the height of the right subtree
            val rightHeight = height(node.right)
            // We return the height of the tree
            return (maxOf(leftHeight, rightHeight) + 1)
        }
    }

}