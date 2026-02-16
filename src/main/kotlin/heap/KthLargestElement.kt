package heap

import java.util.*


class KthLargestElement {

    val heap = PriorityQueue<Int>()
    fun findKthLargest(nums: IntArray, k: Int): Int {

        for (num in nums) {
            heap.offer(num)
            if (heap.size > k) {
                heap.poll()
            }
        }
        return heap.peek()
    }
}