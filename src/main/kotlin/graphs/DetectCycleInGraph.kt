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