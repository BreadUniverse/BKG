package com.maria.deliveryclub.Users

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.maria.deliveryclub.Db.DbHelper
import com.maria.deliveryclub.Db.Dispatcher
import com.maria.deliveryclub.DispatcherActivity
import com.maria.deliveryclub.R
import com.maria.deliveryclub.StartActivity
import com.maria.deliveryclub.databinding.ActivitySignUpDispatcherBinding

class SignUpActivityDispatcher : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpDispatcherBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpDispatcherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageLogOut.setOnClickListener {
            val intent = Intent(this@SignUpActivityDispatcher, StartActivity::class.java)
            startActivity(intent)
            finish()
        }

        val userLogin: EditText = findViewById(R.id.dispatcher_name)
        val userEmail: EditText = findViewById(R.id.sign_up_dispatcher_email)
        val userPass: EditText = findViewById(R.id.sign_up_dispatcher_pass)


        binding.goLoginDispatcher.setOnClickListener {
            val intent = Intent(this@SignUpActivityDispatcher, LoginDispatcherActivity::class.java)
            startActivity(intent)

        }

        binding.buttonDispatcherSgnUp.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val pass = userPass.text.toString().trim()


            if (login == "" || email == "" || pass == "")
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_LONG).show()
            else {
                val dispatcher = Dispatcher(login, email, pass)

                val db = DbHelper(this, null)
                db.addDispatcher(dispatcher)
                Toast.makeText(this, "Аккаунт $login создан", Toast.LENGTH_LONG).show()

                userLogin.text.clear()
                userEmail.text.clear()
                userPass.text.clear()

            }

            val intent = Intent(this@SignUpActivityDispatcher, DispatcherActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}