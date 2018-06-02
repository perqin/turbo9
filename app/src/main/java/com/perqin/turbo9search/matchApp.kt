package com.perqin.turbo9search

/**
 * @author perqin
 */

fun matchApp(app: App, query: String): Query.Result {
    if (query == "") {
        return Query.Result(app, "", "", emptyArray(), app.frequency)
    } else {
        val result = app.matchableStrings
                .map {
                    // Calculate score: matchScore * weight * 10 + frequency
                    var indices = emptyArray<Int>()
                    var score = 0
                    var im = 0
                    for (iq in query.indices) {
                        while (im < it.string.length) {
                            // Does `query[iq]` match `it.string[im]`? (0, 1, 2)
                            val matched = matchT9(query[iq], it.string[im])
                            if (matched > 0) {
                                indices += im
                                score += if (matched == 2) 10 else 1
                                im += 1
                                break
                            } else {
                                im += 1
                            }
                        }
                    }
                    if (indices.size == query.length) {
                        // Matched
                        Query.Result(app, query, it.string, indices, score * it.weight * 10 + app.frequency)
                    } else {
                        null
                    }
                }
                .filterNotNull()
                .maxBy { it.score }
        return result?: Query.Result(app, query, "", emptyArray(), -1)
    }
}

private val T9 = arrayOf(
        2, 2, 2, 3, 3, 3,
        4, 4, 4, 5, 5, 5, 6, 6, 6,
        7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9
)

private fun matchT9(number: Char, char: Char) : Int {
    val num = number.toInt() - '0'.toInt()
    return if (char in '0'..'9') {
        if (num == char.toInt() + '0'.toInt()) 2 else 0
    } else if (char in 'A'..'Z') {
        if (num == T9[char.toInt() - 'A'.toInt()]) 2 else 0
    } else if (char in 'a'..'z') {
        if (num == T9[char.toInt() - 'a'.toInt()]) 1 else 0
    } else {
        0
    }
}