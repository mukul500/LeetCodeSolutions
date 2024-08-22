package dp

import java.util.LinkedList
import java.util.Queue
import kotlin.math.min


//Depth First Search solution. But getting timed out. in combinations
class CoinChange {

    //This is a DFS Solution
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp: MutableMap<Int, Int> = mutableMapOf()

        fun dfs(currentAmount: Int): Int {
            var currentMinimum = dp.getOrDefault(currentAmount, Int.MAX_VALUE)
            if (currentAmount < 0) return -1
            if (currentAmount == 0) {
                return 0
            }
            if (dp.containsKey(currentAmount)) return dp[currentAmount]!!

            coins.forEach {
                val result = dfs(currentAmount - it)
                if (result != -1) {
                    currentMinimum = minOf(currentMinimum, result + 1)
                }
            }
            if (currentMinimum != Int.MAX_VALUE) {
                dp[currentAmount] = currentMinimum
            } else {
                dp[currentAmount] = -1
            }

            return dp[currentAmount]!!

        }

        return dfs(amount)
    }


}

//Depth First Search solution. But getting timed out. in combinations
class CoinChangeBFS {


    fun coinChange(coins: IntArray, amount: Int): Int {
        var minimumCoins = Int.MAX_VALUE
        val dp: MutableMap<Int, Int> = mutableMapOf<Int, Int>()
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.add(Pair(amount, 0))
        while (queue.isNotEmpty()) {

            val (currentAmount, depth) = queue.poll()
            if (depth > minimumCoins) continue
            if (currentAmount < 0) continue
            if (currentAmount == 0) {
                if (depth < minimumCoins) {
                    minimumCoins = depth
                }
            }
            if (dp.getOrDefault(amount - currentAmount, Int.MAX_VALUE) < depth) continue
            dp[amount - currentAmount] = depth
            coins.forEach {
                queue.add(Pair(currentAmount - it, depth + 1))
            }
        }


        if (minimumCoins == Int.MAX_VALUE) return -1
        return minimumCoins
    }

}
