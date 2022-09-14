package com.example.tiktokquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.preference.PreferenceManager
import com.example.tiktokquiz.databinding.ActivityBaseBinding

class BaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBaseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        checkCategory()

        binding.tiktok.setOnClickListener {
            val intent = Intent(this, TikTokActivity::class.java)
            startActivity(intent)
        }
    }
    fun checkCategory() {
        val preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val listOfAllKeys = preferences.all.keys
        listOfAllKeys.forEach { key ->
            when (key) {
                "tiktok" -> if(preferences.getString(key, null) == "Done") {
                    binding.tiktok.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.green)

                }
                "youtube" -> if(preferences.getString(key, null) == "Unlocked") {
                    binding.youtube.isEnabled = true
                }
                else -> error("Unknown error occured.")
            }
        }
    }
}