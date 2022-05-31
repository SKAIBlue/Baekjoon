import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * 탑
 * 문제 링크: https://www.acmicpc.net/problem/2493
 */

data class Circle (
    val x: Int,
    val index: Int,
    val isLeft: Boolean,
) : Comparable<Circle> {
    override fun compareTo(other: Circle): Int {
        return x.compareTo(other.x)
    }
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val N = reader.readLine().toInt()

    val queue = TreeSet<Circle>();
    val stack = Stack<Circle>()

    repeat(N) {
        val tokenizer = StringTokenizer(reader.readLine())
        val x = tokenizer.nextToken().toInt()
        val r = tokenizer.nextToken().toInt()

        queue.add(Circle(x - r, it, true))
        queue.add(Circle(x + r, it, false))
    }

    var isMatched = true

    queue.forEach {
        if(it.isLeft) {
            stack.add(it)
        } else {
            val pop = if(stack.isEmpty()) null else stack.pop()
            if(pop?.index != it.index) {
                isMatched = false
                return@forEach
            }
        }
    }

    writer.write(if(isMatched && stack.isEmpty()) "YES" else "NO")
    writer.flush()

    reader.close()
    writer.close()
}
