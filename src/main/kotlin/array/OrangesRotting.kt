package array

import java.util.LinkedList
import java.util.Queue


/**
 * This is a DFS Based Solution.
 * That's why all the scenario are handled with the full Scan.
 */
class OrangesRotting {
    fun orangesRotting(grid: Array<IntArray>): Int {

        val isThereAnyFreshOrange = isAnyFreshOrange(grid, 0, 0)
        val isThereAnyRottenOrange = isAnyRottenOrange(grid, 0, 0)
        if (isThereAnyFreshOrange && !isThereAnyRottenOrange) return -1
        if (!isThereAnyFreshOrange && isThereAnyRottenOrange) return 0

        val isLonelyOrange = checkIsThereAnyLonelyOrange(grid, 0, 0)
        if (isLonelyOrange) return -1

        val nextRottenIndexList = mutableListOf<Pair<Int, Int>>()


        fun findNextRotting(grid: Array<IntArray>, row: Int, col: Int) {
            if (row >= grid.size) return
            if (col >= grid[0].size) return findNextRotting(grid, row + 1, 0)
            if (grid[row][col] == 1) {
                if (checkAdjacentRotten(grid, row, col)) {
                    nextRottenIndexList.add(Pair(row, col))
                }
            }

            return findNextRotting(grid, row, col + 1)
        }
        findNextRotting(grid, 0, 0)
        var counter = 0
        while (nextRottenIndexList.isNotEmpty()) {
            counter++
            nextRottenIndexList.forEach {
                grid[it.first][it.second] = 2
            }
            nextRottenIndexList.clear()
            findNextRotting(grid, 0, 0)
        }
        val isAnyFreshOrange = isAnyFreshOrange(grid, 0, 0)
        return if (!isAnyFreshOrange) {

            counter
        } else {
            -1
        }

    }


    private fun isAnyRottenOrange(grid: Array<IntArray>, row: Int, col: Int): Boolean {
        if (row >= grid.size) return false
        if (col >= grid[0].size) return isAnyRottenOrange(grid, row + 1, 0)
        if (grid[row][col] == 2) {
            return true
        }
        return isAnyRottenOrange(grid, row, col + 1)
    }

    private fun isAnyFreshOrange(grid: Array<IntArray>, row: Int, col: Int): Boolean {
        if (row >= grid.size) return false
        if (col >= grid[0].size) return isAnyFreshOrange(grid, row + 1, 0)
        if (grid[row][col] == 1) {
            return true
        }
        return isAnyFreshOrange(grid, row, col + 1)
    }


    private fun checkIsThereAnyLonelyOrange(grid: Array<IntArray>, row: Int, col: Int): Boolean {
        if (row >= grid.size) return false
        if (col >= grid[0].size) return checkIsThereAnyLonelyOrange(grid, row + 1, 0)
        if (checkAdjacentZeroes(grid, row, col) && grid[row][col] == 1) {
            return true
        }
        return checkIsThereAnyLonelyOrange(grid, row, col + 1)
    }


    private fun checkAdjacentRotten(grid: Array<IntArray>, row: Int, col: Int): Boolean {
        val top = isGridRotten(grid, row - 1, col)
        val right = isGridRotten(grid, row, col + 1)
        val left = isGridRotten(grid, row, col - 1)
        val bottom = isGridRotten(grid, row + 1, col)
        return top || right || left || bottom
    }

    private fun checkAdjacentZeroes(grid: Array<IntArray>, row: Int, col: Int): Boolean {
        val top = isGridEmpty(grid, row - 1, col)
        val right = isGridEmpty(grid, row, col + 1)
        val left = isGridEmpty(grid, row, col - 1)
        val bottom = isGridEmpty(grid, row + 1, col)
        return top && right && left && bottom
    }

    private fun isGridEmpty(grid: Array<IntArray>, row: Int, col: Int): Boolean {
        if (!isValidIndex(grid, row, col)) return true
        return (grid[row][col] == 0)
    }

    private fun isGridRotten(grid: Array<IntArray>, row: Int, col: Int): Boolean {
        if (!isValidIndex(grid, row, col)) return false
        return (grid[row][col] == 2)
    }

    private fun isValidIndex(grid: Array<IntArray>, row: Int, col: Int): Boolean {
        return row in grid.indices && col in grid[0].indices

    }
}

/**
 * Apply the MultiSource BFS
 */

class OrangesRottingBFS {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val rottenQueue = LinkedList<Pair<Int, Int>>()
        fun addRottenToQueue(grid: Array<IntArray>, row: Int, col: Int) {
            if (row >= grid.size) return
            if (col >= grid[0].size) return addRottenToQueue(grid, row + 1, 0)
            if (grid[row][col] == 2) {
                rottenQueue.add(Pair(row, col))
            }
            addRottenToQueue(grid, row, col + 1)
        }
        addRottenToQueue(grid, 0, 0)
        val isAnyFreshOrange = isAnyFreshOrange(grid, 0, 0)
        if (rottenQueue.isEmpty() && isAnyFreshOrange) return -1
        if (rottenQueue.isEmpty()) return 0
        var day = 0
        while (rottenQueue.isNotEmpty()) {
            var rottenQueueIterationSize = rottenQueue.size
            var isOtherItemAffected = false

            while (rottenQueueIterationSize > 0) {
                val currentIndex = rottenQueue.poll()
                val isAffected =
                    addOtherDirectionsToRottenQueue(rottenQueue, grid, currentIndex.first, currentIndex.second)
                if (isAffected) isOtherItemAffected = true

                rottenQueueIterationSize--
            }
            if (isOtherItemAffected) day++
        }
        if (isAnyFreshOrange(grid, 0, 0)) return -1
        return day


    }


    private fun isAnyFreshOrange(grid: Array<IntArray>, row: Int, col: Int): Boolean {
        if (row >= grid.size) return false
        if (col >= grid[0].size) return isAnyFreshOrange(grid, row + 1, 0)
        if (grid[row][col] == 1) {
            return true
        }
        return isAnyFreshOrange(grid, row, col + 1)
    }

    private fun addOtherDirectionsToRottenQueue(
        queue: LinkedList<Pair<Int, Int>>, grid: Array<IntArray>, row: Int, col: Int
    ): Boolean {
        var isSideItemsAffected = false
        if (shouldAddToQueue(grid, row + 1, col)) {
            queue.add(Pair(row + 1, col))
            grid[row + 1][col] = 2
            isSideItemsAffected = true
        }
        if (shouldAddToQueue(grid, row - 1, col)) {
            queue.add(Pair(row - 1, col))
            grid[row - 1][col] = 2
            isSideItemsAffected = true
        }
        if (shouldAddToQueue(grid, row, col + 1)) {
            queue.add(Pair(row, col + 1))
            grid[row][col + 1] = 2
            isSideItemsAffected = true
            println()
        }
        if (shouldAddToQueue(grid, row, col - 1)) {
            queue.add(Pair(row, col - 1))
            grid[row][col - 1] = 2
            isSideItemsAffected = true
        }
        return isSideItemsAffected

    }

    private fun shouldAddToQueue(grid: Array<IntArray>, row: Int, col: Int): Boolean {
        return isValidIndex(grid, row, col) && grid[row][col] == 1
    }

    private fun isValidIndex(grid: Array<IntArray>, row: Int, col: Int): Boolean {
        return row in grid.indices && col in grid[0].indices

    }


}