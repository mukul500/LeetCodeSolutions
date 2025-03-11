package graphs


class CourseSchedule {


    data class Node(
        val value: Int,
        val neighbors: MutableList<Node> = mutableListOf()
    )


    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        if (prerequisites.isEmpty()) {
            return true
        }
        val uniqueNodes: MutableMap<Int, Node> = mutableMapOf()
        for (pre in prerequisites) {
            val vertexNode = if (uniqueNodes.containsKey(pre[0])) {
                uniqueNodes[pre[0] ]!!
            } else {
                val node = Node(pre[0] )
                uniqueNodes[pre[0] ] = node
                node
            }
            val edgeNode = if (uniqueNodes.containsKey(pre[1] )) {
                uniqueNodes[pre[1]]!!
            } else {
                val node = Node(pre[1] )
                uniqueNodes[pre[1] ] = node
                node
            }

            vertexNode.neighbors.add(edgeNode)
        }

        val visitedNodes: MutableMap<Int, NodeStatus> = mutableMapOf()
        val topologicalOrder: MutableList<Int> = mutableListOf()
        fun topLogicalSort(node: Node): Boolean {
            if (visitedNodes[node.value] == NodeStatus.VISITING) return false
            if (visitedNodes[node.value] == NodeStatus.VISITED) return true
            visitedNodes[node.value] = NodeStatus.VISITING
            for (neighbour in node.neighbors) {
                if (!topLogicalSort(neighbour)) return false
            }
            visitedNodes[node.value] = NodeStatus.VISITED
            topologicalOrder.add(node.value)
            return true
        }

        for (node in uniqueNodes.values) {
            if (!visitedNodes.containsKey(node.value)) {
                if (!topLogicalSort(node)) return false
            }
        }
        return topologicalOrder.size <= numCourses
    }

    enum class NodeStatus {
        NOT_VISITED, VISITED, VISITING
    }

}