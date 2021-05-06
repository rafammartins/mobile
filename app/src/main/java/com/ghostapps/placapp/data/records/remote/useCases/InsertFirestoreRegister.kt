package com.ghostapps.placapp.data.records.remote.useCases

import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.domain.useCases.InsertRegister
import com.google.firebase.ktx.Firebase
import com.google.firebase.firestore.ktx.firestore

class InsertFirestoreRegister()
    :InsertRegister  {
    override fun execute(recordModel: RecordModel): Boolean {
        Firebase.firestore
            .collection("placappscores")
            .document(recordModel.date.toString())
            .set(recordModel)
            .addOnFailureListener {
                println("Falha ao inserir os dados")
            }
        return true
    }
}
