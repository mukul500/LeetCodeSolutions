package binarysearch

import kotlin.math.min

class `Find Minimum in Rotated Sorted Array` {

    private var minimum = Int.MAX_VALUE
    fun findMin(nums: IntArray): Int {

        var leftPointer = 0
        var rightPointer = nums.size - 1

        while (leftPointer <= rightPointer) {
            val middlePointer = leftPointer + (rightPointer - leftPointer) / 2
            println(middlePointer)
            if (nums[middlePointer] < minimum) minimum = nums[middlePointer]


            //left side is sorted
            if (nums[leftPointer] <= nums[middlePointer]) {
                if (nums[leftPointer] < minimum) {
                    minimum = nums[leftPointer]
                }
                leftPointer = middlePointer + 1
            } else {
                rightPointer = middlePointer - 1
            }
        }
        return minimum
    }
}