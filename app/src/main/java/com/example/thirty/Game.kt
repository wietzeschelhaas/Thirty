package com.example.thirty
import kotlin.random.Random

class Game {
    var round:Int = 0
    var diceThrowNum:Int = 1

    fun diceThrow(): Int {
        return (1..6).random()
    }

    //Returns true if we are at the last throw of the round
    fun nextRound():Boolean{
        if (diceThrowNum == 3){
            diceThrowNum = 0
            round += 1
            return true
        }

        diceThrowNum += 1
        return false
    }


}