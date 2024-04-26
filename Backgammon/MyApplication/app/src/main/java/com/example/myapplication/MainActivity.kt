package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var button1: Button
    private lateinit var button2: Button

    private var player1Score = 0
    private var player2Score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText1 = findViewById(R.id.editText1)
        editText2 = findViewById(R.id.editText2)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)

        val startGameButton = findViewById<Button>(R.id.startGameButton)
        startGameButton.setOnClickListener {
            val player1Name = editText1.text.toString()
            val player2Name = editText2.text.toString()

            editText1.isEnabled = false
            editText2.isEnabled = false

            button1.text = "$player1Name wins"
            button2.text = "$player2Name wins"

            button1.isEnabled = true
            button2.isEnabled = true
        }

        button1.setOnClickListener {
            player1Score++
            button1.text = "${editText1.text.toString()} wins - $player1Score"

            winner(editText1.text.toString(), player1Score)
        }

        button2.setOnClickListener {
            player2Score++
            button2.text = "${editText2.text.toString()} wins - $player2Score"

            winner(editText2.text.toString(), player2Score)
        }
    }

    private fun winner(playerName: String, playerScore: Int) {
        if (playerScore == 5) {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("WINNER_NAME", playerName)
            startActivity(intent)
            finish()
        }
    }
}


