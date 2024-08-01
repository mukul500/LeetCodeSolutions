package tree

class IsValidBinaryTree {

    fun isValidBST(root: TreeNode?): Boolean {

        var leftBalance =true
        var rightBalance = true

        if(root == null){
            return true
        }

        if(root.left == null  || root.left!!.`val` < root.`val`){
            leftBalance =  isValidBST(root.left)
        }
        else{
            return false
        }
        if(root.right == null ||  root.right!!.`val` > root.`val`){
          rightBalance =  isValidBST(root.right)
        }else{
            return false
        }

        return leftBalance && rightBalance

    }
}