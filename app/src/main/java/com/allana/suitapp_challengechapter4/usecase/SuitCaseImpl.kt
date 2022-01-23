package com.allana.suitapp_challengechapter4.usecase

import android.util.Log
import com.allana.suitapp_challengechapter4.enum.DecideWinner
import com.allana.suitapp_challengechapter4.enum.Suit

class SuitCaseImpl : SuitUseCase {

    companion object {
        const val TAG = "SUIT CASE"
    }

    override fun getWinner(player: Suit, computer: Suit): DecideWinner {
        return when {
            player == Suit.PAPER && computer == Suit.ROCK -> DecideWinner.PLAYER
            player == Suit.ROCK && computer == Suit.SCISSOR -> DecideWinner.PLAYER
            player == Suit.SCISSOR && computer == Suit.PAPER -> DecideWinner.PLAYER
            player == Suit.PAPER && computer == Suit.SCISSOR -> DecideWinner.COMPUTER
            player == Suit.ROCK && computer == Suit.PAPER -> DecideWinner.COMPUTER
            player == Suit.SCISSOR && computer == Suit.ROCK -> DecideWinner.COMPUTER
            else -> {
                DecideWinner.DRAW
            }
        }
    }

    override fun handlePickComputer(): Suit {
        val pickComputer = Suit.values().random()
        Log.d(TAG, "Result Pick $pickComputer")
        return when (pickComputer) {
            Suit.ROCK -> {
                Suit.ROCK
            }
            Suit.PAPER -> {
                Suit.PAPER
            }
            else -> {
                Suit.SCISSOR
            }
        }
    }

    override fun setColorButtonComputer(): Suit {
        return handlePickComputer()
    }
}