package com.perqin.turbo9search

/**
 * Launch-able application.
 * @author perqin
 */
class App(
        var matchableStrings: List<MatchableString> = emptyList()
) {
    // TODO: Frequency should be in range [0,9] calculated by open rate.
    val frequency = 0

    data class MatchableString(val string: String, val weight: Int)
}
