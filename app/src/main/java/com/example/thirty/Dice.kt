package com.example.thirty

import android.widget.ImageButton

class Dice(val imgButton:ImageButton,val num:Int) {
    private val imageButton: ImageButton = imgButton
    var lock = false
    var diceNum = num

    init {

        imageButton.setOnClickListener {
            lock = !lock
            draw(diceNum)
        }

        draw(num)
    }

    fun draw(num:Int){
        diceNum = num
        if(lock){
            when(num){
                1-> imageButton.setImageResource(R.drawable.red1)
                2-> imageButton.setImageResource(R.drawable.red2)
                3-> imageButton.setImageResource(R.drawable.red3)
                4-> imageButton.setImageResource(R.drawable.red4)
                5-> imageButton.setImageResource(R.drawable.red5)
                6-> imageButton.setImageResource(R.drawable.red6)
            }
        } else{
            when(num){
                1-> imageButton.setImageResource(R.drawable.white1)
                2-> imageButton.setImageResource(R.drawable.white2)
                3-> imageButton.setImageResource(R.drawable.white3)
                4-> imageButton.setImageResource(R.drawable.white4)
                5-> imageButton.setImageResource(R.drawable.white5)
                6-> imageButton.setImageResource(R.drawable.white6)
            }
        }


    }


}