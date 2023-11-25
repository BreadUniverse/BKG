package com.maria.deliveryclub

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.maria.deliveryclub.databinding.ActivityLoginUserBinding

class ProfileFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    fun onImageClick(imageView: ImageView) {
        // Создаем Intent для перехода в новую Activity
        val intent = Intent(activity, LoginUserActivity::class.java)

        // Дополнительные параметры, если необходимо
        // intent.putExtra("key", "value")

        // Запускаем новую Activity
        startActivity(intent)

    }
}