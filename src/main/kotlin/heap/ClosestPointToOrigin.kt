package heap

import java.util.*
import kotlin.math.sqrt


//√(x1 - x2)2 + (y1 - y2)2
class ClosestPointToOrigin {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {

        val queue = PriorityQueue<PointDistance>(compareByDescending { it.distance })

        for (point in points) {
            val distance = calculateDistanceFromOrigin(point[0], point[1])
            val pointDistance = PointDistance(distance = distance, point = point)
            queue.offer(pointDistance)
            if (queue.size > k) {
                queue.poll()
            }
        }

        val finalList = mutableListOf<IntArray>()
        while (queue.isNotEmpty()) {
            val pointDistance = queue.poll()
            finalList.add(pointDistance.point)
        }
        return finalList.toTypedArray()

    }

    private fun calculateDistanceFromOrigin(x1: Int, y1: Int): Double {

        val x2 = 0
        val y2 = 0

        return sqrt(((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)).toDouble())
    }

    data class PointDistance(
        val distance: Double,
        val point: IntArray
    )

}
