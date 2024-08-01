package tree

import com.sun.source.tree.Tree

class LowestCommonAncesstor {



    //Solution 2
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {


        fun traverseTree(root: TreeNode?): TreeNode? {

            println("$root")
            if (p == null || q == null || root == null) {

                return null
            }


            //If both p and q are greater than root, then LCA lies in right
            if (root.`val` < q.`val` && root.`val` < p.`val`)
                return traverseTree(root.right)

            //If both p and q are smaller than root, then LCA lies in left
            else if (root.`val` > q.`val` && root.`val` > p.`val`)
                return traverseTree(root.left)
            //Else return root
            else
                return root
        }

        //We Call the function recursively
        return traverseTree(root)
    }


    //Solution 1
    fun lowestCommonAncestor2(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        //We Traverse the tree and get the list of nodes
        val pTraverseList = root.traverseTree(p)
        val qTraverseList = root.traverseTree(q)

        // We find the last common intersection element between the two lists
        val finalList = pTraverseList.intersect(qTraverseList)
        if (finalList.isNotEmpty()) {
            //We return the last element
            return finalList.last()
        }
        return null
    }


    // We traverse the tree and get the list of nodes
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