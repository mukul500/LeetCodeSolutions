package array

class `Game of Life` {


    fun gameOfLife(board: Array<IntArray>): Unit {
        val board2 = Array(board.size) { IntArray(board[0].size) }

        for (i in board.indices) {
            for (j in board[i].indices) {
                board2[i][j] = board[i][j]
            }
        }


        fun isValidIndex(row: Int, col: Int): Boolean {
            return (row >= 0 && row < board.size) && (col >= 0 && col < board[0].size)
        }

        fun Array<IntArray>.checkNeighbour(row: Int, col: Int): Int {
            if (!isValidIndex(row, col)) return 0
            return this[row][col]
        }

        fun traverseNeighbourCells(row: Int, col: Int): Int {
            var total = 0
            //GoLeft
            total += board.checkNeighbour(row = row, col = col - 1)

            //Go Right
            total += board.checkNeighbour(row = row, col = col + 1)
            //Go Top
            total += board.checkNeighbour(row = row + 1, col = col)

            // Go Bottom
            total += board.checkNeighbour(row = row - 1, col = col)
            //Go Top-Left
            total += board.checkNeighbour(row = row - 1, col = col - 1)
            //GO TOP-RIGHT
            total += board.checkNeighbour(row = row - 1, col = col + 1)
            //GO Bottom LEFT
            total += board.checkNeighbour(row = row + 1, col = col - 1)
            //GO Bottom Right
            total += board.checkNeighbour(row = row + 1, col = col + 1)
            return total
        }




        for (i in board.indices) {
            for (j in board[0].indices) {
                val result = traverseNeighbourCells(i, j)


                    if (result < 2) {
                        board2[i][j] = 0
                    } else if (result == 3 && board[i][j] == 0) {
                        board2[i][j] = 1
                    } else if (result in 2..3 && board[i][j] == 1) {
                        board2[i][j] = 1
                    } else if (result > 3 && board[i][j] == 1) {
                        board2[i][j] = 0
                    }


            }
        }

        for (i in board2.indices) {
            for (j in board2[i].indices) {
                board[i][j] = board2[i][j]
            }
        }
    }
}