/**
 * 덱
 * 문제 링크: https://www.acmicpc.net/problem/10866
 */

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`));
    val writer = BufferedWriter(OutputStreamWriter(System.out));

    val n = reader.readLine().toInt()
    val dequeue = LinkedList<Int>()

    val commandMap = mutableMapOf<String, (value: Int?) -> Unit>(
        "push_front" to {
            dequeue.addFirst(it!!)
        },
        "push_back" to {
            dequeue.addLast(it!!)
        },
        "pop_front" to {
            if(dequeue.isEmpty()) {
                writer.write("${-1}\n")
            } else {
                writer.write("${dequeue.first}\n")
                dequeue.removeFirst()
            }
        },
        "pop_back" to {
            if(dequeue.isEmpty()) {
                writer.write("${-1}\n")
            } else {
                writer.write("${dequeue.last}\n")
                dequeue.removeLast()
            }
        },
        "size" to {
            writer.write("${dequeue.size}\n")
        },
        "empty" to {
            if(dequeue.isEmpty()) {
                writer.write("${1}\n")
            } else {
                writer.write("${0}\n")
            }
        },
        "front" to {
            if(dequeue.isEmpty()) {
                writer.write("${-1}\n")
            } else {
                writer.write("${dequeue.first}\n")
            }
        },
        "back" to {
            if(dequeue.isEmpty()) {
                writer.write("${-1}\n")
            } else {
                writer.write("${dequeue.last}\n")
            }
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
