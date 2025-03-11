package tree

class CousinsInATree {

    fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
        val xParentAndDepth = findDepthAndParent(root, x, 0)
        val yParentAndDepth = findDepthAndParent(root, y, 0)
        println(xParentAndDepth)
        println(yParentAndDepth)
        return xParentAndDepth?.first == yParentAndDepth?.first && xParentAndDepth?.second != yParentAndDepth?.second

    }

    /**
     * Returns the Pair of depth and parent
     */
    private fun findDepthAndParent(node: TreeNode?, child: Int, depth: Int): Pair<Int, Int>? {
        if (node == null) return null
        if (node.`val` == child) return Pair(depth, -1)
        val leftResult = findDepthAndParent(node.left, child, depth + 1)
        if (leftResult != null) {
            return if (leftResult.second == -1) Pair(leftResult.first, node.`val`)
            else leftResult
        }
        val rightResult = findDepthAndParent(node.right, child, depth + 1)
        if (rightResult != null) {
            return if (rightResult.second == -1) Pair(rightResult.first, node.`val`)
            else rightResult
        }
        return null
    }
}