package tree

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class StepByStepDirections {

    private var commonNode : TreeNode? = null
    private var leftPath  = StringBuilder()
    private var rightPath = StringBuilder()
    fun getDirections(root: TreeNode?, startValue: Int, destValue: Int): String {
        findCommonNode(root, startValue, destValue)
        dfs(commonNode, startValue, true)
        dfs(commonNode, destValue, false)
        return leftPath.toString() + rightPath.reverse().toString()
    }


    private fun dfs(rootNode: TreeNode?, target: Int, isStartValue: Boolean) : Boolean{
        if(rootNode == null) return false
        if(rootNode.`val` == target) return true
        val leftSide  = dfs(rootNode?.left, target, isStartValue)
        if(leftSide){
            if(isStartValue){
                leftPath.append("U")
            }else{
                rightPath.append("L")
            }

        }
        val rightSide = dfs(rootNode?.right, target, isStartValue)
        if(rightSide){
            if(isStartValue){
                leftPath.append("U")
            }else{
                rightPath.append("R")
            }
        }
        return leftSide || rightSide
    }


    fun findCommonNode(currentNode :TreeNode?, startValue: Int, destValue: Int): Boolean{
        if(currentNode == null) return false

        val leftSideResult = findCommonNode(currentNode.left, startValue, destValue)
        val rightSideResult = findCommonNode(currentNode.right, startValue, destValue)

        var mid =  (currentNode.`val` == startValue) || (currentNode.`val` == destValue)
        if((leftSideResult && rightSideResult) || (mid && leftSideResult) || (mid  && rightSideResult)){
            commonNode = currentNode
        }
        return  mid || leftSideResult || rightSideResult
    }
}