package com.ghostapps.placapp.viewModel.gameScore

import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.domain.useCases.InsertRegister
import com.ghostapps.placapp.viewModel.BaseViewModel
import java.util.*

class GameScoreViewModel(
    private val contract: GameScoreContract,
    private val insertRegister: InsertRegister
) : BaseViewModel() {

    var homePlayerName = ""
    var awayPlayerName = ""

    var formattedHomePlayerScore = "00"
    var formattedAwayPlayerScore = "00"

    var formattedNumberOfTrucoOneHome = "00"
    var formattedNumberOfTrucoThreeHome = "00"

    var formattedNumberOfTrucoOneAway = "00"
    var formattedNumberOfTrucoThreeAway = "00"

    var trucoOfOneHome = 0
    var trucoOfThreeHome = 0

    var trucoOfOneAway = 0
    var trucoOfThreeAway = 0

    fun onCreate(homePlayerName: String, awayPlayerName: String) {
        this.homePlayerName = homePlayerName
        this.awayPlayerName = awayPlayerName
    }

    fun onScoreHomeIncreaseOne() {
        trucoOfOneHome++
        updateScore()
    }

    fun onScoreHomeIncreaseThree() {
        trucoOfThreeHome++
        updateScore()
    }

    fun onScoreAwayIncreaseOne() {
        trucoOfOneAway++
        updateScore()
    }

    fun onScoreAwayIncreaseThree() {
        trucoOfThreeAway++
        updateScore()
    }

    fun onExitPressed() {
        Thread {
            val success = insertRegister.execute(RecordModel(
                    homePlayerName = homePlayerName,
                    awayPlayerName = awayPlayerName,
                    trucoOfOneHome = trucoOfOneHome,
                    trucoOfThreeHome = trucoOfThreeHome,
                    trucoOfOneAway = trucoOfOneAway,
                    trucoOfThreeAway = trucoOfThreeAway,
                    date = Date().time
            ))
            if (success) {
                contract.onExitPressed()
            }
            else {
                contract.onInsertRegisterFails()
            }
        }.start()
    }


    private fun updateScore() {
        formattedHomePlayerScore = String.format("%02d", trucoOfOneHome + trucoOfThreeHome * 3)
        formattedAwayPlayerScore = String.format("%02d", trucoOfOneAway + trucoOfThreeAway * 3)

        formattedNumberOfTrucoOneHome = String.format("%02d", trucoOfOneHome)
        formattedNumberOfTrucoThreeHome = String.format("%02d", trucoOfThreeHome)

        formattedNumberOfTrucoOneAway = String.format("%02d", trucoOfOneAway)
        formattedNumberOfTrucoThreeAway = String.format("%02d", trucoOfThreeAway)

        notifyChange()
    }
}