package binarysearch

class BinarySearch {

    fun search(nums: IntArray, target: Int): Int {


        //We start with the Left Pointer at 0 and the Right Pointer at n
        var leftPointer = 0
        var rightPointer = nums.size -1



        //We iterate until the left pointer is less than or equal to the right pointer
        while (rightPointer >= leftPointer){

            //We calculate the middle pointer
            //We don't use the formula (leftPointer + rightPointer) / 2 to avoid integer overflow
            val middlePointer = leftPointer +(rightPointer - leftPointer) / 2


            //If the middle element is equal to the target, we return the middle pointer
            if(nums[middlePointer] == target) return middlePointer


            //If the target is less than the middle element, we update the right pointer
            else if(target < nums[middlePointer]){
                rightPointer = middlePointer-1
            }else{
                //If the target is greater than the middle element, we update the left pointer
                leftPointer = middlePointer+1
            }
        }

        //If we reach here, it means the target is not found, we return -1
        return -1
    }
}