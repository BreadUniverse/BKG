package com.maria.deliveryclub.Users

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.maria.deliveryclub.Db.DbHelper
import com.maria.deliveryclub.DispatcherActivity
import com.maria.deliveryclub.R
import com.maria.deliveryclub.databinding.ActivityLoginDispatcherBinding

class LoginDispatcherActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginDispatcherBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginDispatcherBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val userLogin: EditText = findViewById(R.id.sign_in_dispatcher_login)
        val userPass: EditText = findViewById(R.id.sign_in_dispatcher_pass)

        binding.goSignupDispatcher.setOnClickListener {
            val intent = Intent(this@LoginDispatcherActivity, SignUpActivityDispatcher::class.java)
            startActivity(intent)
        }

        binding.buttonDispatcherLogin.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val pass = userPass.text.toString().trim()

            if(login == "" || pass == "")
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_LONG).show()
            else {
                val db = DbHelper(this, null)
                val isAuth = db.getDispatcher(login, pass)

                if(isAuth) {
                    Toast.makeText(this, "Вы вошли как $login", Toast.LENGTH_LONG).show()
                    userLogin.text.clear()
                    userPass.text.clear()

                    val intent = Intent(this@LoginDispatcherActivity, DispatcherActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else
                    Toast.makeText(this, "Неверный логин или пароль", Toast.LENGTH_LONG).show()

            }

        }
    }
}