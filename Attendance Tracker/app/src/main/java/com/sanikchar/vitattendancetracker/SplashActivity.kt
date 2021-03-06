package com.sanikchar.vitattendancetracker

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)
        GlobalScope.launch {
            delay(1000)
            //check if user has logged in, yes -> go to main activity, else take him to login activity
            when (FirebaseAuth.getInstance().currentUser) {
                null -> {
                    startActivity(Intent(this@SplashActivity, AuthActivity::class.java))
                    finish()
                }
                else -> {
                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                    finish()
                }
            }
        }
    }
}