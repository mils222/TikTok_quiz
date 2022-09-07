package com.example.tiktokquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.PreferenceManager
import com.example.tiktokquiz.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkLevel()

        binding.prviNivo.setOnClickListener {
            val intent = Intent(this, FirstLevelActivity::class.java)
            startActivity(intent)
        }

        binding.drugiNivo.setOnClickListener {
            val intent = Intent(this, SecondLevelActivity::class.java)
            startActivity(intent)
        }


    }
    fun checkLevel() {
        val preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val listOfAllKeys = preferences.all.keys
        listOfAllKeys.forEach { key ->
            when (key) {
                "secondLevel" -> if(preferences.getString(key, null) == "Unlocked") {
                    binding.drugiNivo.isEnabled = true
                }
                else -> error("Unknown error occured.")
            }
        }
    }
}