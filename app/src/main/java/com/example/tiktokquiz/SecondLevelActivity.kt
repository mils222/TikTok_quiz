package com.example.tiktokquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.tiktokquiz.databinding.ActivityDrugiNivoBinding
import com.example.tiktokquiz.databinding.ActivityMainBinding

class SecondLevelActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDrugiNivoBinding
    private var questionItemArray = arrayListOf<QusetionItem>()
    var correctAnswer = ""
    var questionIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrugiNivoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val Question = QusetionItem(R.drawable., "Pogodi ovu TikTok zvezdu", "", "", "")
        val Question1 = QusetionItem(R.drawable.mecacazin, "Pogodi ovu TikTok zvezdu", "Nikola Bojcic", "Meca Cazin", "Meca Cazin")
        val Question2 = QusetionItem(R.drawable.elajerkovic, "Pogodi ovu TikTok zvezdu", "Ela Jerkovic", "Milica Polskaya", "Ela Jerkovic")
        val Question3 = QusetionItem(R.drawable.draganakovacevic, "Pogodi ovu TikTok zvezdu", "Dragana Kovacevic", "Isidora Jelača", "Dragana Kovacevic")
        val Question4 = QusetionItem(R.drawable.mirsadkadic, "Pogodi ovu TikTok zvezdu", "Cale", "Mirsad Kadic", "Mirsad Kadic")
        val Question5 = QusetionItem(R.drawable.janadacovic, "Pogodi ovu TikTok zvezdu", "Nadja Brkic", "Jana Dacovic", "Jana Dacovic")

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
                Toast.makeText(this, "Your answer is correct!", Toast.LENGTH_SHORT).show()
                loadQuestion()
            } else {
                Toast.makeText(this, "Your answer is not correct! Try again!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.ansverBBTN.setOnClickListener {
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
            binding.ansverABTN.text = questionItemArray.elementAt(questionIndex).answerA
            binding.ansverBBTN.text = questionItemArray.elementAt(questionIndex).answerB
            correctAnswer = questionItemArray.elementAt(questionIndex).correctAnswer
            questionIndex++
        } else {
            Toast.makeText(this, "Quiz is finished, there is no new questions.", Toast.LENGTH_SHORT).show()
        }
    }
}