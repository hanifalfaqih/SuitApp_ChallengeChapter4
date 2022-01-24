package com.allana.suitapp_challengechapter4.presentation

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.allana.suitapp_challengechapter4.R
import com.allana.suitapp_challengechapter4.databinding.ActivityGameBinding
import com.allana.suitapp_challengechapter4.enum.DecideWinner
import com.allana.suitapp_challengechapter4.enum.Suit

class GameActivity : AppCompatActivity() {

    companion object {
        const val TAG = "Game Activity"
    }

    private lateinit var binding: ActivityGameBinding
    private lateinit var viewModel: GameViewModel

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialize()
        setClickPlayerOptions()
    }

    private fun initialize() {
        supportActionBar?.hide()
        viewModel = GameViewModel()
    }

    private fun setClickPlayerOptions() {
        binding.flRockLeft.setOnClickListener {
            binding.flPaperLeft.setBackgroundColor(0)
            binding.flScissorLeft.setBackgroundColor(0)
            binding.flRockLeft.setBackgroundResource(R.drawable.bg_blue_corner_8dp)
            processGameWinner(Suit.ROCK, viewModel.handlePickComputer())
        }
        binding.flPaperLeft.setOnClickListener {
            binding.flPaperLeft.setBackgroundResource(R.drawable.bg_blue_corner_8dp)
            binding.flScissorLeft.setBackgroundColor(0)
            binding.flRockLeft.setBackgroundColor(0)
            processGameWinner(Suit.PAPER, viewModel.handlePickComputer())
        }
        binding.flScissorLeft.setOnClickListener {
            binding.flPaperLeft.setBackgroundColor(0)
            binding.flScissorLeft.setBackgroundResource(R.drawable.bg_blue_corner_8dp)
            binding.flRockLeft.setBackgroundColor(0)
            processGameWinner(Suit.SCISSOR, viewModel.handlePickComputer())
        }
        binding.btnReset.setOnClickListener {
            setClickPlayerOptions()
            binding.flPaperLeft.setBackgroundColor(0)
            binding.flScissorLeft.setBackgroundColor(0)
            binding.flRockLeft.setBackgroundColor(0)
            binding.flPaperRight.setBackgroundColor(0)
            binding.flScissorRight.setBackgroundColor(0)
            binding.flRockRight.setBackgroundColor(0)
            binding.tvWinner.text = getString(R.string.text_start)
        }
    }

    private fun processGameWinner(player: Suit, computer: Suit) {
        setColorButtonComputer(computer)
        resultGameWinner(viewModel.getWinner(player, computer))
    }

    private fun resultGameWinner(result: DecideWinner) {
        when (result) {
            DecideWinner.PLAYER -> {
                binding.tvWinner.text = getString(R.string.text_player_win)
                Log.d(TAG, "Winner -> Player")
                binding.flPaperLeft.setOnClickListener(null)
                binding.flScissorLeft.setOnClickListener(null)
                binding.flRockLeft.setOnClickListener(null)
            }
            DecideWinner.COMPUTER -> {
                binding.tvWinner.text = getString(R.string.text_computer_win)
                Log.d(TAG, "Winner -> Computer")
                binding.flPaperLeft.setOnClickListener(null)
                binding.flScissorLeft.setOnClickListener(null)
                binding.flRockLeft.setOnClickListener(null)
            }
            DecideWinner.DRAW -> {
                binding.tvWinner.text = getString(R.string.text_draw)
                Log.d(TAG, "Draw")
                binding.flPaperLeft.setOnClickListener(null)
                binding.flScissorLeft.setOnClickListener(null)
                binding.flRockLeft.setOnClickListener(null)
            }
        }
    }

    private fun setColorButtonComputer(computer: Suit) {
        when (computer) {
            Suit.ROCK -> {
                binding.flPaperRight.setBackgroundColor(0)
                binding.flScissorRight.setBackgroundColor(0)
                binding.flRockRight.setBackgroundResource(R.drawable.bg_blue_corner_8dp)
            }
            Suit.PAPER -> {
                binding.flPaperRight.setBackgroundResource(R.drawable.bg_blue_corner_8dp)
                binding.flScissorRight.setBackgroundColor(0)
                binding.flRockRight.setBackgroundColor(0)
            }
            else -> {
                binding.flPaperRight.setBackgroundColor(0)
                binding.flScissorRight.setBackgroundResource(R.drawable.bg_blue_corner_8dp)
                binding.flRockRight.setBackgroundColor(0)
            }
        }
    }
}