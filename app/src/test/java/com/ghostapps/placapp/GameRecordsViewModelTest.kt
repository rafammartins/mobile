package com.ghostapps.placapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.domain.useCases.DeleteRegister
import com.ghostapps.placapp.domain.useCases.GetAllRegister
import com.ghostapps.placapp.viewModel.gameRecords.GameRecordsViewModel
import com.nhaarman.mockito_kotlin.*
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.util.*

class GameRecordsViewModelTest {

    private val recordModel = RecordModel(
        homePlayerName = "Player A",
        awayPlayerName = "Player B",
        trucoOfOneHome = 1,
        trucoOfThreeHome = 1,
        trucoOfOneAway = 1,
        trucoOfThreeAway = 1,
        date = Date().time
    )
    private val deleteRegisterMock: DeleteRegister = mock ()
    private val getAllRegisterMock: GetAllRegister = mock {
        given { it.execute()}.willReturn { Array<RecordModel>( 1) {recordModel} }
    }

    private lateinit var recordTest: GameRecordsViewModel

    @Before
    fun initialize() {
        recordTest = GameRecordsViewModel(getAllRegisterMock, deleteRegisterMock)
    }

    @Test
    fun `Should execute loadRecords`() {
        recordTest.loadRecords()
        verify(getAllRegisterMock, times(1)).execute()
    }

    @Test
    fun `Should execute deleteRegister`() {
        recordTest.deleteRegister(recordModel)
        //verify(deleteRegisterMock, times(1)).execute(recordModel)
        verify(deleteRegisterMock, times(1)).execute(recordModel)
    }
}


