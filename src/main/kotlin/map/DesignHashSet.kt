package map

import java.security.Key

class MyHashSet() {

    private val hashSetArray: Array<KeyNode?> = Array(1000) {
        null
    }

    fun add(key: Int) {
        val index = getIndexBaseOnKey(key)
        val currentNode = hashSetArray[index]
        addNode(currentNode = currentNode, key = key)
    }

    fun remove(key: Int) {
        val index = getIndexBaseOnKey(key)
        val currentNode = hashSetArray[index]
        removeNode(currentNode, key)
    }

    fun contains(key: Int): Boolean {
        val indexNode = hashSetArray[getIndexBaseOnKey(key)]
        return checkNode(indexNode, key)
    }

    private fun addNode(currentNode: KeyNode?, key: Int) {
        if (currentNode == null) {
            hashSetArray[getIndexBaseOnKey(key)] = KeyNode(key, null)
        }
        if (currentNode?.key == key) {
            currentNode.key = key
            return
        }
        if (currentNode?.nextNode == null) {
            currentNode?.nextNode = KeyNode(key = key, null)
            return
        }
        addNode(currentNode.nextNode, key)

    }

    private fun removeNode(indexNode: KeyNode?, key: Int) {
        var currentNode: KeyNode? = indexNode
        var previousNode: KeyNode? = null
        while (currentNode != null) {
            if (currentNode.key == key) {
                if (previousNode == null) {
                    hashSetArray[getIndexBaseOnKey(key)] = currentNode.nextNode
                    return
                } else {
                    previousNode.nextNode = currentNode.nextNode
                    return
                }
            }
            previousNode = currentNode
            currentNode = currentNode.nextNode
        }
    }

    private fun checkNode(indexNode: KeyNode?, key: Int): Boolean {
        if (indexNode == null) return false
        if (indexNode.key == key) return true
        return checkNode(indexNode.nextNode, key)
    }

    private fun getIndexBaseOnKey(key: Int): Int {
        return key % 1000
    }


    data class KeyNode(
        var key: Int, var nextNode: KeyNode?
    )

}
