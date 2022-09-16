package com.example.tiktokquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.PreferenceManager
import com.example.tiktokquiz.databinding.ActivityYouTubeBinding

class YouTubeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityYouTubeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYouTubeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkLevel()

        binding.firstLevelYouTube.setOnClickListener {
            val intent = Intent(this, YouTubeFirstLevelActivity::class.java)
            startActivity(intent)
        }

        binding.secondLevelYouTube.setOnClickListener {
            val intent = Intent(this, YouTubeSecondLevelActivity::class.java)
            startActivity(intent)
        }

        binding.thirdLevelYouTube.setOnClickListener {
            val intent = Intent(this, YouTubeThirdLevelActivity::class.java)
            startActivity(intent)
        }

    }
    fun checkLevel() {
        val preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val listOfAllKeys = preferences.all.keys
        listOfAllKeys.forEach { key ->
            when (key) {
                "secondLevelYouTube" -> if(preferences.getString(key, null) == "Unlocked") {
                    binding.secondLevelYouTube.isEnabled = true
                }
                "thirdLevelYouTube" -> if(preferences.getString(key, null) == "Unlocked") {
                    binding.thirdLevelYouTube.isEnabled = true
                }
                // else -> error("Unknown error occured.")
            }
        }
    }
}