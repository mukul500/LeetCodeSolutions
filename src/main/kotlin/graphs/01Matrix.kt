package graphs

import java.util.LinkedList
import java.util.Queue

class ZeroOneMatrix {


    fun updateMatrix(matrix: Array<IntArray>): Array<IntArray> {


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

}