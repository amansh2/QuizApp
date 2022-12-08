package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizapp.databinding.ActivityGameOverBinding
import com.example.quizapp.databinding.ActivityQuizPageBinding


class GameOver : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityGameOverBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent=intent
        binding.points.text=intent.getStringExtra("score")+"/4"
        binding.restart.setOnClickListener {
            startActivity(Intent(applicationContext,MainActivity::class.java))
            finish()
        }
    }
}