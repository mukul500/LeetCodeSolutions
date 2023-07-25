package array

import kotlin.math.max

class ContainerWithTheMostWater {

    fun maxArea(height: IntArray): Int {


        //WE Uses the Two pointer approach
        var left = 0
        var right = height.size - 1
        //Store the Area in the maxArea variable
        var maxArea = 0


        //Traverse the Array from the Left and Right
        while (left < right) {
            //Caluclate the Width and Height
            val recWidth = right - left
            val recHeight = minOf(height[left], height[right])
            val area = recWidth * recHeight
            //If Area is Greater than the MaxArea then Store it in the MaxArea
            if (area > maxArea) {
                maxArea = area
            }

            //TODO Fully Clear the Concept of this Condition
            if (height[left] > height[right]) {
                right--
            } else {
                left++
            }

        }
        return maxArea

    }
}