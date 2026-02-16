package heap

import java.util.*
import kotlin.math.absoluteValue

class LastStoneWeight {
    fun lastStoneWeight(stones: IntArray): Int {
        val queue = PriorityQueue<Int>(compareByDescending { it })

        for(num in stones){
            queue.offer(num)
        }

        while(queue.size > 1){
            val x = queue.poll()
            val y = queue.poll()
            val result = (x- y).absoluteValue
            queue.offer(result)
        }
        return queue.peek()
    }
}