/**
 * 스택
 * 문제 링크: https://www.acmicpc.net/problem/10828
 */

fun main() {
    val n = readln().toInt()
    val stack = mutableListOf<Int>()

    for (i in 0 until n) {
        val input = readln();
        val split = input.split(' ')

        when (split[0]) {
            "push" -> {
                stack.add(split[1].toInt())
            }
            "pop" -> {
                if(stack.isEmpty()) {
                    println(-1);
                    continue
                }
                println(stack[stack.size - 1])
                stack.removeLast()
            }
            "size" -> {
                println(stack.size)
            }
            "empty" -> {
                if(stack.isEmpty()) {
                    println(1)
                } else {
                    println(0)
                }
            }
            "top" -> {
                if(stack.isEmpty()) {
                    println(-1);
                    continue
                }
                println(stack[stack.size - 1])
            }
        }
    }
}
