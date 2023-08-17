package graphs

class ZeroOneMatrix {

    fun updateMatrix(matrix: Array<IntArray>): Array<IntArray> {
        val newMatrix = Array(matrix.size) {
            IntArray(matrix[0].size) {
                Int.MAX_VALUE
            }
        }


        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                if (matrix[i][j] == 0) {
                    newMatrix[i][j] = 0
                } else {
                    val visitedNodes = mutableSetOf<Pair<Int, Int>>()
                    val queue = mutableListOf<Pair<Int, Int>>()
                    val distanceFromZero = breadthFirstSearchElements(matrix, i, j, visitedNodes, queue, newMatrix, 0)
                    queue.clear()
                    visitedNodes.clear()
                }
            }
        }

        return newMatrix
    }

    fun breadthFirstSearchElements(
        matrix: Array<IntArray>,
        row: Int,
        col: Int,
        visitedNodes: MutableSet<Pair<Int, Int>>,
        queue: MutableList<Pair<Int, Int>>,
        newMatrix: Array<IntArray>,
        distance: Int
    ) {
        if (row < 0 || row >= matrix.size || col < 0 || col >= matrix[0].size || visitedNodes.contains(
                Pair(
                    row,
                    col
                )
            )
        ) {
            return
        } else {
            if (matrix[row][col] == 0) {
                newMatrix[row][col] = distance
                return
            }
            visitedNodes.add(Pair(row, col))
            queue.add(Pair(row + 1, col))
            queue.add(Pair(row - 1, col))
            queue.add(Pair(row, col + 1))
            queue.add(Pair(row, col - 1))

            return breadthFirstSearchElements(
                matrix,
                queue[0].first,
                queue[0].second,
                visitedNodes,
                queue,
                newMatrix,
                distance + 1
            )
        }
    }

}