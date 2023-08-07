package binarysearch

class BinarySearch {

    fun search(nums: IntArray, target: Int): Int {

        var leftPointer = 0
        var rightPointer = nums.size -1


        while (rightPointer >= leftPointer){
            val middlePointer = leftPointer +(rightPointer - leftPointer) / 2


            if(nums[middlePointer] == target) return middlePointer

            else if(target < nums[middlePointer]){
                rightPointer = middlePointer-1
            }else{
                leftPointer = middlePointer+1
            }
        }
        return -1
    }
}