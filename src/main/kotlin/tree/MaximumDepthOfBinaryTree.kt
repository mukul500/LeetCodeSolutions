package tree

import kotlin.math.max

class MaximumDepthOfBinaryTree {

    fun maxDepth(root: TreeNode?): Int {


        return calculateHeight(root)

    }


    /**
     * 1. If tree is empty then return 0
     * 2. Else If left subtree height is greater than right subtree then return left subtree height + 1
     */
    fun calculateHeight(root: TreeNode?) : Int{
        if(root == null)
            return 0
        else{
            return max(calculateHeight(root.left) +1, calculateHeight(root.right) + 1)
        }
    }
}