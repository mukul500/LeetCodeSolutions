package graphs

/**
 * Note That graph algo is for  UniDirected Graph.
 * Means if  we can go from  Node 1 -> Node 2. It can go from Node 2 -> Node 1
 * Any Node can act as a root node in UniDirected
 *
 */
class ValidGraphUniDirected {

    class Node(val course: Int) {
        val neighbors = mutableListOf<Node>()

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is Node) return false
            return course == other.course
        }

        override fun hashCode(): Int = course
    }

    fun validTree(n: Int, edges: Array<IntArray>): Boolean {


        if (edges.size != n - 1) return false
        if (n == 1 && edges.isEmpty()) return true
        val rootNode = buildTree(edges)
        val nodeStatus: MutableMap<Node, NodeStatus> = mutableMapOf()
        if (hasCycle(rootNode, null, nodeStatus)) return false
        return nodeStatus.size == n

    }

    private fun buildTree(edges: Array<IntArray>): Node {
        val uniqueNodes: MutableMap<Int, Node> = mutableMapOf()

        for ((fromEdge, toEdge) in edges) {
            val fromNode = uniqueNodes.getOrPut(fromEdge) { Node(fromEdge) }
            val toNode = uniqueNodes.getOrPut(toEdge) { Node(toEdge) }
            fromNode.neighbors.add(toNode)
            toNode.neighbors.add(fromNode)
        }
        return uniqueNodes[0]!!
    }


    private fun hasCycle(node: Node, parentNode: Node?, currentState: MutableMap<Node, NodeStatus>): Boolean {
        if (currentState[node] == NodeStatus.VISITING) return true
        else if (currentState[node] == NodeStatus.VISITED) return false
        currentState[node] = NodeStatus.VISITING
        for (neighbor in node.neighbors) {
            if (neighbor == parentNode) continue
            val result = hasCycle(neighbor, node, currentState)
            if (result) return true
        }
        currentState[node] = NodeStatus.VISITED
        return false
    }


    enum class NodeStatus {
        VISITED, VISITING
    }

}