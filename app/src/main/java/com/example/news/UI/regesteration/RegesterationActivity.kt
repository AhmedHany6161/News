package com.example.news.UI.regesteration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.news.R
import com.example.news.UI.login.LoginActivity
import com.example.news.databinding.ActivityRegesterationBinding
import com.example.news.model.entitys.User

class RegesterationActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegesterationBinding;
    lateinit var regesterViewModel: RegesterViewModel;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_regesteration)
        binding = DataBindingUtil.setContentView( this,R.layout.activity_regesteration)
        regesterViewModel =
            ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application))[RegesterViewModel::class.java]

        binding.regesterButton.setOnClickListener {
           val b= regesterViewModel.checkUserName(binding.userNameEditText.text.toString());
            if (b) {
                regesterViewModel.confirmPassword(
                    binding.passwordEditText.text.toString(),
                    binding.conPasswordEditText.text.toString()
                )

            }else{
                Toast.makeText(this,"enter all data",Toast.LENGTH_SHORT).show()
            }
        }
        regesterViewModel.checkPassword.observe(this,{
            if (it){
                val user=User(
                    name = binding.userNameEditText.text.toString(),
                    email = binding.emailEditText.text.toString(),
                    password = binding.passwordEditText.text.toString(),
                )
                regesterViewModel.register(user)
            }
            else{
                showAlert()
            }
        })
    regesterViewModel.checkData.observe(this,{
        if (it == "Password is week try another format"){
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Password is week try another format")
            builder.setPositiveButton("Ok") { dialog,_ ->
                dialog.dismiss()
            }
            builder.show()
        }else{
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Email is not correct")
            builder.setPositiveButton("Ok") { dialog,_ ->
                dialog.dismiss()
            }
            builder.show()
        }
    })

        regesterViewModel.done.observe(this,{
            binding.emailEditText.setText("")
            binding.passwordEditText.setText("")
            binding.conPasswordEditText.setText("")
            binding.userNameEditText.setText("")
            Toast.makeText(this,"Register is successfully",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, LoginActivity::class.java))

        })

    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("password is not identified")
        builder.setPositiveButton("Ok") { dialog,_ ->
            dialog.dismiss()
        }
        builder.show()
    }

}