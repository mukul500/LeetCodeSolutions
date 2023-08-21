package graphs

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}

class CloneGraph {
    fun cloneGraph(node: Node?): Node? {

        val newNodes: HashMap<Node, Node> = HashMap()
        val queue: Queue<Node> = LinkedList()
        if (node == null) {
            return null
        }
        queue.add(node)

        while (queue.isNotEmpty()) {

            //Get the Current Node
            val currentNode = queue.poll()

            //If the Copy of the nodes Doesn't exist, we create a new node and add it to the map
            if (!newNodes.containsKey(currentNode)) {
                //We create a new node
                val node = Node(currentNode.`val`)
                //We create a new list of neighbors
                node.neighbors = ArrayList()

                //We add the node to the map
                newNodes[currentNode] = node
            }

            //We get the neighbors of the current node
            val neighbors = currentNode.neighbors


            //We traverse the neighbors and add them to the queue and the map
            neighbors.forEach {

                //
                if(it!= null) {


                    //If the Copy of the nodes Doesn't exist, we create a new node and add it to the map
                    if (!newNodes.containsKey(it)) {

                        //We add the node to the queue for Breadth First Search
                        queue.add(it)

                        //We create a new node
                        val neighbourNewNode = Node(it.`val`)
                        //We create a new list of neighbors
                        neighbourNewNode.neighbors = ArrayList()

                        //We add the Copied node to the map
                        newNodes[it] = neighbourNewNode
                        //We add the Copied node to the neighbors of the current node
                        val list = newNodes[currentNode]?.neighbors?.toMutableList()
                        list?.add(neighbourNewNode)

                        //We update the neighbors of the current node
                        newNodes[currentNode]?.neighbors = list as ArrayList<Node?>

                        //If the neighbour node copy exists, we add the neighbour node to the neighbors of the current node
                    }else{

                        //We get the current node from the map
                        val list = newNodes[currentNode]?.neighbors?.toMutableList()

                        //We add the Copied node to the neighbors of the current node
                        list?.add(newNodes[it])

                        //We update the neighbors of the current node
                        newNodes[currentNode]?.neighbors = list as ArrayList<Node?>
                    }
                }
            }

        }
        return newNodes[node]
    }
}