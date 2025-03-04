package tree

class `Binary Tree Right Side View` {

    fun rightSideView(root: TreeNode?): List<Int> {

        val levelMap = mutableMapOf<Int, Int>()
        val result = mutableListOf<Int>()
        fun traverseDepthFirstSearch(node: TreeNode?, level: Int) {
            if (node == null) return
            if (!levelMap.containsKey(level)) {
                levelMap.put(level, node.`val`)
            }
            traverseDepthFirstSearch(node.right, level + 1)
            traverseDepthFirstSearch(node.left, level + 1)
        }
        traverseDepthFirstSearch(root, 0)
        levelMap.forEach {
            result.add(it.value)
        }
        return result
    }
}


class BinaryTreeRightSide {

    fun rightSideView(root: TreeNode?): List<Int> {
        val map: MutableMap<Int, Int> = mutableMapOf()

        fun traverseTree(node: TreeNode?, level: Int) {
            if (node == null) return
            if (!map.containsKey(level)) {
                map[level] = node.`val`
            }
            traverseTree(node.right, level + 1)
            traverseTree(node.left, level + 1)
        }
        traverseTree(root, 0)
        return map.values.toList()
    }


}