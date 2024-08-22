package hashing

import kotlin.text.StringBuilder

class `Group Anagrams` {

    private var anagramMap: MutableMap<String, MutableList<String>> = mutableMapOf()

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        strs.forEach {
            val frequencyArray = CharArray(26) { 'a' }
            it.chars().forEach { charCode ->
                frequencyArray[charCode - 'a'.code]++
            }

            insertIntoMap(hash = String(frequencyArray), it)
        }

        return getAllGroupedAnagrams()
    }


    private fun insertIntoMap(hash: String, item: String) {
        if (anagramMap.containsKey(hash)) {
            val existingList = anagramMap[hash]
            existingList!!.add(item)
        } else {
            anagramMap[hash] = mutableListOf(item)
        }
    }

    private fun getAllGroupedAnagrams(): List<List<String>> {
        val groupedAnagram = mutableListOf<List<String>>()
        anagramMap.forEach {
            groupedAnagram.add(it.value)
        }
        return groupedAnagram
    }
}