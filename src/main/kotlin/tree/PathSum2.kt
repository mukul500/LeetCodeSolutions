package tree

class PathSum2 {

    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        val sumList = mutableListOf<MutableList<Int>>()


        fun pathSum(currentNode: TreeNode?, remainingSum: Int, previousList: MutableList<Int>) {

            val copiedList = previousList.toMutableList()

            fun isLeafNode(currentNode: TreeNode): Boolean {
                return (currentNode.left == null && currentNode.right == null)
            }
            if (currentNode == null) return
            if (currentNode.`val` - remainingSum == 0 && isLeafNode(currentNode)) {
                copiedList.add(currentNode.`val`)
                sumList.add(copiedList)
                return
            }
            else  {
                copiedList.add(currentNode.`val`)
                pathSum(currentNode.left, remainingSum - currentNode.`val`, copiedList)
                pathSum(currentNode.right, remainingSum - currentNode.`val`, copiedList)
            }

        }

        pathSum(root, targetSum, mutableListOf<Int>())

        return sumList
    }


}