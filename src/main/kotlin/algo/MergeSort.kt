package algo

class MergeSort {
    fun sortArray(nums: IntArray): IntArray {

        if (nums.size <= 1)
            return nums

        val mid = nums.size / 2
        val leftSlice = nums.sliceArray(0 until mid)
        val rightSlice = nums.sliceArray(mid until nums.size)

        val leftSort = sortArray(leftSlice)
        val rightSort = sortArray(rightSlice)

        return mergeArrays(leftArray = leftSort, rightArray = rightSort)

    }


    private fun mergeArrays(leftArray: IntArray, rightArray: IntArray): IntArray {

        var leftPointer = 0
        var rightPointer = 0
        var resultPointer = 0


//        while (leftPointer < leftArray.size && rightPointer < rightArray.size){
//             if(leftArray[leftPointer] < rightArray )
//        }

        return intArrayOf()


    }


}