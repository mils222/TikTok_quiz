package com.example.tiktokquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.PreferenceManager
import com.example.tiktokquiz.databinding.ActivityTiktokBinding

class TikTokActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTiktokBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTiktokBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkLevel()

        binding.firstLevel.setOnClickListener {
            val intent = Intent(this, FirstLevelActivity::class.java)
            startActivity(intent)
        }

        binding.secondLevel.setOnClickListener {
            val intent = Intent(this, SecondLevelActivity::class.java)
            startActivity(intent)
        }

        binding.thirdLevel.setOnClickListener {
            val intent = Intent(this, ThirdLevelActivity::class.java)
            startActivity(intent)
        }

    }
    fun checkLevel() {
        val preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val listOfAllKeys = preferences.all.keys
        listOfAllKeys.forEach { key ->
            when (key) {
                "secondLevel" -> if(preferences.getString(key, null) == "Unlocked") {
                    binding.secondLevel.isEnabled = true
                }
                "thirdLevel" -> if(preferences.getString(key, null) == "Unlocked") {
                    binding.thirdLevel.isEnabled = true
                }
               // else -> error("Unknown error occured.")
            }
        }
    }
}