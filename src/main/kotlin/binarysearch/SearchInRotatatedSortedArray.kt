package binarysearch

class SearchInRotatedSortedArray {

    fun search(nums: IntArray, target: Int): Int {


        //We start with the Left Pointer at 0 and the Right Pointer at n
        var leftPointer = 0
        var rightPointer = nums.size - 1


        //We iterate until the left pointer is less than or equal to the right pointer
        while (rightPointer >= leftPointer) {

            //We calculate the middle pointer
            val middle = leftPointer + (rightPointer - leftPointer) / 2


            //If the middle element is equal to the target, we return the middle pointer
            if (nums[middle] == target) return middle


            //First We check if the left portion is sorted
            else if (nums[middle] >= nums[leftPointer]) {


                //IF t
                //It Means the target is in the left portionhe portion is sorted we check if the target is greater than left pointer and less than middle pointer
                if (target < nums[middle] && target >= nums[leftPointer]) {
                    //Therefore we update the right pointer
                    rightPointer = middle - 1
                } else {

                    //Left portion is sorted and target is not less than middle pointer or not greater than left pointer
                    //Means our target is on the right portion
                    leftPointer = middle + 1
                }
            }
            //Right Portion is Sorted
            else {

                //We check if the target is greater than middle pointer and less than right pointer
                //Means target is in the right portion
                if (target > nums[middle] && target <= nums[rightPointer]) {
                    //We Move the left pointer to the right portion
                    leftPointer = middle + 1
                } else {
                    //We search in the left portion
                    rightPointer = middle - 1
                }
            }
        }
        //If the target is not found, we return -1
        return -1
    }
}


class SearchInRotatedSortedArray2 {
    fun search(a: IntArray, target: Int): Int {
        var targetIndex = -1
        if (a.isEmpty()) return targetIndex

        var leftPointer = 0
        var rightPointer = a.size - 1

        while (leftPointer <= rightPointer) {

            val middlePointer = leftPointer + (rightPointer - leftPointer) / 2
            println("Middle Pointer: $middlePointer")
            if (a[middlePointer] == target) return middlePointer

            //Left Side is sorted
            if (a[middlePointer] >= a[leftPointer]) {

                //Need to check if the target lies in the left side or not
                if (target < a[middlePointer] && target >= a[leftPointer]) {
                    rightPointer = middlePointer - 1
                } else {
                    leftPointer = middlePointer + 1
                }

            } else {
                if (a[rightPointer] >= a[middlePointer]) {
                    if (target > a[middlePointer] && target <= a[rightPointer]) {
                        leftPointer = middlePointer + 1
                    } else {
                        rightPointer = middlePointer - 1
                    }
                }

            }
        }
        return targetIndex
    }

}