package com.example.taskmanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Add a delay before navigating to MainActivity
        Handler().postDelayed({
            // Start MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Finish the splash screen activity
        }, SPLASH_DELAY)
    }

    companion object {
        private const val SPLASH_DELAY: Long = 5000 // 5 seconds delay
    }
}
