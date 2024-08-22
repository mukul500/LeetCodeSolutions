package binarysearch

class `Find First and Last Position of Element in Sorted Array` {

    var lowest: Int = Int.MAX_VALUE
    var highest: Int = -1
    fun searchRange(nums: IntArray, target: Int): IntArray {
        binarySearch(nums, target, 0, nums.size - 1)
        if (lowest == Int.MAX_VALUE) lowest = -1
        return arrayOf(lowest, highest).toIntArray()
    }

    private fun binarySearch(nums: IntArray, target: Int, leftPointer: Int, rightPointer: Int) {
        if (leftPointer > rightPointer) return
        val midPointer = leftPointer + (rightPointer - leftPointer) / 2
        if (nums[midPointer] == target) {
            if (lowest > midPointer) {
                lowest = midPointer
                binarySearch(nums = nums, target = target, leftPointer = leftPointer, rightPointer = midPointer - 1)
            }
            if (highest < midPointer) {
                highest = midPointer
                binarySearch(nums = nums, target = target, leftPointer = midPointer + 1, rightPointer = rightPointer)
            }

        }
        if (nums[midPointer] >= target) {
            binarySearch(nums = nums, target = target, leftPointer = leftPointer, rightPointer = midPointer - 1)
        }
        if (nums[midPointer] <= target) {
            binarySearch(nums = nums, target = target, leftPointer = midPointer + 1, rightPointer = rightPointer)
        }
    }

}