import java.io.File

fun tokenize(text: String): List<String> {
    return Regex("[A-Za-z0-9]+").findAll(text.lowercase()).map { it.value }.toList()
}

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        System.err.println("usage: kotlin Main.kt <path> [--top N]")
        return
    }
    var top = 10
    var path: String? = null
    var i = 0
    while (i < args.size) {
        when (args[i]) {
            "--top" -> {
                if (i + 1 < args.size) top = args[i + 1].toInt()
                i += 2
            }
            else -> {
                if (path == null) path = args[i]
                i += 1
            }
        }
    }
    val text = File(path!!).readText()
    val lines = if (text.isEmpty()) 0 else text.count { it == '\n' } + 1
    val words = tokenize(text)
    val counts = mutableMapOf<String, Int>()
    for (w in words) counts[w] = (counts[w] ?: 0) + 1

    val sorted = counts.entries.sortedWith(compareByDescending<Map.Entry<String, Int>> { it.value }.thenBy { it.key })

    println("lines: $lines")
    println("words: ${words.size}")
    println("chars: ${text.length}")
    println("top words:")
    for (e in sorted.take(top)) {
        println("  ${e.key}: ${e.value}")
    }
}
