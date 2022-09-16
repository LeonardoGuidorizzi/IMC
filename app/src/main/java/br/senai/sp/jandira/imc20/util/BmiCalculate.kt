package br.senai.sp.jandira.imc20.util



import kotlin.math.pow



    fun getBmi(weight: Int, height: Double): Double {
        return weight / height.pow(2)
    }

    fun getStatusBmi(bmi:Double): String {


        if (bmi <= 18.5) {
            return "Under weight."
        } else if (bmi >= 18.6 && bmi < 25) {
            return "ideal weight."
        }else if (bmi in 25.0..29.9) {
            return "Slightly overweight."
        }else if (bmi in 30.0..34.9) {
            return "Grade I obesity."
        }else if (bmi in 35.0..39.9) {
            return "Grade II obesity (severe)."
        }else{
            return "Obesity III (morbid)."
        }
    }
