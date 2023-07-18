package com.example.studying_shared_preferences

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.studying_shared_preferences.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSharedPreferences()
        validationSharedPreferencesContent()
        onClickLogin()
    }

    private fun validationSharedPreferencesContent() {
        if (
            sharedPreferences.getString(KEY_EMAIL, "")!!.isNotEmpty()
            &&
            sharedPreferences.getString(KEY_PASSWORD, "")!!.isNotEmpty()
        ) {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }

    private fun setupSharedPreferences() {
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }

    private fun onClickLogin() = with(binding) {
        btLogin.setOnClickListener {
            editor.apply {
                putString(KEY_EMAIL, etEmail.text.toString())
                putString(KEY_PASSWORD, etPassword.text.toString())
                apply()
            }
            startActivity(Intent(baseContext, HomeActivity::class.java))
        }
    }

    companion object {
        const val SHARED_PREF_NAME = "shared_preferences"
        const val KEY_EMAIL = "email"
        const val KEY_PASSWORD = "password"
    }
}