package map

class MyHashMap() {

    private val mapArray: Array<Node?> = Array(size = 1000) { null }

    fun put(key: Int, value: Int) {
        val node = mapArray[getIndexBaseOnKey(key)]
        addNode(currentNode = node, insertionNode = Node(key = key, value = value))

    }

    fun get(key: Int): Int {
        return getKeyValue(key)
    }

    fun remove(key: Int) {
        removeNode(key)
    }

    private fun getIndexBaseOnKey(key: Int): Int {
        return key % 1000
    }

    private fun getKeyValue(key: Int): Int {
        var value = -1
        var iterationNode = mapArray[getIndexBaseOnKey(key)]
        while (iterationNode != null) {
            if (iterationNode.key == key) {
                value = iterationNode.value
                break
            }
            iterationNode = iterationNode.next
        }
        return value
    }

    private fun addNode(currentNode: Node?, insertionNode: Node) {

        if (currentNode == null) {
            mapArray[getIndexBaseOnKey(insertionNode.key)] = insertionNode
            println("Added at Index  ${getIndexBaseOnKey(insertionNode.key)} with value ${insertionNode.toString()}")
            return
        } else if (currentNode.key == insertionNode.key) {
            currentNode.value = insertionNode.value
            return
        } else if (currentNode.next == null) currentNode.next = insertionNode
        else addNode(currentNode = currentNode.next, insertionNode = insertionNode)
    }

    private fun removeNode(key: Int) {
        val startNode = mapArray[getIndexBaseOnKey(key)] ?: return
        var pastNode: Node? = null
        var iterationNode: Node? = startNode
        while (iterationNode != null) {
            if (iterationNode.key == key) {
                if (pastNode == null) {
                    mapArray[getIndexBaseOnKey(key)] = iterationNode.next
                    return
                } else {
                    pastNode.next = iterationNode.next
                    return
                }
            }
            pastNode = iterationNode
            iterationNode = iterationNode.next
        }
    }

    data class Node(
        var key: Int = -1, var value: Int = -1, var next: Node? = null
    )

}
