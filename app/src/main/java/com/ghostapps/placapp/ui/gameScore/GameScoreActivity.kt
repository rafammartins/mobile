package com.ghostapps.placapp.ui.gameScore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ghostapps.placapp.R
import com.ghostapps.placapp.databinding.ActivityScoreGameBinding
import com.ghostapps.placapp.viewModel.gameScore.GameScoreContract
import com.ghostapps.placapp.viewModel.gameScore.GameScoreViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import java.lang.Exception

class GameScoreActivity: AppCompatActivity(), GameScoreContract {

    companion object {
        const val PLAYER_HOME_NAME = "home_player_name"
        const val PLAYER_AWAY_NAME = "away_player_name"
    }

    private lateinit var binding: ActivityScoreGameBinding
    private val viewModel: GameScoreViewModel by viewModel { parametersOf(this)  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_score_game)
        binding.viewModel = viewModel

        viewModel.onCreate(intent.getStringExtra(PLAYER_HOME_NAME) ?: "", intent.getStringExtra(PLAYER_AWAY_NAME) ?: "")
    }

    override fun onExitPressed() {
        finish()
    }

    override fun onInsertRegisterFails() {
        throw Exception("Erro ao inserir o registro!")
    }
}