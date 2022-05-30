import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * 탑
 * 문제 링크: https://www.acmicpc.net/problem/2493
 */

data class Pair (
    var first: Int,
    var second: Int,
)

class PairPool {
    private val pool = LinkedList<Pair>()

    fun createPair(first: Int, second: Int): Pair {
        return if(pool.isEmpty()) {
            Pair(first, second)
        } else {
            val data = pool.removeFirst()
            data.first = first
            data.second = second
            data
        }
    }

    fun release(pair: Pair) {
        pool.add(pair)
    }
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()

    val receive = LinkedList<Int>()
    val stack = Stack<Pair>()
    val pool = PairPool()
    val tokenizer = StringTokenizer(reader.readLine())

    stack.push(pool.createPair(tokenizer.nextToken().toInt(), 1))

    var i = 0
    while(i <= n) {
        val number = tokenizer.nextToken().toInt()

        while(true) {
            if(stack.isEmpty()) {
                stack.push(pool.createPair(number, i))
                break
            } else if (stack.peek().first < number){
                pool.release(stack.pop())
            } else {
                receive.add(stack.peek().second)
                stack.push(pool.createPair(number, i))
            }
        }
        i+=1
    }

    writer.write(receive.joinToString(" "))

    writer.flush()
    reader.close()
    writer.close()
}
