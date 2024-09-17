package array

class `Diagonal Traverse` {
    fun findDiagonalOrder(mat: Array<IntArray>): IntArray {

        val traversedArray = mutableListOf<Int>()

        fun traverseArray(row: Int, col: Int, isUp: Boolean) {
            if (traversedArray.size == mat.size * mat[0].size) return
            if (isUp) {
                if (col == mat[0].size - 1) {
                    traversedArray.add(mat[row][col])
                    traverseArray(row = row + 1, col = col, isUp = false)
                } else if (row == 0) {
                    traversedArray.add(mat[row][col])
                    traverseArray(row = row, col = col + 1, isUp = false)
                } else {
                    traversedArray.add(mat[row][col])
                    traverseArray(row = row - 1, col = col + 1, isUp = true)
                }
            } else {
                if (row == mat.size - 1) {
                    traversedArray.add(mat[row][col])
                    traverseArray(row = row, col = col + 1, isUp = true)
                } else if (col == 0) {
                    traversedArray.add(mat[row][col])
                    traverseArray(row = row + 1, col = col, isUp = true)
                } else {
                    traversedArray.add(mat[row][col])
                    traverseArray(row = row + 1, col = col - 1, isUp = false)
                }
            }

        }

        traverseArray(0, 0, true)
        return traversedArray.toIntArray()
    }
}