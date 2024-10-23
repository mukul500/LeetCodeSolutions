package tree

class SymmetricTree {
    fun isSymmetric(root: TreeNode?): Boolean {
        fun isSymmetric(leftRoot: TreeNode?, rightRoot: TreeNode?): Boolean {
            if(leftRoot == null && rightRoot == null) return true
            println("leftRoot: ${leftRoot?.`val`} rightRoot: ${rightRoot?.`val`}")
            return if (leftRoot?.`val` == rightRoot?.`val`) {
                isSymmetric(leftRoot?.left, rightRoot?.right) && isSymmetric(leftRoot?.right, rightRoot?.left)
            } else {
                false
            }
        }
        return root == null || isSymmetric(root.left, root.right)
    }
}