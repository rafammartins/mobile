package com.ghostapps.placapp.ui.gameRecords.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ghostapps.placapp.domain.models.RecordModel
import kotlinx.android.synthetic.main.item_game_record.view.*

class RecordsListViewHolder(
    itemView: View,
    private val onDeletePressed: (recordModel: RecordModel) -> Unit
): RecyclerView.ViewHolder(itemView) {
    fun bind(recordModel: RecordModel) {
        itemView.itemGameRecordHomePlayerName.text = recordModel.homePlayerName
        itemView.itemGameRecordHomePlayerScore.text = (recordModel.trucoOfOneHome + recordModel.trucoOfThreeHome * 3).toString()

        itemView.itemGameRecordHomeTrucoOfOne.text = recordModel.trucoOfOneHome.toString()
        itemView.itemGameRecordHomeTrucoOfThree.text = recordModel.trucoOfThreeHome.toString()


        itemView.itemGameRecordAwayPlayerName.text = recordModel.awayPlayerName
        itemView.itemGameRecordAwayPlayerScore.text = (recordModel.trucoOfOneAway + recordModel.trucoOfThreeAway * 3).toString()

        itemView.itemGameRecordAwayTrucoOfOne.text = recordModel.trucoOfOneAway.toString()
        itemView.itemGameRecordAwayTrucoOfThree.text = recordModel.trucoOfThreeAway.toString()

        itemView.itemGameRecordDelete.setOnClickListener {
            onDeletePressed(recordModel)
        }
    }
}