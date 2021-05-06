package com.ghostapps.placapp

import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.domain.useCases.InsertRegister
import com.ghostapps.placapp.viewModel.gameScore.GameScoreContract
import com.ghostapps.placapp.viewModel.gameScore.GameScoreViewModel
import com.nhaarman.mockito_kotlin.*
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.util.*

class GameScoreViewModelTest {
    private val gameScoreContractMock: GameScoreContract = mock {}
    private val insertRegisterMock: InsertRegister = mock {
        given { it.execute(any()) }.willReturn { true }
    }

    private lateinit var sut: GameScoreViewModel

    @Before
    fun initialize() {
        sut = GameScoreViewModel(gameScoreContractMock, insertRegisterMock)
    }

    @Test
    fun `Should update players names correctly`() {
        val player1Name = "Player 1"
        val player2Name = "Player 2"

        sut.onCreate(player1Name, player2Name)

        assertEquals(sut.homePlayerName, player1Name)
        assertEquals(sut.awayPlayerName, player2Name)
    }

    @Test
    fun `Should increase home player score when onScoreHomeIncreaseOne is Called`() {
        sut.onScoreHomeIncreaseOne()
        assertEquals(sut.formattedHomePlayerScore, "01")

        sut.onScoreHomeIncreaseOne()
        assertEquals(sut.formattedHomePlayerScore, "02")

        assertEquals(sut.formattedNumberOfTrucoOneHome, "02")
    }

    @Test
    fun `Should increase home player score when onScoreHomeIncreaseThree is Called`() {
        sut.onScoreHomeIncreaseThree()
        assertEquals(sut.formattedHomePlayerScore, "03")

        sut.onScoreHomeIncreaseThree()
        assertEquals(sut.formattedHomePlayerScore, "06")

        assertEquals(sut.formattedNumberOfTrucoThreeHome, "02")
    }

    @Test
    fun `Should increase away player score when onScoreAwayIncreaseOne is Called`() {
        sut.onScoreAwayIncreaseOne()
        assertEquals(sut.formattedAwayPlayerScore, "01")

        sut.onScoreAwayIncreaseOne()
        assertEquals(sut.formattedAwayPlayerScore, "02")

        assertEquals(sut.formattedNumberOfTrucoOneAway, "02")
    }

    @Test
    fun `Should increase away player score when onScoreAwayIncreaseThree is Called`() {
        sut.onScoreAwayIncreaseThree()
        assertEquals(sut.formattedAwayPlayerScore, "03")

        sut.onScoreAwayIncreaseThree()
        assertEquals(sut.formattedAwayPlayerScore, "06")

        assertEquals(sut.formattedNumberOfTrucoThreeAway, "02")
    }

    @Test
    fun `Should execute onExitPressed, insertRegister and exit`() {
        sut.onExitPressed()
        verify(insertRegisterMock, times(1)).execute(any())
        verify(gameScoreContractMock, times(1)).onExitPressed()
        verify(gameScoreContractMock, times(0)).onInsertRegisterFails()
    }
}