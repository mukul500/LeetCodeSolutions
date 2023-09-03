package tree

import com.sun.source.tree.Tree

class LowestCommonAncesstor {


    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {


        fun traverseTree(root: TreeNode?): TreeNode? {

            println("$root")
            if (p == null || q == null || root == null) {

                return null
            }


            if (root.`val` < q.`val` && root.`val` < p.`val`)
                return traverseTree(root.right)
            else if (root.`val` > q.`val` && root.`val` > p.`val`)
                return traverseTree(root.left)
            else
                return root
        }

        return traverseTree(root)
    }


    //Solution 1
    fun lowestCommonAncestor2(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        val pTraverseList = root.traverseTree(p)
        val qTraverseList = root.traverseTree(q)
        val finalList = pTraverseList.intersect(qTraverseList)
        if (finalList.isNotEmpty()) {
            return finalList.last()
        }
        return null
    }


    fun TreeNode?.traverseTree(itemNode: TreeNode?): Set<TreeNode?> {
        val traverseList = mutableListOf<TreeNode?>()
        var currentNode = this

        if (itemNode == null) {
            return traverseList.toSet()
        }

        while (currentNode != null) {
            traverseList.add(currentNode)
            currentNode = if (currentNode.`val` == itemNode.`val`) {
                return traverseList.toSet()
            } else if (currentNode.`val` < itemNode.`val`) {
                currentNode.right
            } else {
                currentNode.left
            }
        }
        return traverseList.toSet()
    }
}