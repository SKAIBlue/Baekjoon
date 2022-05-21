/**
 * 스택 수열
 * https://www.acmicpc.net/problem/1874
 */
package datastructure

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
    val stack = LinkedList<Int>()
    val commands = mutableListOf<String>()

    repeat((0 until n).count()) {
        list.add(reader.readLine().toInt())
    }

    var i = 1
    stack.add(i++)
    commands.add("+")

    while (true) {
        if(list.isEmpty() || i > n + 1) {
            commands.forEach {
                writer.write("$it\n")
            }
            writer.flush()
            reader.close()
            writer.close()
            return
        }
        if(stack.isEmpty()) {
            stack.push(i++)
            commands.add("+")
        }

        if (list.first < stack.last) {
            writer.write("NO")
            writer.flush()
            reader.close()
            writer.close()
            return
        } else if(list.first > stack.last) {
            stack.add(i++)
            commands.add("+")
        } else {
            list.removeFirst()
            stack.removeLast()
            commands.add("-")
        }
    }
}
