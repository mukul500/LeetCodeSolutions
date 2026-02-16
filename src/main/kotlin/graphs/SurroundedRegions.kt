package graphs

class SurroundedRegions {

    val directions = listOf<Pair<Int, Int>>(
        Pair(-1, 0),
        Pair(1, 0),
        Pair(0, 1),
        Pair(0, -1)
    )

    fun solve(board: Array<CharArray>): Unit {
        for (row in board.indices) {
            for (col in board[row].indices) {
                if (board.isBoundaryAndIsland(row, col)) {
                    println("DFS on boundary row: $row col: $col")
                    dfs(board, row, col)
                }
            }
        }

        for (row in board.indices) {
            for (col in board.indices) {
                if (board[row][col] == 'S') {
                    board[row][col] = 'O'
                } else {
                    board[row][col] = 'X'
                }
            }
        }
    }

    fun dfs(board: Array<CharArray>, row: Int, col: Int) {
        if (!board.isValidIndex(row, col)) return
        if (board[row][col] != 'O') return
        board[row][col] = 'S'
        for ((dx, dy) in directions) {
            val newRow = row + dx
            val newCol = col + dy
            dfs(board, newRow, newCol)
        }
    }


    fun Array<CharArray>.isBoundaryAndIsland(row: Int, col: Int): Boolean {
        return isBoundaryCell(row, col) && this[row][col] == 'O'
    }

    private fun Array<CharArray>.isBoundaryCell(row: Int, col: Int): Boolean {
        return isValidIndex(row, col) && (row == 0 || col == 0 || row == this.size - 1 || col == this[row].size - 1)
    }

    fun Array<CharArray>.isValidIndex(row: Int, col: Int): Boolean {
        return row >= 0 && row < this.size && col >= 0 && col < this[row].size
    }
}