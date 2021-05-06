package com.ghostapps.placapp.data.records

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ghostapps.placapp.domain.models.RecordModel
import com.google.gson.annotations.SerializedName
import com.google.firebase.*

@Entity(tableName = RecordEntity.TABLE_NAME)
class RecordEntity(
    val homePlayerName: String,
    val awayPlayerName: String,
    val trucoOfOneHome: Int,
    val trucoOfThreeHome: Int,
    val trucoOfOneAway: Int,
    val trucoOfThreeAway: Int,

    @PrimaryKey
    val date: Long
) {
    companion object {
        const val TABLE_NAME = "records_database"

        fun fromModel(recordModel: RecordModel): RecordEntity {
            return RecordEntity(
                homePlayerName = recordModel.homePlayerName,
                awayPlayerName = recordModel.awayPlayerName,
                trucoOfOneHome = recordModel.trucoOfOneHome,
                trucoOfThreeHome = recordModel.trucoOfThreeHome,
                trucoOfOneAway = recordModel.trucoOfOneAway,
                trucoOfThreeAway = recordModel.trucoOfThreeAway,
                date = recordModel.date
            )
        }
    }

    fun toModel(): RecordModel {
        return RecordModel(
            homePlayerName = homePlayerName,
            awayPlayerName = awayPlayerName,
            trucoOfOneHome = trucoOfOneHome,
            trucoOfThreeHome = trucoOfThreeHome,
            trucoOfOneAway = trucoOfOneAway,
            trucoOfThreeAway = trucoOfThreeAway,
            date = date
        )
    }
}