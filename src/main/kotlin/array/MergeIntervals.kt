package array

import kotlin.math.max
import kotlin.math.min

class MergeIntervals {


    fun merge(intervals: Array<IntArray>): Array<IntArray> {

        //Create a Mutable List of IntArray to add the Merged Elements
        val result: MutableList<IntArray> = mutableListOf()

        //Sort the Intervals by the Start Time
        val sortedIntervals = intervals.sortedBy { it[0] }


        //Store the First Interval
        var currentInterval = sortedIntervals[0]


        //Loop the Intervals from the Second Element
        for (i in 1 until sortedIntervals.size) {

            //Store the Next Interval
            val nextInterval = sortedIntervals[i]

            //Compare the Next Interval Start Time with the Current Interval End Time
            if (currentInterval[1] >= nextInterval[0]) {
                currentInterval[0] = minOf(currentInterval[0], nextInterval[0])
                currentInterval[1] = maxOf(currentInterval[1], nextInterval[1])
                //Merge the current Interval
            } else {
                //If No merging found Swap the Current Interval with the Next Interval
                result.add(currentInterval)
                currentInterval = nextInterval
            }
        }
        //Add the Ending Interval
        result.add(currentInterval)
        return result.toTypedArray()
    }
}