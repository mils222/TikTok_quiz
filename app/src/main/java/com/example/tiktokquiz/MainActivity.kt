package com.example.tiktokquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
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

        val firstQuestion = QusetionItem(R.drawable.cimi, "Guess this YouTube Star", "Baka Prase", "Simi", "Simi")
        val secondQuestion = QusetionItem(R.drawable.wajwai, "Guess this TikTok Star", "Branko", "Wai Wai", "Wai Wai")
        val thirdQuestion = QusetionItem(R.drawable.janko, "Guess this YouTube Star", "Janko", "Choda", "Janko")
        val fortQuestion = QusetionItem(R.drawable.bakaprase, "Guess this YouTube Star", "tvoja keva", "Baka Prase", "Baka Prase")


        questionItemArray.add(firstQuestion)
        questionItemArray.add(secondQuestion)
        questionItemArray.add(thirdQuestion)
        questionItemArray.add(fortQuestion)


        loadQuestion()

        binding.ansverATV.setOnClickListener {
            it as TextView
            if (it.text == correctAnswer) {
                Toast.makeText(this, "Your answer is correct!", Toast.LENGTH_SHORT).show()
                loadQuestion()
            } else {
                Toast.makeText(this, "Your answer is not correct! Try again!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.ansverBTV.setOnClickListener {
            it as TextView
            if (it.text == correctAnswer) {
                Toast.makeText(this, "Your answer is correct!", Toast.LENGTH_SHORT).show()
                loadQuestion()
            } else {
                Toast.makeText(this, "Your answer is not correct! Try again!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun loadQuestion() {
        if(questionItemArray.size > questionIndex) {
            binding.imgIV.setImageResource(questionItemArray.elementAt(questionIndex).img)
            binding.questionTV.text = questionItemArray.elementAt(questionIndex).question
            binding.ansverATV.text = questionItemArray.elementAt(questionIndex).answerA
            binding.ansverBTV.text = questionItemArray.elementAt(questionIndex).answerB
            correctAnswer = questionItemArray.elementAt(questionIndex).correctAnswer
            questionIndex++
        } else {
            Toast.makeText(this, "Quiz is finished, there is no new questions.", Toast.LENGTH_SHORT).show()
        }
    }
}