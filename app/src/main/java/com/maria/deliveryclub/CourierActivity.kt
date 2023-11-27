package com.maria.deliveryclub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.maria.deliveryclub.databinding.ActivityCourierBinding
import com.maria.deliveryclub.databinding.ActivityLoginUserBinding
import com.maria.deliveryclub.databinding.ActivityStartBinding

private lateinit var binding: ActivityCourierBinding


class CourierActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCourierBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageLogOut.setOnClickListener {
            val intent = Intent(this@CourierActivity, StartActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}