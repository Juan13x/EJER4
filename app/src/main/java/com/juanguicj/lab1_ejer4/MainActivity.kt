package com.juanguicj.lab1_ejer4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.juanguicj.lab1_ejer4.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        with(mainBinding){
            resolveButton.setOnClickListener {
                val idBand1 = band1Spinner.selectedItemPosition
                val idBand2 = band2Spinner.selectedItemPosition
                val idBand3 = multiplierSpinner.selectedItemPosition
                val idBand4 = toleranceSpinner.selectedItemPosition

                var result = 0.0f
                var tolerance = ""
                var accumulator = ""

                accumulator += idBand1.toString()
                accumulator += idBand2.toString()
                result = accumulator.toFloat()
                if(idBand3 < 10){
                    result *= 10.0f.pow(idBand3)
                }
                else{
                    when (idBand3){
                        10 -> result *= 0.1f
                        else -> result *= 0.01f
                    }
                }
                when (idBand4){
                    0 -> tolerance = " ± 1%"
                    1 -> tolerance = " ± 2%"
                    2 -> tolerance = " ± 0.5%"
                    3 -> tolerance = " ± 0.25%"
                    4 -> tolerance = " ± 0.1%"
                    5 -> tolerance = " ± 0.05%"
                    6 -> tolerance = " ± 5%"
                    7 -> tolerance = " ± 10%"
                }
                resultTextView.text = result.toString() + tolerance
            }
        }
    }

}