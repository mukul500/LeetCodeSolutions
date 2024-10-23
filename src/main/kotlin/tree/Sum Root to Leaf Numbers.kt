package tree

class `Sum Root to Leaf Numbers` {

    fun sumNumbers(root: TreeNode?): Int {
        return sumNumbers(root, 0)
    }

    private fun sumNumbers(root: TreeNode?, number: Int): Int {
        if (root == null) return 0
        val nextNumber = getNumber(base = number, remainder = root.`val`)
        if (root.left == null && root.right == null) {
            return nextNumber
        }
        val left = sumNumbers(root = root.left, number = getNumber(base = number, remainder = root.`val`))
        val right = sumNumbers(root = root.right, number = getNumber(base = number, remainder = root.`val`))
        return right + left
    }

    private fun getNumber(base: Int, remainder: Int): Int {
        return (base * 10) + remainder
    }
}