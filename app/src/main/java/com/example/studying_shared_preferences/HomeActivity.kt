package com.example.studying_shared_preferences

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.studying_shared_preferences.LoginActivity.Companion.KEY_EMAIL
import com.example.studying_shared_preferences.LoginActivity.Companion.KEY_PASSWORD
import com.example.studying_shared_preferences.LoginActivity.Companion.SHARED_PREF_NAME
import com.example.studying_shared_preferences.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSharedPreferences()
        displayLayout()
    }

    private fun setupSharedPreferences() {
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE)
    }

    private fun displayLayout() = with(binding) {
        tvEmail.text = sharedPreferences.getString(KEY_EMAIL, "")
        tvPassword.text = sharedPreferences.getString(KEY_PASSWORD, "")
        btBack.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }
    }
}