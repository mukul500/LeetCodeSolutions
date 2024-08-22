package binarysearch

class `Find Peak Element` {

    private var currentHighestIndex = 0
    fun findPeakElement(nums: IntArray): Int {

        var leftPointer = 0
        var rightPointer = nums.size - 1

        while (leftPointer <= rightPointer) {
            val middlePointer = leftPointer + (rightPointer - leftPointer) / 2
            println(nums[middlePointer])
            when (whichIsHighest(nums, middlePointer)) {
                HighestElement.RIGHT_NEIGHBOUR -> {
                    leftPointer = middlePointer + 1
                }

                HighestElement.LEFT_NEIGHBOUR -> {
                    rightPointer = middlePointer - 1
                }

                HighestElement.CURRENT -> {
                    currentHighestIndex = middlePointer
                    return currentHighestIndex
                }
            }
        }
        return currentHighestIndex
    }


    private fun whichIsHighest(nums: IntArray, index: Int): HighestElement {

        val currentElement = nums[index]
        val leftNeighbour = nums.getOrElse(index - 1) { Int.MIN_VALUE }
        val rightNeighbour = nums.getOrElse(index + 1) { Int.MIN_VALUE }
        return if (currentElement > leftNeighbour && currentElement > rightNeighbour) HighestElement.CURRENT
        else if (leftNeighbour > currentElement) HighestElement.LEFT_NEIGHBOUR
        else HighestElement.RIGHT_NEIGHBOUR
    }


    enum class HighestElement {
        LEFT_NEIGHBOUR, RIGHT_NEIGHBOUR, CURRENT
    }

}