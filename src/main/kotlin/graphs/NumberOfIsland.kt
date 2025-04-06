package graphs

class NumberOfIsland {


    fun numIslands(grid: Array<CharArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        var totalIsland = 0
        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (grid[r][c] == '1') {
                    totalIsland++
                    isIsland(grid, r, c)
                }
            }
        }
        return totalIsland
    }

    private fun isIsland(grid: Array<CharArray>, row: Int, col: Int) {
        if (!isValidIndex(grid, row, col)) return
        else if (grid[row][col] == '0') return
        else {
            grid[row][col] = '0'
            isIsland(grid, row, col - 1)
            isIsland(grid, row - 1, col)
            isIsland(grid, row, col + 1)
            isIsland(grid, row + 1, col)
        }

    }

    private fun isValidIndex(grid: Array<CharArray>, row: Int, col: Int): Boolean {
        return (row >= 0 && row < grid.size) && (col >= 0 && col < grid[0].size)
    }


}