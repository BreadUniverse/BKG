package com.maria.deliveryclub


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.maria.deliveryclub.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goUserBtn.setOnClickListener {
            val intent = Intent(this@StartActivity, LoginUserActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}