package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_activity)

        val winnersName: TextView = findViewById(R.id.winnersName)
        val resetGameButton: Button = findViewById(R.id.resetGameButton)
        val winnerName = intent.getStringExtra("WINNER_NAME")

        winnersName.text = "Winner is $winnerName"

        resetGameButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}






