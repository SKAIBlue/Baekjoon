/**
 * 카드2
 * 문제 링크: https://www.acmicpc.net/problem/2164
 */

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val list = LinkedList<Int>()
    (1..n).forEach { list.add(it) }

    var i = 0
    while(list.size != 1) {
        if(i % 2== 0) {
           list.removeFirst()
        } else {
            val first = list.first
            list.removeFirst()
            list.add(first)
        }
        i += 1;
    }

    writer.write("${list.first}")
    writer.flush()
}

