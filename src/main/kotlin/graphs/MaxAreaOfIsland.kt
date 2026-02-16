package graphs

import utils.isValidIndex

class MaxAreaOfIsland {

    val directions = listOf<Pair<Int, Int>>(
        Pair(1, 0),
        Pair(0, 1),
        Pair(-1, 0),
        Pair(0, -1)
    )

    fun maxAreaOfIsland(grid: Array<IntArray>): Int {


        var maxArea = Int.MIN_VALUE

        for (row in grid.indices) {
            for (col in grid[row].indices) {
                if (grid[row][col] == 1) {
                    val currentMax = dfs(row, col, grid)
                    maxArea = maxOf(currentMax, maxArea)
                }
            }
        }
        return maxArea
    }

    fun dfs(row: Int, col: Int, grid: Array<IntArray>): Int {
        if (!grid.isIsland(row, col)) return 0
        var totalIsland = 1
        grid[row][col] = 0
        for ((dx, dy) in directions) {

            val newRow = row + dx
            val newCol = col + dy
            val result = dfs(newRow, newCol, grid)
            totalIsland += result
        }
        return totalIsland

    }

    private fun Array<IntArray>.isIsland(row: Int, col: Int): Boolean {
        return this.isValidIndex(row, col) && this[row][col] == 1
    }


}