package heap

import java.util.*

class MaximumSlidingWindow {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {

        val list = mutableListOf<Int>()
        var leftPointer = 0
        var rightPointer = k - 1

        val heap = PriorityQueue<Pair<Int, Int>>(compareByDescending { it.second })

        for (i in 0 until k - 1) {
            heap.offer(Pair(i, nums[i]))
        }

        while (rightPointer < nums.size) {
            val newElm = Pair(rightPointer, nums[rightPointer])
            heap.offer(newElm)

            while (heap.peek().first < leftPointer) {
                heap.poll()
            }
            list.add(heap.peek().second)
            leftPointer++
            rightPointer++

        }
        return list.toIntArray()

    }

}