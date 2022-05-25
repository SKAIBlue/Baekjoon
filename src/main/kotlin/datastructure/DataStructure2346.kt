/**
 * 풍선 터뜨리기
 * 문제 링크: https://www.acmicpc.net/problem/2346
 */

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.StringTokenizer

data class Balloon (
    val moveTo: Int,
    val index: Int,
)

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val tokenizer = StringTokenizer(reader.readLine())
    val list = LinkedList<Balloon>()
    val removeOrder = mutableListOf<Int>()

    repeat(n) {
        list.add(Balloon(
            moveTo = tokenizer.nextToken().toInt(),
            index = it + 1
        ))
    }

    var index = 0

    while (true) {
        val balloon = list.removeAt(index)
        removeOrder.add(balloon.index)
        if(list.size == 0) {
            break;
        }
        index = if (balloon.moveTo > 0) {
            (index + (balloon.moveTo - 1)) % list.size
        } else {
            (index + (balloon.moveTo % list.size) + list.size) % list.size
        }
    }

    writer.write(removeOrder.joinToString(" "))
    writer.flush()
    reader.close()
    writer.close()
}
