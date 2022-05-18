/**
 * 큐 2
 * 문제 링크: https://www.acmicpc.net/problem/18258
 */
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class SimpleQueue(size: Int) {
    private val values: Array<Int?>
    private var right = 0
    private var left = 0

    init {
        values = arrayOfNulls<Int>(size)
    }

    fun enqueue(value: Int) {
        values[right++] = value
    }

    fun dequeue(): Int {
        return if (isEmpty) {
            -1
        } else {
            values[left++]!!
        }
    }

    val first: Int
        get() {
            if(isEmpty) {
                return -1
            }
            return values[left]!!
        }

    val last: Int
        get() {
            if(isEmpty) {
                return -1
            }
            return values[right - 1]!!
        }

    val isEmpty: Boolean
        get() {
            return (right - left) == 0
        }

    val size: Int
        get() {
            return right - left
        }
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`));
    val writer = BufferedWriter(OutputStreamWriter(System.out));

    val n = reader.readLine().toInt()
    val queue = SimpleQueue(n)

    val commandMap = mutableMapOf<String, (value: Int?) -> Unit>(
        "push" to {
            queue.enqueue(it!!)
        },
        "pop" to {
            writer.write("${queue.dequeue()}\n")
        },
        "size" to {
            writer.write("${queue.size}\n")
        },
        "empty" to {
            if(queue.isEmpty) {
                writer.write("${1}\n")
            } else {
                writer.write("${0}\n")
            }
        },
        "front" to {
            writer.write("${queue.first}\n")
        },
        "back" to {
            writer.write("${queue.last}\n")
        }
    )

    for (i in 0 until n) {
        val input = reader.readLine();
        val split = input.split(' ')
        commandMap[split[0]]?.invoke(split.getOrNull(1)?.toInt())
    }
    writer.flush();
    reader.close()
    writer.close()
}
