package com.example.flashchat

import android.R.attr.phoneNumber
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.flashchat.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.hbb20.CountryCodePicker
import java.util.concurrent.TimeUnit
import android.content.Intent


class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding
    lateinit var code:CountryCodePicker
    lateinit var number:EditText
    lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_login)
        code=binding.code
        number=binding.number
        code.registerCarrierNumberEditText(number)
        auth= FirebaseAuth.getInstance()
    }
    fun login(view: View) {
        if(code.fullNumber.isEmpty()){
            number.setError("Phone number is required")
            number.requestFocus()
            return
        }
        if (!code.isValidFullNumber)
        {
            number.setError("Invalid Number")
            number.requestFocus()
            return
        }
        else{
        var number: String = code.fullNumber
        var intent=Intent(applicationContext,OtpActivity::class.java)
        intent.putExtra("num",number)
        startActivity(intent)}
    }
}