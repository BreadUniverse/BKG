package com.maria.deliveryclub

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.maria.deliveryclub.Db.User


class ProfileFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)


        view.findViewById<ImageView>(R.id.image_log_out).setOnClickListener{
            val intent = Intent(activity, StartActivity::class.java)
            startActivity(intent)
        }

        return view
    }


}