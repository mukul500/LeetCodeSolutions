package binarysearch

class SearchA2DMatrixV2 {

    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {

        var topPointer = matrix[0].size - 1
        var rightPointer = 0

        while (topPointer >= 0 && rightPointer < matrix.size) {
            val currentNum = matrix[rightPointer][topPointer]
            if (currentNum == target) return true
            else if (target < currentNum) topPointer--
            else rightPointer++
        }
        return false
    }
}