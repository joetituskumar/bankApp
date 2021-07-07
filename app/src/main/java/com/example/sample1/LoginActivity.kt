package com.example.sample1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.text.TextUtils
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        dont.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }
        loginButton.setOnClickListener {
            when{
                TextUtils.isEmpty(editTextPhone.text.toString().trim { it <=' ' }) ->{
                    Toast.makeText(this,"Please enter email.",Toast.LENGTH_SHORT).show()
                }
                TextUtils.isEmpty(editTextTextPassword.text.toString().trim { it <=' ' })->{
                    Toast.makeText(this,"Please enter password",Toast.LENGTH_SHORT).show()
                }
                else ->{
                    val email :String =editTextPhone.text.toString().trim { it <=' ' }
                    val password: String=editTextTextPassword.text.toString().trim{ it <=' '}

                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener{ task ->
                            if(task.isSuccessful){
                                Toast.makeText(this,"You are logged in successfully",Toast.LENGTH_SHORT).show()

                                val intent=Intent(this,MainActivity::class.java)
                                intent.flags=Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                                startActivity(intent)
                                finish()
                            }else{
                                Toast.makeText(this,task.exception!!.message.toString(),Toast.LENGTH_SHORT).show()
                            }
                        }
                }
            }
        }



    }
}