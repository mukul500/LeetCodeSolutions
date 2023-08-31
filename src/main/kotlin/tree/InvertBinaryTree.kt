package tree


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class InvertBinaryTree {

    fun invertTree(root: TreeNode?): TreeNode? {

        //We check if the root is  or left is null we return the root
        if (root?.left == null && root?.right == null) {
            return root
        }

        //We swap the left and right nodes
        val tempNode = root.left
        root.left = root.right
        root.right = tempNode

        //We call the invertTree method on the left and right nodes to inevert the children
        invertTree(root.left)
        invertTree(root.right)
        //return the root
        return root
    }
}