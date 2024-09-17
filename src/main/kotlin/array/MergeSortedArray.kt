package array

class MergeSortedArray {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        val sortedArray = mutableListOf<Int>()

        var firstPointer = 0
        var secondPointer = 0

        while (firstPointer < m && secondPointer < n) {

            if (nums1[firstPointer] < nums2[secondPointer]) {
                sortedArray.add(nums1[firstPointer])
                firstPointer++
            } else {
                sortedArray.add(nums2[secondPointer])
                secondPointer++
            }
        }

        for (i in secondPointer until n) {
            sortedArray.add(nums2[i])
        }

        for (j in firstPointer until m) {
            sortedArray.add(nums1[j])

        }

        for (i in sortedArray.indices) {
            nums1[i] = sortedArray[i]
        }
    }
}