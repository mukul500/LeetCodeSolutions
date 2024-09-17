package dp

class DeleteAndEarn {

    fun deleteAndEarn(nums: IntArray): Int {
        var maximum = 0
        val dp = mutableMapOf<Int, Int>()
        fun dfs(currentIndex: Int): Int {
            if (currentIndex >= nums.size) return 0
            if (dp.containsKey(currentIndex)) return dp[currentIndex]!!
            val currentNumber = nums[currentIndex]
            var currentMaximum = 0
            val skippedNumber1 = currentNumber - 1
            val skippedNumber2 = currentNumber + 1
            for (i in currentIndex + 1 until nums.size) {
                if (!(nums[i] == skippedNumber1 || nums[i] == skippedNumber2)) {
                    val result = dfs(i)
                    currentMaximum = maxOf(currentMaximum, result)
                }
            }
            dp[currentIndex] = currentMaximum + currentNumber
            return  dp[currentIndex]!!
        }
        nums.forEachIndexed { index, _ ->
            val max = dfs(index)
            maximum = maxOf(max, maximum)
        }
        return maximum
    }
}