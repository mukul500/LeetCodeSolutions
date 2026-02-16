package graphs

import java.util.*

class PacificAtlantic {

    val finalResult = mutableListOf<List<Int>>()
    val directions = listOf<Pair<Int, Int>>(
        Pair(1, 0), Pair(0, 1), Pair(-1, 0), Pair(0, -1)
    )
    lateinit var visited: Array<BooleanArray>


    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {

        for (row in heights.indices) {
            for (col in heights[row].indices) {
                visited = Array(heights.size) { BooleanArray(heights[0].size) }
                val isPacific = dfsPacific(heights, row, col)
                var isAtlantic = false
                if (isPacific) {
                    visited = Array(heights.size) { BooleanArray(heights[0].size) }
                    isAtlantic = dfsAtlantic(heights, row, col)
                }
                if (isPacific && isAtlantic) {
                    finalResult.add(listOf<Int>(row, col))
                }
            }
        }
        return finalResult
    }

    fun dfsPacific(grid: Array<IntArray>, row: Int, col: Int): Boolean {
        if (!grid.isValidIndex(row, col)) return false
        if (grid.isNearPacific(row, col)) return true
        val currentValue = grid[row][col]
        visited[row][col] = true
        for ((dx, dy) in directions) {
            val newRow = row + dx
            val newCol = col + dy
            if (grid.isValidIndex(newRow, newCol) && grid[newRow][newCol] <= currentValue && !visited[newRow][newCol]) {
                val result = dfsPacific(grid, newRow, newCol)
                if (result) return true
            }
        }
        return false
    }

    fun dfsAtlantic(grid: Array<IntArray>, row: Int, col: Int): Boolean {
        if (!grid.isValidIndex(row, col)) return false
        if (grid.isNearAtlantic(row, col)) return true
        val currentValue = grid[row][col]
        visited[row][col] = true
        for ((dx, dy) in directions) {
            val newRow = row + dx
            val newCol = col + dy
            if (grid.isValidIndex(newRow, newCol) && grid[newRow][newCol] <= currentValue && !visited[newRow][newCol]) {
                val result = dfsAtlantic(grid, newRow, newCol)
                if (result) return true
            }
        }
        return false
    }

    fun Array<IntArray>.isNearPacific(row: Int, col: Int): Boolean {
        return row == 0 || col == 0
    }

    fun Array<IntArray>.isNearAtlantic(row: Int, col: Int): Boolean {
        return (row == this.size - 1 || col == this[row].size - 1)
    }

    fun Array<IntArray>.isValidIndex(row: Int, col: Int): Boolean {
        return row >= 0 && row < this.size && col >= 0 && col < this[row].size
    }

}


class PacificAtlantic2 {

    val finalResult = mutableListOf<List<Int>>()
    val directions = listOf<Pair<Int, Int>>(
        Pair(1, 0), Pair(0, 1), Pair(-1, 0), Pair(0, -1)
    )
    lateinit var visitedPacific: Array<BooleanArray>
    lateinit var visitedAtlantic: Array<BooleanArray>


    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        visitedPacific = Array(heights.size) { BooleanArray(heights[0].size) }
        visitedAtlantic = Array(heights.size) { BooleanArray(heights[0].size) }
        checkForPacific(heights, visitedPacific)
        checkForAtlantic(heights, visitedAtlantic)

        for (row in heights.indices) {
            for (col in heights[0].indices) {
                if (visitedPacific[row][col] && visitedAtlantic[row][col]) {
                    finalResult.add(listOf(row, col))
                }
            }
        }
        return finalResult
    }

    private fun checkForPacific(grid: Array<IntArray>, visitedArray: Array<BooleanArray>) {
        val rows = grid.size
        val cols = grid[0].size

        val queue: Queue<Pair<Int, Int>> = LinkedList()
        for (i in 0 until rows) {
            queue.offer(Pair(i, 0))
        }
        // Top edge
        for (j in 0 until cols) {
            queue.offer(Pair(0, j))
        }
        multiSourceBFS(grid, queue, visitedArray)

    }

    private fun checkForAtlantic(grid: Array<IntArray>, visitedArray: Array<BooleanArray>) {
        val rows = grid.size
        val cols = grid[0].size

        //LeftEdge
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        for (i in 0 until rows) {
            queue.offer(Pair(i, cols - 1))
        }
        // Bottom
        for (j in 0 until cols) {
            queue.offer(Pair(rows - 1, j))
        }
        multiSourceBFS(grid, queue, visitedArray)
    }


    private fun multiSourceBFS(grid: Array<IntArray>, queue: Queue<Pair<Int, Int>>, visitedArray: Array<BooleanArray>) {

        while (queue.isNotEmpty()) {
            var queueSize = queue.size

            while (queueSize > 0 && queue.isNotEmpty()) {
                val (row, col) = queue.poll()
                if (visitedArray[row][col]) continue
                visitedArray[row][col] = true
                queueSize--
                val currentVal = grid[row][col]
                for ((dx, dy) in directions) {
                    val newRow = row + dx
                    val newCol = col + dy
                    if (grid.isValidIndex(newRow, newCol) && currentVal <= grid[newRow][newCol]) {
                        queue.offer(Pair(newRow, newCol))
                    }
                }
            }
        }

    }


    fun Array<IntArray>.isNearPacific(row: Int, col: Int): Boolean {
        return row == 0 || col == 0
    }

    fun Array<IntArray>.isNearAtlantic(row: Int, col: Int): Boolean {
        return (row == this.size - 1 || col == this[row].size - 1)
    }

    fun Array<IntArray>.isValidIndex(row: Int, col: Int): Boolean {
        return row >= 0 && row < this.size && col >= 0 && col < this[row].size
    }

}