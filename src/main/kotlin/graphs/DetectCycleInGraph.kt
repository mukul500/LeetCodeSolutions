package graphs


class DetectCycleInGraph {

    fun scheduleCourse(numCourses: Int, edges: List<Pair<Int, Int>>): Boolean {

        val uniqueNodes: MutableMap<Int, Node> = mutableMapOf()

        for (edge in edges) {
            val vertexNode = if (uniqueNodes.containsKey(edge.first)) {
                uniqueNodes[edge.first]!!
            } else {
                val node = Node(edge.first)
                uniqueNodes[edge.first] = node
                node
            }
            val edgeNode = if (uniqueNodes.containsKey(edge.second)) {
                uniqueNodes[edge.second]
            } else {
                val node = Node(edge.second)
                uniqueNodes[edge.second] = node
                node
            }

            vertexNode.neighbors.add(edgeNode)
        }

        val visitedNodes: MutableMap<Int, NodeStatus> = mutableMapOf()
        val topologicalOrder: MutableList<Int> = mutableListOf()
        fun topLogicalSort(node: Node): Boolean {
            if (visitedNodes[node.`val`] == NodeStatus.VISITING) return false
            if (visitedNodes[node.`val`] == NodeStatus.VISITED) return true
            visitedNodes[node.`val`] = NodeStatus.VISITING
            for (neighbour in node.neighbors) {
                if (!topLogicalSort(neighbour!!)) return false
            }
            visitedNodes[node.`val`] = NodeStatus.VISITED
            topologicalOrder.add(node.`val`)
            return true
        }

        for (node in uniqueNodes.values) {
            if (!visitedNodes.containsKey(node.`val`)) {
                if (!topLogicalSort(node)) return false
            }
        }
        return topologicalOrder.size >= numCourses
    }

    enum class NodeStatus {
        NOT_VISITED, VISITED, VISITING
    }
}


class DetectCycleInGraph2 {


    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val uniqueNodes = buildGraph(numCourses, prerequisites)
        val currentState = mutableMapOf<Node, NodeStatus>()
        for ((_, node) in uniqueNodes) {
            if (hasCycle(node, currentState)) return false
        }
        return true
    }

    fun buildGraph(numCourses: Int, prerequisites: Array<IntArray>): Map<Int, Node> {
        val uniqueNodes = mutableMapOf<Int, Node>()

        // Ensure all courses exist in the graph, even if they have no prerequisites
        for (i in 0 until numCourses) {
            uniqueNodes.getOrPut(i) { Node(i) }
        }

        for ((course, prereq) in prerequisites) {
            val courseNode = uniqueNodes[course]!!
            val prereqNode = uniqueNodes[prereq]!!

            // Edge direction: prereq → course
            // "To take course, you must first finish prereq"
            prereqNode.neighbors.add(courseNode)
        }

        return uniqueNodes
    }


    fun hasCycle(node: Node, currentState: MutableMap<Node, NodeStatus>): Boolean {
        if (currentState[node] == NodeStatus.VISITING) return true
        else if (currentState[node] == NodeStatus.VISITED) return false
        currentState[node] = NodeStatus.VISITING
        for (neighbor in node.neighbors) {
            val result = neighbor?.let { hasCycle(it, currentState) }
            if (result == true) return true
        }
        currentState[node] = NodeStatus.VISITED
        return false
    }

    enum class NodeStatus {
        NOT_VISITED, VISITED, VISITING
    }
}