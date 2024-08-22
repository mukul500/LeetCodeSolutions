package hashing

class `Word Pattern` {

    fun wordPattern(pattern: String, s: String): Boolean {

        val sWordsArray = s.split(" ")
        val patternArray = pattern.toCharArray().map { it.toString() }.toList()
        println(patternArray)
        return checkCrossMappings(
            keyList = patternArray, valueList = sWordsArray
        ) && checkCrossMappings(keyList = sWordsArray, valueList = patternArray)

    }


    private fun checkCrossMappings(keyList: List<String>, valueList: List<String>): Boolean {
        if (keyList.size != valueList.size) return false
        val patternMap: MutableMap<String, String> = mutableMapOf()
        patternMap.values.toSet()
        for (i in keyList.indices) {
            if (patternMap.containsKey(keyList[i])) {
                val word = patternMap[keyList[i]]
                if (word != valueList[i]) return false

            } else {
                patternMap[keyList[i]] = valueList[i]
            }
        }
        return true


    }

}