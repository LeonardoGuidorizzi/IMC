package br.senai.sp.jandira.imc20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import br.senai.sp.jandira.imc20.databinding.ActivityResultBinding
import br.senai.sp.jandira.imc20.util.getBmi
import br.senai.sp.jandira.imc20.util.getStatusBmi

class ResultActivity() : AppCompatActivity() {
lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var weight = intent.getIntExtra("peso", 0)
        var height = intent.getDoubleExtra("altura", 0.0)

        val bmi = getBmi(weight, height)
        val status = getStatusBmi(bmi)

        binding.textViewResult.text = String.format("%.2f",bmi)
        binding.textViewStatus.text = status





    }

}

