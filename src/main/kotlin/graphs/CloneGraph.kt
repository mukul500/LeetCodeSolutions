package graphs

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}

class CloneGraph {
    fun cloneGraph(node: Node?): Node? {

        val newNodes: HashMap<Int, Node> = HashMap()
        val queue: Queue<Node> = LinkedList()
        if (node == null) {
            return null
        }
        queue.add(node)

        while (queue.isNotEmpty()) {

            //Get the Current Node
            val currentNode = queue.poll()

            //If the Copy of the nodes Doesn't exist, we create a new node and add it to the map
            if (!newNodes.containsKey(currentNode.`val`)) {
                //We create a new node
                val node = Node(currentNode.`val`)
                //We create a new list of neighbors
                node.neighbors = ArrayList()

                //We add the node to the map
                newNodes[currentNode.`val`] = node
            }

            //We get the neighbors of the current node
            val neighbors = currentNode.neighbors


            //We traverse the neighbors and add them to the queue and the map
            neighbors.forEach {

                //
                if (it != null) {


                    //If the Copy of the nodes Doesn't exist, we create a new node and add it to the map
                    if (!newNodes.containsKey(it.`val`)) {

                        //We add the node to the queue for Breadth First Search
                        queue.add(it)

                        //We create a new node
                        val neighbourNewNode = Node(it.`val`)
                        //We create a new list of neighbors
                        neighbourNewNode.neighbors = ArrayList()

                        //We add the Copied node to the map
                        newNodes[it.`val`] = neighbourNewNode
                        //We add the Copied node to the neighbors of the current node
                        val list = newNodes[currentNode.`val`]?.neighbors?.toMutableList()
                        list?.add(neighbourNewNode)

                        //We update the neighbors of the current node
                        newNodes[currentNode.`val`]?.neighbors = list as ArrayList<Node?>

                        //If the neighbour node copy exists, we add the neighbour node to the neighbors of the current node
                    } else {

                        //We get the current node from the map
                        val list = newNodes[currentNode.`val`]?.neighbors?.toMutableList()

                        //We add the Copied node to the neighbors of the current node
                        list?.add(newNodes[it.`val`])

                        //We update the neighbors of the current node
                        newNodes[currentNode.`val`]?.neighbors = list as ArrayList<Node?>
                    }
                }
            }

        }
        return newNodes[node.`val`]
    }
}


/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var neighbors: ArrayList<Node?> = ArrayList<Node?>()
 * }
 */


class CloneGP2 {
    fun cloneGraph(node: Node?): Node? {
        if (node == null) return null

        val queue: Queue<Node> = LinkedList()
        val visitedNode = mutableMapOf<Int, Node>()

        queue.add(node)
        val head = Node(`val` = node.`val`)
        visitedNode.put(head.`val`, head)


        while (queue.isNotEmpty()) {

            val currentNode = queue.poll()
            val copyNode: Node
            if (visitedNode.contains(currentNode.`val`)) {
                copyNode = visitedNode.get(currentNode.`val`)!!
            } else {
                copyNode = Node(currentNode.`val`)
                visitedNode.put(copyNode.`val`, copyNode)
            }


            currentNode.neighbors.forEach { neighbor ->


                val copyNeighborNode: Node
                if (visitedNode.contains(neighbor!!.`val`)) {
                    copyNeighborNode = visitedNode.get(neighbor!!.`val`)!!
                } else {
                    copyNeighborNode = Node(neighbor!!.`val`)
                    visitedNode.put(copyNeighborNode!!.`val`, copyNeighborNode)
                    queue.add(neighbor)
                }
                copyNode.neighbors.add(copyNeighborNode)
            }
        }
        return head
    }
}


class CloneGP3 {

    /**
     * Returns a Deep copy of the graph
     */

    private val visitedSet = mutableSetOf<Node>()

    private val copyNodesMap = mutableMapOf<Int, Node>()
    fun cloneGraph(node: Node?): Node? {
        if (node == null) return null
        bfs(node)
        return copyNodesMap[node.`val`]
    }

    private fun bfs(node: Node) {

        val queue: Queue<Node> = LinkedList()
        queue.add(node)
        while (queue.isNotEmpty()) {
            val currentNode = queue.poll()
            if (visitedSet.contains(currentNode)) continue

            val newNode = copyNodesMap.getOrDefault(currentNode.`val`, Node(currentNode.`val`))
            for (neighbour in currentNode.neighbors) {
                val newChildNode = copyNodesMap.getOrDefault(neighbour!!.`val`, Node(neighbour.`val`))
                copyNodesMap[neighbour.`val`] = newChildNode
                newNode.neighbors.add(newChildNode)
                queue.add(neighbour)
            }
            visitedSet.add(currentNode)
            copyNodesMap[currentNode.`val`] = newNode
        }
    }
}