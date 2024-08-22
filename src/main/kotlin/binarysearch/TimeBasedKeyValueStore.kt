package binarysearch

import java.util.SortedMap
import java.util.TreeMap

class TimeBasedKeyValueStore {


    //We Implement a Map of String and TreeMap of Int and String

    //We Implement a Tree Map Because of Binary Search Tree Implementation
    //It makes searching for the closest timestamp to the given timestamp in O(logn) time
    private val timeBasedKeyMap = mutableMapOf<String, TreeMap<Int, String>>()

    fun set(key: String, value: String, timestamp: Int) {


        //We Check if the key exists in the map
        if (timeBasedKeyMap.containsKey(key)) {

            //If the key exists, we get the TreeMap of Int and String
            val timeMap = timeBasedKeyMap[key]!!

            //We add the timestamp and value to the TreeMap
            timeMap[timestamp] = value

            //We update the TreeMap in the map
            timeBasedKeyMap[key] = timeMap

        } else {

            //If the key doesn't exist, we create a new TreeMap of Int and String
            val timeMap = TreeMap<Int, String>()
            timeMap[timestamp] = value
            timeBasedKeyMap[key] = timeMap
        }
    }

    fun get(key: String, timestamp: Int): String {

        //We initialize the value to empty string
        var value = ""

        //If the key doesn't exist, we return empty string
        if (!timeBasedKeyMap.containsKey(key)) {
            return value
        } else {

            //We Use the floorEntry method to get the closest timestamp to the given timestamp. This is a inbuilt method in TreeMap to filter the closest timestamp

            //Solution 1
//            return timeBasedKeyMap[key]?.floorEntry(timestamp)?.value ?: ""


            //Solution 2
            //This is the manual implementation of the floorEntry method

            //If the key exists, we get the TreeMap of Int and String
            val timeMap = timeBasedKeyMap[key]!!

            //We get the keys of the TreeMap in an array
            // This calls create a new array and copy all the keys to the array
            //But this is not a costly operation because the size of the array is the size of the TreeMap
            //It causes the Time Limit Exceeded Error
            val timeStampArray = timeMap.keys.toIntArray()

            //We calculte the difference between the timestamp and the first element in the array
            var difference = Int.MAX_VALUE

            //Our Left Pointer is 0 and Right Pointer is the size of the array - 1
            var leftPointer = 0
            var rightPointer = timeStampArray.size - 1


            //We iterate until the left pointer is less than or equal to the right pointer

            while (leftPointer <= rightPointer) {

                //We calculate the middle pointer
                val middlePointer = leftPointer + (rightPointer - leftPointer) / 2

                //We get the current timestamp
                val currentTimeStamp = timeStampArray[middlePointer]


                // If the Current timestamp is greater than the given timestamp, we update the right pointer
                //We need to find the value only before the given timestamp
                if (currentTimeStamp > timestamp) {
                    rightPointer = middlePointer - 1

                    //if the current time stamp is less than the given timestamp, we update the left pointer
                } else {
                    leftPointer = middlePointer + 1

                    //We calculate the difference between the current timestamp and the given timestamp
                    if (difference > timestamp - currentTimeStamp) {
                        difference = timestamp - currentTimeStamp
                        //We update the value
                        value = timeMap[currentTimeStamp]!!
                    }
                }
            }
        }
        return value
    }
}