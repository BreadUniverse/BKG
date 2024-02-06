package com.maria.deliveryclub.Users

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.maria.deliveryclub.CourierActivity
import com.maria.deliveryclub.Db.DbHelper
import com.maria.deliveryclub.Db.Courier
import com.maria.deliveryclub.R
import com.maria.deliveryclub.databinding.ActivitySignUpCourierBinding

class SignUpActivityCourier : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpCourierBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpCourierBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userLogin: EditText = findViewById(R.id.courier_name)
        val userEmail: EditText = findViewById(R.id.sign_up_courier_email)
        val userPass: EditText = findViewById(R.id.sign_up_courier_pass)


        binding.goLoginCourier.setOnClickListener {
            val intent = Intent(this@SignUpActivityCourier, LoginCourierActivity::class.java)
            startActivity(intent)

        }

        binding.buttonCourierSgnUp.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val pass = userPass.text.toString().trim()


            if(login == "" || email == "" || pass == "")
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_LONG).show()
            else {
                val courier = Courier(login, email, pass)

                val db = DbHelper(this, null)
                db.addCourier(courier)
                Toast.makeText(this, "Аккаунт $login создан", Toast.LENGTH_LONG).show()

                userLogin.text.clear()
                userEmail.text.clear()
                userPass.text.clear()

            }

            val intent = Intent(this@SignUpActivityCourier, CourierActivity::class.java)
            startActivity(intent)
            finish()
        }



    }
}