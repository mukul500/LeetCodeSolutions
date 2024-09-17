package dp

class CoinChange2 {
    fun change(amount: Int, coins: IntArray): Int {
        val memo = Array(coins.size) { IntArray(amount + 1) { -1 } }

        var totalNumberOfComb = 0
        if (amount == 0 && coins.isNotEmpty()) return 1

        fun dfs(currentIndex: Int, currentAmount: Int): Int {
            if (currentAmount == 0) return 1
            if (currentAmount < 0) return 0
            var totalNumberOfWaysForIndex = 0
            if (memo[currentIndex][currentAmount] != -1) {
                return memo[currentIndex][currentAmount]
            }

            else {
                for (i in currentIndex until coins.size) {

                    totalNumberOfWaysForIndex += dfs(currentIndex = i, currentAmount - coins[i])
                }
            }
            memo[currentIndex][currentAmount] = totalNumberOfWaysForIndex
            return totalNumberOfWaysForIndex
        }

        totalNumberOfComb = dfs(0, amount)
        return totalNumberOfComb
    }
}