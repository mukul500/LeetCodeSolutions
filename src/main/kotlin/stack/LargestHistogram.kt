package stack

import java.util.*

class LargestHistogram {
    fun largestRectangleArea(heights: IntArray): Int {

        val stack = Stack<Rectangle>()
        var maxArea = 0

        for(index in heights.indices){
            val currentHeight = heights[index]
            val rectangle = Rectangle(currentHeight, index)
            if(stack.isEmpty()){
                stack.push(rectangle)
            }else{
                while(true){
                    if(stack.isEmpty()){
                        stack.push(rectangle)
                        break
                    }
                    var previousRect = stack.peek()
                    if(currentHeight < previousRect.height){
                        val previousArea = (index - previousRect.startIndex) * previousRect.height
                        if(previousArea > maxArea){
                            maxArea = previousArea

                        }
                        rectangle.startIndex = previousRect.startIndex
                        stack.pop()
                    }
                    else{
                        stack.push(rectangle)
                        break
                    }
                }
            }
        }

        while(stack.isNotEmpty()){
            val rect = stack.pop()
            val area = (heights.size -rect.startIndex) * rect.height
            if(area > maxArea){
                maxArea = area
            }
        }

        return maxArea

    }


    data class Rectangle(
        var height: Int,
        var startIndex: Int,
    )
}