package binarysearch

class SearchInRotatedSortedArrayOfUnknownSize {
    fun search(reader: ArrayReader, target: Int): Int {
        var leftPointer = 0
        var rightPointer = Int.MAX_VALUE
        // Your implementation goes here

        while (leftPointer <= rightPointer) {
            val middlePointer = leftPointer + (rightPointer - leftPointer) / 2
            if (reader.get(middlePointer) == target) return middlePointer
            if (target > reader.get(middlePointer)) {
                leftPointer = middlePointer + 1
            } else {
                rightPointer = middlePointer - 1
            }
        }
        return -1
    }

}


class ArrayReader {
    // Returns the value at the given index, if the index is out of bounds, return Integer.MAX_VALUE
    fun get(index: Int): Int {
        // Implementation provided by LeetCode, you don't need to implement this
        return 0
    }
}