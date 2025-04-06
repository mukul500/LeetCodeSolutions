package array

class `Arrange Coins` {

    private var stairCount = 0
    fun arrangeCoins(n: Int): Int {
        findStair(n, 1)
        return stairCount
    }

    private fun findStair(n: Int, stair: Int) {
        if (n <= 0) return
        val remainingCoins = n - stair
        if (remainingCoins >= 0) {
            stairCount++
        }
        findStair(remainingCoins, stair + 1)
    }
}