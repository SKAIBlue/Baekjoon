/**
 * 쇠막대기
 * 문제 링크: https://www.acmicpc.net/problem/10799
 */

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val sticks = reader.readLine();
    var stackSize = 0
    var count = 0
    var i = 0
    while(i < sticks.length) {
        val l = sticks[i]
        val r = sticks.getOrNull(i + 1)

        if(l == '(' && r == ')') {
            count += stackSize
            i += 2
        } else if(l == '(') {
            stackSize += 1
            ++i
        } else if(l == ')') {
            stackSize -= 1
            count += 1
            ++i
        }
    }

    writer.write("${count}")
    writer.flush()

    reader.close()
    writer.close()
}


