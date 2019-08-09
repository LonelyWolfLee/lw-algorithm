package utils

fun <T> checkValue(actual: T, expected: T) {
    if (actual != expected) {
        throw Throwable("Expected value: $expected, Actual value: $actual")
    }
}

fun checkIntArray(actual: IntArray, expected: IntArray) {
    actual.forEachIndexed { index, i ->
        if (i != expected[index])
            throw Throwable("Expected value: ${expected.asList()}, Actual value: ${actual.asList()}")
    }
}