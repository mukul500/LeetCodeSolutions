package dp

import kotlin.math.max

class HouseRobber {

    fun rob(nums: IntArray): Int {
        var maximum = -1
        val dp: MutableMap<Int, Int> = mutableMapOf()

        fun dfs(index: Int): Int {
            if (index >= nums.size) return 0
            val currentNumber = nums[index]
            var currentMaximum = 0
            var nextHouseIndex = index + 2
            if (dp.containsKey(index)) {
                return dp[index]!!
            }
            while (nextHouseIndex < nums.size) {
                val result = dfs(nextHouseIndex)
                currentMaximum = maxOf(currentMaximum, result)
                nextHouseIndex++
            }
            if (dp.getOrDefault(index, 0) <= currentMaximum + currentNumber) {
                dp[index] = currentMaximum + currentNumber
            }
            return dp[index]!!
        }

        nums.forEachIndexed { index, i ->
            val max = dfs(index)
            maximum = maxOf(max, maximum)
        }
        return maximum
    }

}