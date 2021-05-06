package com.ghostapps.placapp.data.records.remote.useCases

import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.domain.useCases.GetAllRegister
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.awaitAll

class GetAllFirestoreRegister()
    : GetAllRegister {
    override fun execute(successCallback: (recordList: Array<RecordModel>) -> Unit) {
        val recordModelList = arrayListOf<RecordModel>()

        Firebase.firestore
            .collection("placappscores")
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    recordModelList.add(document.toObject(RecordModel::class.java))
                }
                successCallback(recordModelList.toArray(arrayOfNulls<RecordModel>(0)))
            }
    }

    override fun execute() {
        TODO("Not yet implemented")
    }
}