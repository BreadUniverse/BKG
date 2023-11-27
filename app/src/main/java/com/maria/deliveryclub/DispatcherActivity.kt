package com.maria.deliveryclub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.maria.deliveryclub.databinding.ActivityCourierBinding
import com.maria.deliveryclub.databinding.ActivityDispatcherBinding

private lateinit var binding: ActivityDispatcherBinding


class DispatcherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDispatcherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageLogOut.setOnClickListener {
            val intent = Intent(this@DispatcherActivity, StartActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}