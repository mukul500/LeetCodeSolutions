package array

import kotlin.math.absoluteValue

class AbsoluteSort {

    fun findAbsoluteValues(A: IntArray): List<Int> {

        var list: MutableList<Int> = mutableListOf()

        var middleOfTheList = A.size - 1


        for (i in A.indices) {
            if (A[i] >= 0) {
                middleOfTheList = i
                break
            }
        }

        //Left pointer points to the negative number on the left side of the list
        var leftPointer = middleOfTheList - 1
        // Right pointer points to the positive number on the right side of the list
        var rightPointer = middleOfTheList

        //We iterate through the list until we reach the end of the list
        while (leftPointer >= 0 && rightPointer < A.size) {

            //If the left pointer is less than the right pointer, we add the left pointer to the set
            if (A[leftPointer].absoluteValue  < A[rightPointer]) {
                list.add(A[leftPointer].absoluteValue)
                //We move the left pointer to the left
                leftPointer--

            }
            // If the right pointer is less than the left pointer, we add the right pointer to the set
            else if (A[leftPointer] * -1 > A[rightPointer]) {
                list.add(A[rightPointer].absoluteValue)
                //We move the right pointer to the right
                rightPointer++

                //If the left pointer is equal to the right pointer, we add only one of them to the set
            } else {
                list.add(A[leftPointer].absoluteValue)
                //We move the left pointer to the left
                leftPointer--
                //We move the right pointer to the right
                rightPointer++
            }
        }

        // If there are remaining elements on the left side of the list, we add them to the set
        while (leftPointer >= 0) {
            list.add(A[leftPointer].absoluteValue)
            leftPointer--
        }


        //If there are remaining elements on the right side of the list, we add them to the set
        while (rightPointer < A.size) {
            list.add(A[rightPointer].absoluteValue)
            rightPointer++
        }

        return list
    }




}



