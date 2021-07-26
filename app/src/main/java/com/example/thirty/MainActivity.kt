package com.example.thirty

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.thirty.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var game : Game

    private var pickScore: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view);

        game = Game()
        val score = Score()

        setRoundText(game.round)
        setThrowText(game.diceThrowNum)

        val dices = ArrayList<Dice>()
        dices.add(Dice(binding.dice1,1))
        dices.add(Dice(binding.dice2,1))
        dices.add(Dice(binding.dice3,1))
        dices.add(Dice(binding.dice4,1))
        dices.add(Dice(binding.dice5,1))
        dices.add(Dice(binding.dice6,1))

        binding.spinner.visibility = View.INVISIBLE

        
        Log.d("TAG", "message")
        binding.throwButton?.setOnClickListener {
            if(pickScore){
                val spinnerVal = binding.spinner.selectedItem
                println(spinnerVal)
                binding.spinner.visibility = View.INVISIBLE
                binding.throwButton!!.text = "THROW"

                var dicenums = ArrayList<Int>()
                for(dice in dices){
                    dicenums.add(dice.diceNum)
                }
                score.calcScore(dicenums,5)

            }else{


                for (i in 0..5){
                    if(dices.get(i).lock){
                        continue
                    }
                    var num = game.diceThrow()
                    dices.get(i).diceNum=num
                    dices.get(i).draw(num)

                }





                if(game.nextRound()){
                    pickScore = true
                    binding.spinner.visibility = View.VISIBLE
                    binding.throwButton!!.text = "OK"

                }
            }

            setRoundText(game.round)
            setThrowText(game.diceThrowNum)

        }

    }

    fun setRoundText(round:Int){
        binding.roundText.text = "Round : " + round
    }
    fun setThrowText(thr:Int){
        binding.throwText.text = "Throw : " + thr
    }



}