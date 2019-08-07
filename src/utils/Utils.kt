package utils

fun <T> checkValue(actual: T, expected:T) {
    if (actual != expected) {
        throw Throwable("Expected value: $expected, Actual value: $actual")
    }
}