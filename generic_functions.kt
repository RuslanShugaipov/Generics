import java.util.*

fun <T> Collection<T>.partitionTo(
    collectionA: MutableCollection<T>,
    collectionB: MutableCollection<T>,
    predicate: (T) -> Boolean
): Pair<MutableCollection<T>, MutableCollection<T>> {
    for (element in this) {
        if (predicate(element)) {
            collectionA.add(element)
        } else {
            collectionB.add(element)
        }
    }
    return Pair(collectionA, collectionB)
}


fun partitionWordsAndLines() {
    val (words, lines) = listOf("a", "a b", "c", "d e")
            .partitionTo(ArrayList(), ArrayList()) { s -> !s.contains(" ") }
    check(words == listOf("a", "c"))
    check(lines == listOf("a b", "d e"))
}

fun partitionLettersAndOtherSymbols() {
    val (letters, other) = setOf('a', '%', 'r', '}')
            .partitionTo(HashSet(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z' }
    check(letters == setOf('a', 'r'))
    check(other == setOf('%', '}'))
}
