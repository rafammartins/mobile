package com.ghostapps.placapp.viewModel.gameRecords

import android.telecom.CallRedirectionService
import androidx.lifecycle.MutableLiveData
import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.domain.useCases.DeleteRegister
import com.ghostapps.placapp.domain.useCases.GetAllRegister
import com.ghostapps.placapp.viewModel.BaseViewModel
import kotlin.concurrent.thread

class GameRecordsViewModel(
    private val getAllRegister: GetAllRegister,
    private val deleteRegister: DeleteRegister
) : BaseViewModel() {
    val recordList = MutableLiveData<Array<RecordModel>>()

    fun loadRecords() {
        getAllRegister.execute(
            successCallback = { recordList ->
                this.recordList.postValue(recordList)
            }
        )
    }

    fun deleteRegister(recordModel: RecordModel) {
        Thread {
            deleteRegister.execute(recordModel)
            loadRecords()
        }.start()
    }
}