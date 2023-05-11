package com.example.userinput

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    var tipPercent: Double = 0.00
    var getTotal: Double = 0.00
    var finalTotal: Double = 0.00
    var tipChoice = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val total: EditText = findViewById(R.id.txtTotal)
        val group: Spinner = findViewById(R.id.idDropDown)
        val calculate: Button = findViewById(R.id.idButton)
        val result: TextView = findViewById(R.id.idResult)

        calculate.setOnClickListener {
            try {
                getTotal = total.text.toString().toDouble()
                val currency = DecimalFormat("$###,###.00")
                tipChoice = group.selectedItem.toString()
                when (tipChoice){
                    "5%" -> {tipPercent = .05}
                    "10%" -> {tipPercent = .1}
                    "15%" -> {tipPercent = .15}
                    "20%" -> {tipPercent = .2}
                    "25%" -> {tipPercent = .25}
                }
                val tipTotal = getTotal * tipPercent
                finalTotal = getTotal + tipTotal
                val tipFormat = currency.format(tipTotal)
                val totalFormat = currency.format(finalTotal)
                result.text = "Tip: $tipFormat\nFinal Total: $totalFormat"

            } catch(e: NumberFormatException){
                result.text = "Please enter your total."
            }

        }
    }
}