package com.sanikchar.vitattendancetracker

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.sanikchar.vitattendancetracker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //    @SuppressLint("ApplySharedPref")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

//        val sharedPreferences = this.getSharedPreferences(packageName, MODE_PRIVATE)
//        val editor = sharedPreferences.edit()
//        editor.putString("key","value").commit()
        setContentView(binding.root)

//        Toast.makeText(this, (sharedPreferences.getString("key","0")), Toast.LENGTH_SHORT).show()

        val auth = FirebaseAuth.getInstance()
        auth.addAuthStateListener {
            if (auth.currentUser == null) {
                startActivity(Intent(this@MainActivity, AuthActivity::class.java))
                finish()
            }
        }
    }

}