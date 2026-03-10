package graphs


/**
 * Note That graph algo is for  Directed Graph.
 * Means if  we can go from  Node 1 -> Node 2. It can't go from Node 2 -> Node 1
 * We try to find the Node and return the root node.
 *
 */
class ValidGraphDirectedGraph {

    data class Node(
        val value: Int,
        val neighbors: MutableList<Node> = mutableListOf()
    )

    fun validTree(n: Int, edges: Array<IntArray>): Boolean {

        return try {
            val rootNode = buildTree(n, edges)
            println("Found the root Node = ${rootNode.value}")
            val nodeStatus: MutableMap<Node, NodeStatus> = mutableMapOf()
            return !hasCycle(rootNode, nodeStatus)
        } catch (exc: InvalidGraphException) {
            println("Not a valid Graph ${exc.message}")
            false
        }
    }

    private fun buildTree(n: Int, edges: Array<IntArray>): Node {
        val uniqueNodes: MutableMap<Int, Node> = mutableMapOf()

        for ((fromEdge, toEdge) in edges) {
            val fromNode = uniqueNodes.getOrPut(fromEdge) { Node(fromEdge) }
            val toNode = uniqueNodes.getOrPut(toEdge) { Node(toEdge) }
            fromNode.neighbors.add(toNode)
        }

        if (uniqueNodes.size != n) throw InvalidGraphException("Less Unique Node found than actual number")
        val childNodes = mutableSetOf<Int>()
        for ((_, node) in uniqueNodes) {
            for (childNode in node.neighbors) {
                childNodes.add(childNode.value)
            }
        }
        val parentNodes = mutableListOf<Node>()
        for ((key, node) in uniqueNodes) {
            if (!childNodes.contains(key)) {
                parentNodes.add(node)
            }
        }
        if (parentNodes.size == 1) return parentNodes[0]
        else if (parentNodes.size <= 0) throw InvalidGraphException("Not Root founds")
        else throw InvalidGraphException("Multiple Root founds so not connected")
    }


    private fun hasCycle(node: Node, currentState: MutableMap<Node, NodeStatus>): Boolean {
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


    class InvalidGraphException(msg: String) : Exception(msg)


    enum class NodeStatus {
        NOT_VISITED, VISITED, VISITING
    }

}