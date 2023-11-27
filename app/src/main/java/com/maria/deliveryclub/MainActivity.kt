package com.maria.deliveryclub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.maria.deliveryclub.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navigationView = findNavController(R.id.fragment_container)

        //val navController = findNavController(R.id.mainContainer)

        //val notification_btn = findViewById<ImageView>(R.id.bell_notification)

        //notification_btn.setOnClickListener {
            //val bottomSheetDialogFragment = notification_bottom_fragment()
            //bottomSheetDialogFragment.show(supportFragmentManager, "Test")
            //bottomNavView.setupWithNavController(navController)
        //}


        bottomNavView.setupWithNavController(navigationView)
    }

}