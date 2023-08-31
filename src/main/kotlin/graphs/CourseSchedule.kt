package graphs

import java.util.*

class CourseSchedule {


    data class Node(
        val value: Int,
        val neighbors: MutableList<Node> = mutableListOf()
    )

    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {

        if (prerequisites.isEmpty()) {
            return true
        }

        val nodes = mutableMapOf<Int, Node>()
        for (i in prerequisites.indices) {
            val currentPre = prerequisites[i][0]
            if (currentPre !in nodes) {
                val neighbourNode = Node(prerequisites[i][1])
                val headNode = Node(currentPre, mutableListOf(neighbourNode))
                nodes[prerequisites[i][1]] = neighbourNode
                nodes[currentPre] = headNode
                println("currentPre doesn't  $currentPre exists")
            } else {
                val neighbourNode = Node(prerequisites[i][1])
                val currentNode = nodes[currentPre]
                currentNode?.neighbors?.add(neighbourNode)
                println("currentPre $currentPre ${currentNode}")
            }
        }

        val visited = mutableSetOf<Int>()
        val queue: Queue<Node> = LinkedList()
        val firstKey = nodes.keys.first()
        queue.add(nodes[firstKey])

        print(queue.peek())

        var counter = 1
        while (queue.isNotEmpty()) {

            val currentNode = queue.poll()
            visited.add(currentNode.hashCode())
            val neighbors = currentNode.neighbors

            println("Visiting ${currentNode.value}")
            neighbors.forEach {
                if (it.hashCode() !in visited) {
                    queue.add(it)
                }
            }
            counter++
        }

        return counter <= numCourses

    }

}