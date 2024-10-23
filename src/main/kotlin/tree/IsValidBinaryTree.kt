package tree

import kotlin.math.min

class IsValidBinaryTree {

    fun isValidBST(root: TreeNode?): Boolean {

        var leftBalance = true
        var rightBalance = true

        if (root == null) {
            return true
        }

        if (root.left == null || root.left!!.`val` < root.`val`) {
            leftBalance = isValidBST(root.left)
        } else {
            return false
        }
        if (root.right == null || root.right!!.`val` > root.`val`) {
            rightBalance = isValidBST(root.right)
        } else {
            return false
        }

        return leftBalance && rightBalance

    }
}


class isValidBST {

    fun isValidBST(root: TreeNode?): Boolean {
        return isValidBST(root = root, minimum = Long.MIN_VALUE, maximum = Long.MAX_VALUE)
    }

    private fun isValidBST(root: TreeNode?, minimum: Long, maximum: Long): Boolean {
        var leftBalance = true
        var rightBalance = true
        if (root == null) return true
        if (root.`val` > minimum && root.`val` < maximum) {
            leftBalance = isValidBST(root = root.left, maximum = root.`val`.toLong(), minimum = minimum)
            if (!leftBalance) return false
            rightBalance = isValidBST(root = root.right, maximum = maximum, minimum = root.`val`.toLong())
        } else {
            return false
        }

        return rightBalance
    }
}