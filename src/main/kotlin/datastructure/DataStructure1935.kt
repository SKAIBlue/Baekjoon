import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import javax.xml.stream.events.Characters

/**
 * 후위 표기식2
 * 문제 링크: https://www.acmicpc.net/problem/1935
 */

fun <T> LinkedList<T>.popLast(): T {
    try {
        return this.last
    } finally {
        this.removeLast()
    }
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val values = mutableMapOf<Char, Int>()
    val stack = LinkedList<Any>()

    val expression = reader.readLine()

    (0 until n).forEach {
        val value = reader.readLine().toInt()
        values['A' + it] = value
    }

    expression.forEach {
        if(it in 'A'..'Z') {
            stack.add(values[it]!!.toDouble())
            return@forEach
        }

        when(it) {
            '+' -> {
                val b = stack.popLast() as Double
                val a = stack.popLast() as Double
                stack.add(a + b)
            }
            '-' -> {
                val b = stack.popLast() as Double
                val a = stack.popLast() as Double
                stack.add(a - b)
            }
            '/' -> {
                val b = stack.popLast() as Double
                val a = stack.popLast() as Double
                stack.add(a / b)
            }
            '*' -> {
                val b = stack.popLast() as Double
                val a = stack.popLast() as Double
                stack.add(a * b)
            }
        }
    }

    writer.write(String.format("%.2f\n", stack.pop()))
    writer.flush()

    reader.close()
    writer.close()
}
