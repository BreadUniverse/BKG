package com.maria.deliveryclub.Users

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.maria.deliveryclub.Db.DbHelper
import com.maria.deliveryclub.MainActivity
import com.maria.deliveryclub.R
import com.maria.deliveryclub.StartActivity
import com.maria.deliveryclub.databinding.ActivityLoginUserBinding

class LoginUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageLogOut.setOnClickListener {
            val intent = Intent(this@LoginUserActivity, StartActivity::class.java)
            startActivity(intent)
            finish()
        }

        val userLogin: EditText = findViewById(R.id.sign_in_user_login)
        val userPass: EditText = findViewById(R.id.sign_in_user_pass)

        binding.goSignupUser.setOnClickListener {
            val intent = Intent(this@LoginUserActivity, SignUpActivity::class.java)
            startActivity(intent)
        }

        binding.buttonUserLogin.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val pass = userPass.text.toString().trim()

            if(login == "" || pass == "")
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_LONG).show()
            else {
                val db = DbHelper(this, null)
                val isAuth = db.getUser(login, pass)

                if(isAuth) {
                    Toast.makeText(this, "Вы вошли как $login", Toast.LENGTH_LONG).show()
                    userLogin.text.clear()
                    userPass.text.clear()

                    val intent = Intent(this@LoginUserActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else
                    Toast.makeText(this, "Неверный логин или пароль", Toast.LENGTH_LONG).show()

            }

        }
    }
}