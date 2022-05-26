import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList

/**
 * 괄호의 값
 * 문제 링크: https://www.acmicpc.net/problem/2504
 */

fun <T> LinkedList<T>.lastOrNull(): T? {
    return if(this.size == 0) null else this.last
}

fun calculate(str: String): Int {
    val list = LinkedList<Any>()

    str.forEach {
        when(it) {
            '(' -> {
                list.add('(')
            }
            '[' -> {
                list.add('[')
            }
            ')' -> {
                if(list.lastOrNull() == '(') {
                    list.removeLast()
                    if(list.lastOrNull() is Int) {
                        val last2 = list.removeLast() as Int
                        list.add(last2 + 2)
                    } else {
                        list.add(2)
                    }
                } else if(list.lastOrNull() is Int && list.getOrNull(list.size - 2) == '('){
                    val last = list.removeLast() as Int
                    list.removeLast()

                    if(list.lastOrNull() is Int) {
                        val last2 = list.removeLast() as Int
                        list.add(last2 + (last * 2))
                    } else {
                        list.add(last * 2)
                    }
                } else {
                    return 0
                }
            }
            ']' -> {
                if(list.lastOrNull() == '[') {
                    list.removeLast()
                    if(list.lastOrNull() is Int) {
                        val last2 = list.removeLast() as Int
                        list.add(last2 + 3)
                    } else {
                        list.add(3)
                    }
                } else if(list.lastOrNull() is Int && list.getOrNull(list.size - 2) == '['){
                    val last = list.removeLast() as Int
                    list.removeLast()

                    if(list.lastOrNull() is Int) {
                        val last2 = list.removeLast() as Int
                        list.add(last2 + (last * 3))
                    } else {
                        list.add(last * 3)
                    }

                } else {
                    return 0
                }
            }
        }
    }

    if(list.size != 1) {
        return 0
    }

    return if(list.last is Int) list.last as Int else 0
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    writer.write("${calculate(reader.readLine())}")
    writer.flush()

    reader.close()
    writer.close()
}
