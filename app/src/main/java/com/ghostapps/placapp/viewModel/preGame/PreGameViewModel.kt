package com.ghostapps.placapp.viewModel.preGame

import androidx.lifecycle.ViewModel

class PreGameViewModel (
    private val contract: PreGameContract
) : ViewModel() {
    var homePlayerName = ""
    var awayPlayerName = ""

    fun onStartGamePressed() {
        contract.gotToGame()
    }
}