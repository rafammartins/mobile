package com.ghostapps.placapp.domain.models

class RecordModel (
    var homePlayerName: String,
    var trucoOfOneHome: Int,
    var trucoOfThreeHome: Int,

    var awayPlayerName: String,
    var trucoOfOneAway: Int,
    var trucoOfThreeAway: Int,

    val date: Long
)
{
    constructor() : this(
        homePlayerName = "",
        trucoOfOneHome = 0,
        trucoOfThreeHome = 0,

        awayPlayerName = "",
        trucoOfOneAway = 0,
        trucoOfThreeAway = 0,
        date = 0
    )
}