package com.example.tiktokquiz

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.preference.PreferenceManager
import com.example.tiktokquiz.databinding.ActivityYouTubeFirstLevelBinding


class YouTubeFirstLevelActivity : AppCompatActivity() {
    private lateinit var binding: ActivityYouTubeFirstLevelBinding
    private var questionItemArray = arrayListOf<QusetionItem>()
    var correctCounter = 0
    var correctAnswer = ""
    var questionIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYouTubeFirstLevelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val Question = QusetionItem(R.drawable., "Pogodi ovu TikTok zvezdu", "", "", "")
        val Question1 = QusetionItem(
            R.drawable.simi,
            "Pogodi ovu YouTube zvezdu",
            "Simi",
            "Janko",
            "Simi"
        )
        val Question2 = QusetionItem(
            R.drawable.choda,
            "Pogodi ovu YouTube zvezdu",
            "Baka Prase",
            "Choda",
            "Choda"
        )

        val Question3 = QusetionItem(
            R.drawable.dexrock,
            "Pogodi ovu YouTube zvezdu",
            "Dex Rock",
            "Mudja",
            "Dex Rock"
        )

        //questionItemArray.add(Question)
        questionItemArray.add(Question1)
        questionItemArray.add(Question2)
        questionItemArray.add(Question3)


        loadQuestion()

        binding.questionCounter.text = questionItemArray.size.toString()
        binding.correctAnswerCounter.text = correctCounter.toString()
        binding.ansverABTN.setOnClickListener {
            it as AppCompatButton
            binding.ansverABTN.isEnabled = false
            binding.ansverBBTN.isEnabled = false

            if (it.text == correctAnswer) {
                it.backgroundTintList = ContextCompat.getColorStateList(this, R.color.green)
                correctCounter++
                binding.correctAnswerCounter.text = correctCounter.toString()
                Handler().postDelayed({
                    loadQuestion()
                }, 1000)

            } else {
                it.backgroundTintList = ContextCompat.getColorStateList(this, R.color.red)
                Handler().postDelayed({
                    loadQuestion()
                }, 1000)
            }
        }

        binding.ansverBBTN.setOnClickListener {
            binding.ansverABTN.isEnabled = false
            binding.ansverBBTN.isEnabled = false

            it as AppCompatButton
            if (it.text == correctAnswer) {
                it.backgroundTintList = ContextCompat.getColorStateList(this, R.color.green)
                correctCounter++
                binding.correctAnswerCounter.text = correctCounter.toString()
                Handler().postDelayed({
                    loadQuestion()
                }, 1000)

            } else {
                it.backgroundTintList = ContextCompat.getColorStateList(this, R.color.red)
                Handler().postDelayed({
                    loadQuestion()
                }, 1000)
            }
        }
    }

    fun loadQuestion() {
        if (questionItemArray.size > questionIndex) {
            binding.ansverABTN.isEnabled = true
            binding.ansverBBTN.isEnabled = true
            binding.ansverABTN.backgroundTintList =
                ContextCompat.getColorStateList(this, R.color.black)
            binding.ansverBBTN.backgroundTintList =
                ContextCompat.getColorStateList(this, R.color.black)
            binding.imgIV.setImageResource(questionItemArray.elementAt(questionIndex).img)
            binding.questionTV.text = questionItemArray.elementAt(questionIndex).question
            binding.ansverABTN.text = questionItemArray.elementAt(questionIndex).answerA
            binding.ansverBBTN.text = questionItemArray.elementAt(questionIndex).answerB
            correctAnswer = questionItemArray.elementAt(questionIndex).correctAnswer
            questionIndex++
        } else {
            firstLevelDialog()
        }
    }

    fun firstLevelDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("LEVEL 1")
        if (questionItemArray.size == correctCounter) {
            saveLevel("secondLevelYouTube", "Unlocked")
            builder.setMessage("Congratulations, you can continue to level 2 now.")
            builder.setPositiveButton("Continue") { dialog, which ->
                finish()
                val intent = Intent(this, YouTubeSecondLevelActivity::class.java)
                startActivity(intent)
            }
        } else {
            builder.setMessage("You need all correct answers to continue to the next level. Please try again.")
            builder.setPositiveButton("Try again") { dialog, which ->
                val intent = intent
                finish()
                startActivity(intent)
            }
        }
        builder.setNegativeButton("Cancel") { dialog, which ->
            finishAffinity()
            val intent = Intent(this, YouTubeActivity::class.java)
            startActivity(intent)

        }
        builder.setCancelable(false)
        builder.show()
    }

    fun saveLevel(key: String, value: String) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val editor = preferences.edit()
        editor.putString(key, value)
        editor.apply()
    }
}
