package com.allana.suitapp_challengechapter4.usecase

import com.allana.suitapp_challengechapter4.enum.DecideWinner
import com.allana.suitapp_challengechapter4.enum.Suit

interface SuitUseCase {

    fun getWinner(player: Suit, computer: Suit): DecideWinner
    fun handlePickComputer(): Suit
    fun setColorButtonComputer(): Suit

}