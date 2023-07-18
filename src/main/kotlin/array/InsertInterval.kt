package array

class InsertInterval {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {

        //Store the New IntervalStart
        var start = newInterval[0]
        //Store the New IntervalEnd
        var end = newInterval[1]

        //Create a Mutable List of IntArray to add the Merged Elements
        val mergedList = mutableListOf<IntArray>()

        //Counter to Iterate the Full list of Intervals
        var counter: Int = 0

        //Fist Loop Add all the Intervals which are less than the New Interval Starting Point. Means there is no Overlaping
        //Check if the Interval End is less than the New Interval Start
        while (counter < intervals.size && intervals[counter][1] < start) {
            mergedList.add(intervals[counter])
            counter++
        }


        //Second Loop to Merge the Overlaping Intervals
        //We found the overlaping. Will continue Traversing the Intervals list till we find the Interval Start is More than the New Interval End
        while (counter < intervals.size && intervals[counter][0] <= end) {
            //Will find the minimum of the Interval Start and New Interval Start
            start = Math.min(start, intervals[counter][0])
            //Will find the maximum of the Interval End and New Interval End
            end = Math.max(end, intervals[counter][1])
            counter++
        }

        //Finally We Will add the Merged Interval
        mergedList.add(intArrayOf(start, end))


        //Will Continue Adding the Remaining Intervals
        while (counter < intervals.size) {
            mergedList.add(intervals[counter])
            counter++
        }

        return mergedList.toTypedArray()

    }

}