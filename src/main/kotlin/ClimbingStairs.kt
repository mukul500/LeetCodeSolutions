class ClimbingStairs {
    fun climbStairs(n: Int): Int {

        if (n <= 2)
            return n

        val nFact = factorial(n)
        val rFact = factorial(2)
        val nMinusRFact = factorial(n - 2)

        val combination = nFact / (rFact) * nMinusRFact
        return combination

    }

    private fun factorial(value: Int): Int {
        return if (value <= 1)
            1
        else {
            value * factorial(value - 1)
        }
    }
}

