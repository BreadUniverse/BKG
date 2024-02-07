package com.maria.deliveryclub.Users

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.maria.deliveryclub.Db.DbHelper
import com.maria.deliveryclub.Db.User
import com.maria.deliveryclub.LocationActivity
import com.maria.deliveryclub.R
import com.maria.deliveryclub.StartActivity
import com.maria.deliveryclub.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageLogOut.setOnClickListener {
            val intent = Intent(this@SignUpActivity, StartActivity::class.java)
            startActivity(intent)
            finish()
        }

        val userLogin: EditText = findViewById(R.id.user_name)
        val userEmail: EditText = findViewById(R.id.sign_up_user_email)
        val userPass: EditText = findViewById(R.id.sign_up_user_pass)


        binding.goLoginUser.setOnClickListener {
            val intent = Intent(this@SignUpActivity, LoginUserActivity::class.java)
            startActivity(intent)

        }

        binding.buttonUserSgnUp.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val pass = userPass.text.toString().trim()


            if(login == "" || email == "" || pass == "")
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_LONG).show()
            else {
                val user = User(login, email, pass)

                val db = DbHelper(this, null)
                db.addUser(user)
                Toast.makeText(this, "Аккаунт $login создан", Toast.LENGTH_LONG).show()

                userLogin.text.clear()
                userEmail.text.clear()
                userPass.text.clear()

            }

            val intent = Intent(this@SignUpActivity, LocationActivity::class.java)
            startActivity(intent)
            finish()
        }



    }
}