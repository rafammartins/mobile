package com.ghostapps.placapp.data.records.remote.useCases

import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.domain.useCases.DeleteRegister
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class DeleteFirestoreRegister() : DeleteRegister {
    override fun execute(recordModel: RecordModel) {
        Firebase.firestore
            .collection("placappscores")
            .document(recordModel.date.toString())
            .delete()
            .addOnFailureListener {
                println("Erro ao excluir item")
            }
    }
}