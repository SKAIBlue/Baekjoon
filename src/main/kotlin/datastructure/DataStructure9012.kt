fun main() {
    val n = readln().toInt()

    (0 until n).forEach { _ ->
        val line = readln()
        val stack = mutableListOf<Char>()
        var isPs = true;

        line.forEach { c ->
            when (c) {
                '(' -> {
                    stack.add('(')
                }
                ')' -> {
                    if(stack.size == 0 ) {
                        isPs = false
                        return@forEach
                    }
                    stack.removeLast()
                }
            }
        }

        if(isPs && stack.isEmpty()) {
            println("YES")
        } else {
            println("NO")
        }
    }
}
