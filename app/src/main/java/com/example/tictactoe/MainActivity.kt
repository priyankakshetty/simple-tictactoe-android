package com.example.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonClicked(view: View) {
        val buttonselected = view as Button
        var bId = 0
        when(buttonselected.id){
            R.id.button1 -> bId = 1
            R.id.button2 -> bId = 2
            R.id.button3 -> bId = 3
            R.id.button4 -> bId = 4
            R.id.button5 -> bId = 5
            R.id.button6 -> bId = 6
            R.id.button7 -> bId = 7
            R.id.button8 -> bId = 8
            R.id.button9 -> bId = 9
        }

        playGame(bId, buttonselected)

    }

    var board = arrayOf<Int>(0,0,0,0,0,0,0,0,0)
    var p1points = 0
    var p2points = 0
    var activePlayer = 1
    var winner = 0
    private fun playGame(bId: Int, buttonselected: Button) {

        if(activePlayer==1){
            winnerbtn.text="Player 2 Turn"
            board[bId-1] = 1
            buttonselected.setBackgroundResource(R.drawable.x)
            activePlayer = 2
        }else{
            winnerbtn.text="Player 1 Turn"
            buttonselected.setBackgroundResource(R.drawable.o)
            board[bId-1] = 2
            activePlayer = 1
        }
        buttonselected.isEnabled = false;
        checkWinner()
    }


    private fun checkWinner() {
        //row 1
        if (board[0] == board[1] && board[1] == board[2]) {
            winner = board[0]
        }
        //row 2
        else if (board[3] == board[4] && board[4] == board[5]) {
            winner = board[3]
         }
        //row 3
        else if(board[6] == board[7] && board[7] == board[8]){
            winner = board[6]
        }
        //col 1
        else if(board[0] == board[3] && board[3] == board[6]){
            winner = board[0]
        }
        //col 2
        else if(board[1] == board[4] && board[4] == board[7]){
            winner = board[1]
        }
        //col 3
        else if(board[2] == board[5] && board[5] == board[8]){
            winner = board[2]
        }
        //diag 1
        else if(board[0] == board[4] && board[4] == board[8]){
            winner = board[0]
        }
        //diag 2
        else if(board[2] == board[4] && board[4] == board[6]) {
            winner = board[2]
        }
        var flag = 0
        for (i in 0..8){
            if(board[i] == 0){
                flag = 1
            }
        }
        if(flag == 0){
            winner = 3
        }

        if(winner == 1){
            p1points++
            p1score.text = "Player 1:" + p1points
            winnerbtn.setBackgroundColor(Color.parseColor("#323236"))
            winnerbtn.setTextColor(Color.parseColor("#ffffff"));
            winnerbtn.text = "Player 1 Wins!"
            resetbtn.setBackgroundResource(R.drawable.reset)
            button1.isEnabled = false
            button2.isEnabled = false
            button3.isEnabled = false
            button4.isEnabled = false
            button5.isEnabled = false
            button6.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false
        }
        else if(winner == 2){
            p2points++
            p2score.text = "Player 2:" + p2points
            winnerbtn.setBackgroundColor(Color.parseColor("#323236"))
            winnerbtn.setTextColor(Color.parseColor("#ffffff"));
            winnerbtn.text = "Player 2 Wins!"
            resetbtn.setBackgroundResource(R.drawable.reset)
            button1.isEnabled = false
            button2.isEnabled = false
            button3.isEnabled = false
            button4.isEnabled = false
            button5.isEnabled = false
            button6.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false
        }
        else if (winner == 3){
            winnerbtn.setBackgroundColor(Color.parseColor("#323236"))
            winnerbtn.setTextColor(Color.parseColor("#ffffff"));
            winnerbtn.text = "Draw!"
            resetbtn.setBackgroundResource(R.drawable.reset)
            button1.isEnabled = false
            button2.isEnabled = false
            button3.isEnabled = false
            button4.isEnabled = false
            button5.isEnabled = false
            button6.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false
        }
    }


    fun resetGame(view: View) {

        for (i in 0..8) {
            board[i] = 0
        }
        if(winner == 3){
            activePlayer = 1
        }
        else {
            activePlayer = winner
        }
        button1.setBackgroundResource(R.drawable.bg)
        button2.setBackgroundResource(R.drawable.bg)
        button3.setBackgroundResource(R.drawable.bg)
        button4.setBackgroundResource(R.drawable.bg)
        button5.setBackgroundResource(R.drawable.bg)
        button6.setBackgroundResource(R.drawable.bg)
        button7.setBackgroundResource(R.drawable.bg)
        button8.setBackgroundResource(R.drawable.bg)
        button9.setBackgroundResource(R.drawable.bg)
        button1.isEnabled = true
        button2.isEnabled = true
        button3.isEnabled = true
        button4.isEnabled = true
        button5.isEnabled = true
        button6.isEnabled = true
        button7.isEnabled = true
        button8.isEnabled = true
        button9.isEnabled = true
    }
}

