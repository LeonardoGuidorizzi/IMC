package br.senai.sp.jandira.imc20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import br.senai.sp.jandira.imc20.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    lateinit var buttonLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textSignup.setOnClickListener {
            val openSignupActivity = Intent(this, SignupActivity::class.java)
            startActivity(openSignupActivity)
        }
        binding.buttonLogin.setOnClickListener {
            login()
        }
        supportActionBar!!.hide()

//        buttonLogin = findViewById(R.id.buttonLogin)
//        buttonLogin.setOnClickListener {
//            val openCalculatorActivity = Intent(this, CalculatorActivity::class.java)
//            startActivity(openCalculatorActivity)
//        }
    }

    private fun login() {
        if(validar()){
            val email = binding.editTextEmail.text.toString()
            val pass = binding.editTextPassword.text.toString()
            
            //abrir o SAhredPreferences
            val dados = getSharedPreferences("dados", MODE_PRIVATE)
            val emailSp = dados.getString("email"," Email nao encontrado")
            val passSp = dados.getString("password", "")
            
            // verificar se os dados estao corretos 
            if (email == emailSp && pass == passSp){
                val openCalculate = Intent(this, CalculatorActivity::class.java)
                startActivity(openCalculate)
            } else{
                Toast.makeText(this, "Authetication failed", Toast.LENGTH_SHORT).show()
            }

        }

    }

    private fun validar(): Boolean {
    if(binding.editTextEmail.text.isEmpty()){
        binding.editTextEmail.error = "E-mail is required!"
        return false
    }
        if(binding.editTextPassword.text.isEmpty()){
            binding.editTextPassword.error = "Password is required!"
            return false
        }
        return true
    }
}