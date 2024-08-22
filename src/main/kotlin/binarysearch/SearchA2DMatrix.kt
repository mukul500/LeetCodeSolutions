package binarysearch

class SearchA2DMatrix {

    private var horizontalLength: Int = 0
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        horizontalLength =  matrix[0].size ?: 0
        var leftPointer = 0
        var rightPointer = getTotalLengthOfTheList(matrix) - 1

        while (leftPointer <= rightPointer) {
            val middlePointer = leftPointer + (rightPointer - leftPointer) / 2
            val middlePointerCoordinate = get2dArrayCoordinatesFromPosition(middlePointer)
            println(middlePointerCoordinate)
            val middleNumber = matrix[middlePointerCoordinate.first][middlePointerCoordinate.second]
            if (target == middleNumber) return true
            if (target <= middleNumber) {
                rightPointer = middlePointer - 1
            } else {
                leftPointer = middlePointer + 1
            }
        }
        return false
    }

    private fun getTotalLengthOfTheList(matrix: Array<IntArray>): Int {
        val verticalLength = matrix.size ?: 0
        return horizontalLength * verticalLength
    }

    private fun get2dArrayCoordinatesFromPosition(position: Int): Pair<Int, Int> {
        val a = position / horizontalLength
        val b = position % horizontalLength
        return Pair(a, b)
    }

}
