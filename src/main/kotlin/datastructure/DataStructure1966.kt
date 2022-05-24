/**
 * 프린터 큐
 * 문제 링크: https://www.acmicpc.net/problem/1966
 */

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

data class Document (
    val index: Int = 0,
    val priority: Int = 0
): Comparable<Document> {
    override fun compareTo(other: Document): Int {
        return other.priority.compareTo(priority)
    }
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val caseCount = reader.readLine().toInt()

    repeat(caseCount) {
        val tokenizer = StringTokenizer(reader.readLine())
        val n = tokenizer.nextToken().toInt()
        val m = tokenizer.nextToken().toInt()

        val priorityQueue = PriorityQueue<Document>()
        val queue = LinkedList<Document>()

        val strDocumentsPriorities = StringTokenizer(reader.readLine())

        repeat(n) {
            val doc = Document(it, strDocumentsPriorities.nextToken().toInt())
            queue.add(doc)
            priorityQueue.add(doc)
        }

        var index = 0

        while(!queue.isEmpty()) {
            val pFirst = priorityQueue.first()
            val first = queue.first

            if (pFirst.priority == first.priority) {
                if(m == first.index) {
                    break
                }
                priorityQueue.remove(pFirst)
                queue.removeFirst()
                index += 1
            } else {
                queue.removeFirst()
                queue.add(first)
            }
        }

        writer.write("${index + 1}\n")
    }

    writer.flush()

    reader.close()
    writer.close()
}

