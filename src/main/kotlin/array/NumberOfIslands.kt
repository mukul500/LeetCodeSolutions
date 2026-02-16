package array

class NumberOfIslands {

    private val directions: List<Pair<Int, Int>> = listOf(
        Pair(1, 0), Pair(0, 1), Pair(-1, 0), Pair(0, -1)
    )

    private var numberOfIslands = 0
    fun numIslands(grid: Array<CharArray>): Int {
        for (row in grid.indices) {
            for (col in grid[row].indices) {
                if (grid[row][col] == '1') {
                    dfs(row, col, grid)
                    numberOfIslands++
                }
            }
        }
        return numberOfIslands
    }

    fun dfs(row: Int, col: Int, grid: Array<CharArray>) {
        if (!grid.isValidIndex(row, col)) return
        if (grid[row][col] != '1') return
        grid[row][col] = '0'
        for ((dx, dy) in directions) {
            val newRow = row + dx
            val newCol = col + dy
            dfs(newRow, newCol, grid)
        }
    }

    private fun Array<CharArray>.isValidIndex(row: Int, col: Int): Boolean {
        return row in indices && col in this[row].indices
    }
}