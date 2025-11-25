package binarysearch

class MedianOfTwoSortedArray {

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {

        var leftPointer = 0
        var rightPointer = nums2.size - 1

        val medianIndex = (nums1.size + nums2.size) / 2
        var middlePointer = (leftPointer + rightPointer) / 2


        var endPointer = (medianIndex - middlePointer) - 1
        println("MiddleIndex: ${medianIndex}")

        while (leftPointer <= rightPointer) {
            val middleVal = nums2[middlePointer]
            val endVal = nums1[endPointer]
            if (endVal < nums2[middlePointer + 1] && middleVal > nums1[endPointer + 1]) {
                rightPointer = middlePointer -1
            } else {
               break
            }
            middlePointer = (leftPointer + rightPointer) / 2
            endPointer = (medianIndex - middlePointer) - 1
        }

        println("Final Pointer for Nums2 Start: ${leftPointer}  End: ${rightPointer}")
        println("FInal Pointer for Nums1 ${endPointer}")
        return 0.0
    }

}