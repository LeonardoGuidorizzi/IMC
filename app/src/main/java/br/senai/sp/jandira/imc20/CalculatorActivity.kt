package br.senai.sp.jandira.imc20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senai.sp.jandira.imc20.databinding.ActivityCalculatorBinding

class CalculatorActivity : AppCompatActivity() {
    lateinit var binding: ActivityCalculatorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root) // nao usar o id
        loadProfile()

        binding.buttonCalculator.setOnClickListener{
            if (validation()){
                bmiCalculator()
            }
        }

    }

    private fun bmiCalculator() {
        val openResult = Intent(this, ResultActivity::class.java)
        //enviar dados de uma activity para a outra

        openResult.putExtra("peso", binding.editTextWeight.text.toString().toInt())
        openResult.putExtra("altura",binding.editTextHeight.text.toString().toDouble())

        startActivity(openResult)
    }
    private fun validation():Boolean{
        if(binding.editTextWeight.text.isEmpty()){
            binding.editTextWeight.error = "The 'Weight' is required"
            return false
        }
        if(binding.editTextHeight.text.isEmpty()){
            binding.editTextHeight.error = "The 'Height' is required"
            return false
        }
        return true
    }

    private fun loadProfile() {
        // Abrir o arquivo SharedPreferences
         val  dados = getSharedPreferences("dados", MODE_PRIVATE)
        binding.textViewUserName.text = dados.getString("name", "")
        binding.textViewEmail.text = dados.getString("email", "")
        binding.textViewWeight.text = "Weight:${dados.getInt("weight", 0)}Kg"
        binding.textViewHeight.text = "Height:${dados.getFloat("height", 0.0f)}cm"
    }
}