import stack.MinStack
import tree.BinaryTreeLevelOrderTraversel
import tree.TreeNode

fun main(args: Array<String>) {


    val solution = BinaryTreeLevelOrderTraversel()
    val root = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(4)
        }
        right = TreeNode(3).apply {
            right = TreeNode(5)
        }
    }

    val result = solution.levelOrder(root)
    println(result)


}