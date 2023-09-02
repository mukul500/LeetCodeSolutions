package tree

import java.util.PriorityQueue

class KClosestPointsToOrigin {

    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {

        val queue: PriorityQueue<PointsData> = PriorityQueue { data1, data2 ->
            data2.distance - data1.distance
        }
//
//       return  points.sortedBy {
//            ( it[0] * it[0]) + (it[1] * it[1])
//        }.subList(0 , k).toTypedArray()


//       return points.sliceArray(points.size-k until points.size)
//
        //0(N * logn)
        points.forEach {
            val distance = calculateDistanceFromOrigin(it[0], it[1])
            val pointsData = PointsData(points = it, distance = distance)
            queue.add(pointsData)

            if (queue.size > k) {
                queue.poll()
            }
        }
        val resultList: ArrayList<IntArray> = ArrayList()

        while (queue.isNotEmpty()) {
            resultList.add(queue.poll().points)
            if (resultList.size == k)
                break
        }
        return resultList.toTypedArray()
    }

    data class PointsData(
        var points: IntArray,
        var distance: Int
    )

    private fun calculateDistanceFromOrigin(x: Int, y: Int): Int {
        return (x * x) + (y * y)
    }
}