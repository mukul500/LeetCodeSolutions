package dp

import kotlin.math.min

class MinimumFallingPathSum {
    fun minFallingPathSum(matrix: Array<IntArray>): Int {
        val memo = Array(matrix.size) { IntArray(matrix.size) { Int.MAX_VALUE } }
        var currentMinimum: Int = Int.MAX_VALUE

        fun isValidIndex(row: Int, col: Int): Boolean {
            return (row < matrix.size && row >= 0 && col < matrix.size && col >= 0)
        }

        //Assuming First call to  row 0 , col :0
        fun dfs(row: Int, col: Int): Int {
            if (!isValidIndex(row = row, col = col)) return Int.MAX_VALUE
            if (memo[row][col] != Int.MAX_VALUE) return memo[row][col]

            val result1 = dfs(row + 1, col + 1)
            val result3 = dfs(row + 1, col - 1)
            val result2 = dfs(row + 1, col)

            var currentMin = minOf(result3, result2)
            currentMin = minOf(currentMin, result1)

            if(currentMin == Int.MAX_VALUE){
                memo[row][col] = matrix[row][col]
            }else{
                memo[row][col] = matrix[row][col] + currentMin
            }
            return memo[row][col]
        }

        matrix.get(0).forEachIndexed { index, i ->
            val minimumPath = dfs(row = 0, col = index)
            currentMinimum = min(currentMinimum, minimumPath)
        }
        return currentMinimum
    }
}