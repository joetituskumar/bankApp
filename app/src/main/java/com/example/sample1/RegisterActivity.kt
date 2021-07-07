package com.example.sample1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import  com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.AuthResult
import kotlinx.android.synthetic.main.activity_register.*





class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        already.setOnClickListener {
            onBackPressed()
        }

        registerButton.setOnClickListener{
            when{
                TextUtils.isEmpty(editTextPhoneRegister.text.toString().trim{ it<=' '}) ->{
                    Toast.makeText(this,"Please enter email.",Toast.LENGTH_SHORT).show()
                }
                TextUtils.isEmpty(editTextTextPasswordRegister.text.toString().trim{ it <= ' '}) ->{
                    Toast.makeText(this,"Please enter password",Toast.LENGTH_SHORT).show()
                }
                else ->{
                    val email : String = editTextPhoneRegister.text.toString().trim{ it <= ' '}
                    val password : String = editTextTextPasswordRegister.text.toString().trim{ it <=' '}

                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(
                               OnCompleteListener<AuthResult> { task ->
                            if(task.isSuccessful){

                                Toast.makeText(this,"You are registered successfully.",Toast.LENGTH_SHORT).show()

                                val intent =Intent(this,MainActivity::class.java)
                                intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                startActivity(intent)
                                finish()
                            }else(
                                    Toast.makeText(this,task.exception!!.toString(),Toast.LENGTH_SHORT).show()
                            )
                            }
                        )
                }
            }
        }
    }
}