package graphs

class CourseSchedule22 {

    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val uniqueNodes = buildGraph(numCourses, prerequisites)
        val order = mutableListOf<Int>()
        val currentState = mutableMapOf<Node, NodeStatus>()
        for ((_, node) in uniqueNodes) {
            if (hasCycle(node, currentState, order)) return emptyArray<Int>().toIntArray()
        }
        return order.reversed().toIntArray()
    }

    fun buildGraph(numCourses: Int, prerequisites: Array<IntArray>): Map<Int, Node> {
        val uniqueNodes = mutableMapOf<Int, Node>()

        for (i in 0 until numCourses) {
            uniqueNodes.getOrPut(i) { Node(i) }
        }

        for ((course, prereq) in prerequisites) {
            val courseNode = uniqueNodes[course]!!
            val prereqNode = uniqueNodes[prereq]!!

            prereqNode.neighbors.add(courseNode)
        }

        return uniqueNodes
    }

    fun hasCycle(
        node: Node,
        currentState: MutableMap<Node, NodeStatus>,
        order: MutableList<Int>
    ): Boolean {
        if (currentState[node] == NodeStatus.VISITING) return true
        else if (currentState[node] == NodeStatus.VISITED) return false
        currentState[node] = NodeStatus.VISITING
        for (neighbor in node.neighbors) {
            val result = neighbor?.let { hasCycle(it, currentState, order) }
            if (result == true) return true
        }
        currentState[node] = NodeStatus.VISITED
        order.add(node.`val`)
        return false
    }

    enum class NodeStatus {
        NOT_VISITED, VISITED, VISITING
    }

}