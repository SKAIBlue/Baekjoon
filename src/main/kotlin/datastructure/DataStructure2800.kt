/**
 * 괄호 제거
 * 문제 링크: https://www.acmicpc.net/problem/2800
 */

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList

data class BracketPair (
    var open: Int,
    var close: Int,
)

data class UseChar (
    var value: Char,
    var isUse: Boolean,
) {
    override fun toString(): String {
        return value.toString()
    }
}

fun findBracketPairs(listChar: List<UseChar>): List<BracketPair>{
    val results = mutableListOf<BracketPair>()
    val stack = LinkedList<BracketPair>()

    listChar.forEachIndexed { index, useChar ->
        when(useChar.value) {
            '(' -> {
                stack.add(BracketPair(open = index, close = -1))
            }
            ')' -> {
                val pair = stack.removeLast()
                pair.close = index
                results.add(pair)
            }
        }
    }
    return results
}

fun dfs(listChar: List<UseChar>, bracketPairs: List<BracketPair>, indexBracketPair: Int, set: MutableSet<String>, result: MutableList<String>) {
    if(indexBracketPair == bracketPairs.size) {
        val str = listChar.filter { it.isUse }.joinToString("")
        if(!set.contains(str)) {
            // 중복 제거
            set.add(str)
            result.add(str)
        }
        return
    }

    val pair = bracketPairs[indexBracketPair]
    listChar[pair.open].isUse = false
    listChar[pair.close].isUse = false
    dfs(listChar, bracketPairs, indexBracketPair + 1, set, result)

    listChar[pair.open].isUse = true
    listChar[pair.close].isUse = true
    dfs(listChar, bracketPairs, indexBracketPair + 1, set, result)
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val str = reader.readLine();
    val listChar = str.map { UseChar(value = it, isUse = true) }
    val bracketPairs = findBracketPairs(listChar)
    val result = mutableListOf<String>();

    dfs(listChar, bracketPairs, 0, mutableSetOf<String>(), result)

    result.filter { it != str }.sorted().forEach {
        writer.write("$it\n")
    }

    writer.flush()
    reader.close()
    writer.close()
}
