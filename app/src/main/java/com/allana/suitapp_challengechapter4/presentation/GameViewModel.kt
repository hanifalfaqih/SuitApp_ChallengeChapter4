package com.allana.suitapp_challengechapter4.presentation

import androidx.lifecycle.ViewModel
import com.allana.suitapp_challengechapter4.enum.DecideWinner
import com.allana.suitapp_challengechapter4.enum.Suit
import com.allana.suitapp_challengechapter4.usecase.SuitCaseImpl

class GameViewModel : ViewModel() {

    private val suitCaseImpl = SuitCaseImpl()

    fun getWinner(player: Suit, computer: Suit): DecideWinner {
        return suitCaseImpl.getWinner(player, computer)
    }

    fun handlePickComputer(): Suit {
        return suitCaseImpl.handlePickComputer()
    }

    fun setColorButtonComputer(): Suit {
        return suitCaseImpl.setColorButtonComputer()
    }

}