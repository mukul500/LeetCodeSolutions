package tree

class Trie {

    val startingLetters: MutableMap<Char, TrieNode> = mutableMapOf()

    fun insert(word: String) {
        var parent = startingLetters
        for (i in word.indices) {
            val currentNode = parent.getOrDefault(word[i], TrieNode(word[i]))
            parent[word[i]] = currentNode
            parent = currentNode.children
            if (i == word.length - 1) {
                currentNode.isEndOfWord = true
            }
        }
    }

    fun search(word: String): Boolean {
        var parent = startingLetters
        for (i in word.indices) {
            val currentNode = parent[word[i]] ?: return false
            parent = currentNode.children
            if (i == word.length - 1 && currentNode.isEndOfWord) {
                println("Word $word: True")
                return true
            }
        }
        println("Word $word: False")
        return false
    }

    fun startsWith(prefix: String): Boolean {
        var parent = startingLetters
        for (i in prefix.indices) {
            val currentNode = parent[prefix[i]] ?: return false
            parent = currentNode.children
        }

        val result = dfs(parent)
        if (result) {
            println("Prefix $prefix: $result")
        }
        return result

    }

    fun dfs(map: MutableMap<Char, TrieNode>): Boolean {

        if (map.isEmpty()) return false

        for ((key, node) in map) {
            if (node.isEndOfWord) {
                return true
            } else {
                val newResult = dfs(node.children)
                if (newResult) {
                    return true
                }
            }
        }
        return false
    }

    data class TrieNode(
        val char: Char, var isEndOfWord: Boolean = false, var children: MutableMap<Char, TrieNode> = mutableMapOf()
    )

}
