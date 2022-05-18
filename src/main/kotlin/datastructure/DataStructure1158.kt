import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 요세푸스 문제
 * 문제 링크: https://www.acmicpc.net/problem/1158
 */

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    // 입력
    val nk = reader.readLine().split(" ")
    val n = nk[0].toInt()
    val k = nk[1].toInt() - 1

    val list = (1..n).map { it.toInt() }.toMutableList()
    var listIndex = k % list.size

    val results = arrayOfNulls<Int>(n)
    var resultsIndex = 0

    while(true) {
        results[resultsIndex++] = list[listIndex]
        list.removeAt(listIndex)

        if(list.size == 0) {
            break
        }

        listIndex = (listIndex + k) % list.size
    }

    writer.write("<${results.toList().joinToString(", ")}>")
    writer.flush()
    reader.close()
    writer.close()
}
