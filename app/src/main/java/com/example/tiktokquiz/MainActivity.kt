package com.example.tiktokquiz

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tiktokquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var questionItemArray = arrayListOf<QusetionItem>()
    var correctAnswer = ""
    var questionIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val Question = QusetionItem(R.drawable., "Pogodi ovu TikTok zvezdu", "", "", "")
        val Question1 = QusetionItem(R.drawable.wajwai, "Pogodi ovu TikTok zvezdu", "Branko", "Wai Wai", "Wai Wai")
        val Question2 = QusetionItem(R.drawable.barbiafrika, "Pogodi ovu TikTok zvezdu", "Barbi Afrika", "Uki Q", "Barbi Afrika")
        val Question3 = QusetionItem(R.drawable.bondisimo, "Pogodi ovu TikTok zvezdu", "Bondisimo", "Ludi Brat", "Bondisimo")
        val Question4 = QusetionItem(R.drawable.saratkd, "Pogodi ovu TikTok zvezdu", "Anjatkd", "Saratkd", "Saratkd")
        val Question5 = QusetionItem(R.drawable.osamrastadevet, "Pogodi ovu TikTok zvezdu", "Andrijajo ", "8rasta9", "8rasta9")

        //questionItemArray.add(Question)
        questionItemArray.add(Question1)
        questionItemArray.add(Question2)
        questionItemArray.add(Question3)
        questionItemArray.add(Question4)
        questionItemArray.add(Question5)

        loadQuestion()

        binding.ansverABTN.setOnClickListener {
            it as TextView
            if (it.text == correctAnswer) {
                it.setBackgroundColor(Color.GREEN)
                Handler().postDelayed({
                    loadQuestion()
                }, 1000)
                it.setBackgroundColor(Color.BLACK)
            } else {
                Toast.makeText(this, "Your answer is not correct! Try again!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.ansverBBTN.setOnClickListener {
            it as TextView
            if (it.text == correctAnswer) {
                it.setBackgroundColor(Color.GREEN)
                Handler().postDelayed({
                    loadQuestion()
                }, 1000)
                it.setBackgroundColor(Color.BLACK)
            } else {
                Toast.makeText(this, "Your answer is not correct! Try again!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun loadQuestion() {
        if(questionItemArray.size > questionIndex) {
            binding.imgIV.setImageResource(questionItemArray.elementAt(questionIndex).img)
            binding.questionTV.text = questionItemArray.elementAt(questionIndex).question
            binding.ansverABTN.text = questionItemArray.elementAt(questionIndex).answerA
            binding.ansverBBTN.text = questionItemArray.elementAt(questionIndex).answerB
            correctAnswer = questionItemArray.elementAt(questionIndex).correctAnswer
            questionIndex++
        } else {
            Toast.makeText(this, "Quiz is finished, there is no new questions.", Toast.LENGTH_SHORT).show()
        }
    }
}