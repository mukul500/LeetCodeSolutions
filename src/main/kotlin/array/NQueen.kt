package array


typealias ChessBoard = Array<IntArray>
typealias BoardPlacements = List<Pair<Int, Int>>

//00 represents the EmptySpace
//Int.MaxValue : is the queen placed at that position
//1-9:  No. of queen is attacking that board
//
class NQueen {
    private val directions = arrayOf(
        Pair(0, 1),   // right
        Pair(0, -1),  // left
        Pair(1, 0),   // down
        Pair(-1, 0),  // up
        Pair(1, 1),   // down-right
        Pair(1, -1),  // down-left
        Pair(-1, 1),  // up-right
        Pair(-1, -1)  // up-left
    )
    private val finalBoards: MutableList<ChessBoard> = mutableListOf()
    fun solveNQueens(n: Int): List<List<String>> {


        val emptyBoard = Array(n) {
            IntArray(n) { 0 }
        }

        for (row in emptyBoard.indices) {
            for (col in emptyBoard[row].indices) {
                val placedBoard = placeQueenAndMarkBoard(emptyBoard, row, col)
                dfs(placedBoard!!, 1, n)
            }
        }
        val finalResult = mutableListOf<List<String>>()
        for (finalBoard in finalBoards) {
            finalResult.add(finalBoard.convertBoardToString())
        }
        return finalResult
    }


    private fun dfs(board: ChessBoard, queenPlaced: Int, boardSize: Int) {
        if (queenPlaced == boardSize) {
            finalBoards.add(board)
            return
        }
        val possiblePlacement = findNextQueenPlacementsOptions(board)
        val row = queenPlaced // place queen in the current row
        for (col in board[row].indices) {
            val newBoard = placeQueenAndMarkBoard(board, row, col)
            if (newBoard != null) {
                dfs(newBoard, queenPlaced + 1, boardSize)
            }
        }
    }


    private fun findNextQueenPlacementsOptions(board: ChessBoard): BoardPlacements {
        val nextPossiblePlacements = mutableListOf<Pair<Int, Int>>()
        for (row in board.indices) {
            for (col in board[row].indices) {
                if (board[row][col] == 0) {
                    nextPossiblePlacements.add(Pair(row, col))
                }
            }
        }
        return nextPossiblePlacements
    }

    private fun placeQueenAndMarkBoard(board: ChessBoard, row: Int, col: Int): ChessBoard? {
        val newBoard = board.deepCopy()
        if (newBoard[row][col] != 0) {
            return null
        } else {
            newBoard[row][col] = Int.MAX_VALUE
        }
        for (direction in directions) {
            val (dx, dy) = direction
            var newRow = row + dx
            var newCol = col + dy

            while (newBoard.isValidIndex(newRow, newCol)) {
                if (newBoard[newRow][newCol] != Int.MAX_VALUE) {
                    newBoard[newRow][newCol] = 1
                } else {
                    return null
                }
                newRow += dx
                newCol += dy
            }
        }
        return newBoard
    }

    private fun ChessBoard.isValidIndex(row: Int, col: Int): Boolean {
        return row >= 0 && row < this.size && col >= 0 && col < this[row].size
    }


    private fun ChessBoard.convertBoardToString(): List<String> {
        val list = mutableListOf<String>()
        for (row in this.indices) {
            val sb = StringBuilder()
            for (col in this[row].indices) {
                if (this[row][col] == Int.MAX_VALUE) sb.append("Q")
                else sb.append(".")
            }
            list.add(sb.toString())
        }
        return list
    }

    private fun ChessBoard.deepCopy(): Array<IntArray> = Array(size) {
        this[it].copyOf()
    }
}

