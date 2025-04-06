package graphs

import java.util.HashSet
import java.util.LinkedList
import java.util.Queue
import kotlin.concurrent.fixedRateTimer

class ZeroOneMatrix {


    val visiting = mutableSetOf<Pair<Int, Int>>() // Tracks cells currently being visited
    val visited = mutableSetOf<Pair<Int, Int>>()

    fun updateMatrixOld(matrix: Array<IntArray>): Array<IntArray> {


        //We Create Neighbour Cell Directions Right, Left, Up and Down
        val directions = arrayOf(Pair(0, 1), Pair(0, -1), Pair(1, 0), Pair(-1, 0))


        // We Create a Queue to store the cells with 0, So that we can perform BFS on them and update the distance of the neighbours
        val bfsQueue: Queue<Pair<Int, Int>> = LinkedList()

        //We Traverse the matrix and add the cells with 0 to the queue and update the other cells to Int.MAX_VALUE
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                if (matrix[i][j] == 0) {
                    bfsQueue.add(Pair(i, j))
                } else {
                    matrix[i][j] = Int.MAX_VALUE
                }
            }
        }


        //We perform BFS on the cells with 0 and update the distance of the neighbours
        while (bfsQueue.isNotEmpty()) {
            //We get the current cell
            val currentCell = bfsQueue.poll()
            val currentRow = currentCell.first
            val currentColumn = currentCell.second

            //We traverse the neighbours of the current cell
            for (direction in directions) {
                //We calculate the neighbour cell
                val neighbourRow = currentRow + direction.first
                val neighbourColumn = currentColumn + direction.second


                //We Calculate if the neighbour cell is valid or not
                val isValidCell =
                    neighbourRow >= 0 && neighbourRow < matrix.size && neighbourColumn >= 0 && neighbourColumn < matrix[0].size

                //If the cell is valid and the distance of the neighbour cell is greater than the distance of the current cell + 1
                if (isValidCell && matrix[currentRow][currentColumn] + 1 < matrix[neighbourRow][neighbourColumn]) {
                    //We update the distance of the neighbour cell and add it to the queue
                    matrix[neighbourRow][neighbourColumn] = matrix[currentRow][currentColumn] + 1
                    //We add the neighbour cell to the queue
                    bfsQueue.add(Pair(neighbourRow, neighbourColumn))
                }
            }
        }
        //We return the matrix
        return matrix
    }

    fun updateMatrix(matrix: Array<IntArray>): Array<IntArray> {

        fun findTheNearestZero(row: Int, col: Int): Int {
            if (!isValidCell(matrix, row, col)) return Int.MAX_VALUE
            if (matrix[row][col] == 0) return 0// Already computed
//            if (visited.contains(row to col)) return matrix[row][col]

            visiting.add(row to col) // Mark cell as visiting

            var minNeighbor = Int.MAX_VALUE

            // Recursive DFS calls only if not visiting
            if (!visiting.contains(row to (col - 1))) {
                minNeighbor = minOf(minNeighbor, findTheNearestZero(row, col - 1))
            }
            if (!visiting.contains(row to (col + 1))) {
                minNeighbor = minOf(minNeighbor, findTheNearestZero(row, col + 1))
            }
            if (!visiting.contains((row - 1) to col)) {
                minNeighbor = minOf(minNeighbor, findTheNearestZero(row - 1, col))
            }
            if (!visiting.contains((row + 1) to col)) {
                minNeighbor = minOf(minNeighbor, findTheNearestZero(row + 1, col))
            }

            matrix[row][col] = if (minNeighbor == Int.MAX_VALUE) Int.MAX_VALUE else minNeighbor + 1

            visiting.remove(row to col) // Unmark as visiting
            visited.add(row to col) // Mark as completely visited

            return matrix[row][col]
        }
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                if (matrix[i][j] != 0) {
                    matrix[i][j] = Int.MAX_VALUE
                }
            }
        }

        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                if (matrix[i][j] != 0) {
                    findTheNearestZero(i, j)
                }
            }
        }

        return matrix
    }


    private fun isValidCell(matrix: Array<IntArray>, row: Int, col: Int): Boolean {
        return row >= 0 && row < matrix.size && col >= 0 && col < matrix[0].size
    }


    fun updateMatrixMultiSourceBFS(matrix: Array<IntArray>): Array<IntArray> {

        val bfsQueue: Queue<Pair<Int, Int>> = LinkedList()

        val directions = arrayOf(Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1))
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                if (matrix[i][j] == 0) {
                    bfsQueue.add(Pair(i, j))
                } else {
                    matrix[i][j] = Int.MAX_VALUE
                }
            }
        }


        var distance = 0
        while (bfsQueue.isNotEmpty()) {
            var bfsSize = bfsQueue.size
            while (bfsSize > 0) {
                val (row, col) = bfsQueue.poll()

                for ((dx, dy) in directions) {
                    val newRow = row + dx
                    val newCol = col + dy
                    if (isValidCell(matrix, newRow, newCol) && matrix[newRow][newCol] == Int.MAX_VALUE) {
                        matrix[newRow][newCol] = distance + 1
                        bfsQueue.offer(newRow to newCol)
                    }
                }
                bfsSize--
            }
            distance++
        }

        return matrix
    }

}