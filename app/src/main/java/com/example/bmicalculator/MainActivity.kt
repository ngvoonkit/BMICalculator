package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculate.setOnClickListener{
            calculateBMI()
        }
    }

    fun calculateBMI(){
        //TODO: Calculate BMI and show all outputs
        if(textHeight.text.isEmpty()){
            textHeight.setError(getString(R.string.error_input))
            return
        }
        if(textWeight.text.isBlank()){
            textWeight.setError(getString(R.string.error_input))
        }

        val height : Float = textHeight.text.toString().toFloat()
        val weight : Float = textWeight.text.toString().toFloat()
        val bmi = weight / height.pow(2)

        textBMI.text = String.format("%s %.2f","BMI :", bmi)
        if(bmi < 18.5){
            imageView.setImageResource(R.drawable.under)
            textStatus.setText("Underweight")
        }
        if(bmi < 25){
            imageView.setImageResource(R.drawable.normal)
            textStatus.setText("Normal")
        }
        if(bmi > 25){
            imageView.setImageResource(R.drawable.over)
            textStatus.setText("Overweight")
        }
    }

    fun resetOutput(view: View){
        //TODO: C;ear all inputs and outputs
        textWeight.setText("")
    }
}

