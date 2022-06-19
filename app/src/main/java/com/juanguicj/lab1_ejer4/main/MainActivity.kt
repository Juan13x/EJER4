package com.juanguicj.lab1_ejer4.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.juanguicj.lab1_ejer4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        with(mainBinding) {
            mainViewModel.resultLiveData.observe(this@MainActivity) { result ->
                resultTextView.text = result
            }

            resolveButton.setOnClickListener {
                val idBand1 = band1Spinner.selectedItemPosition
                val idBand2 = band2Spinner.selectedItemPosition
                val idBand3 = multiplierSpinner.selectedItemPosition
                val idBand4 = toleranceSpinner.selectedItemPosition

                mainViewModel.process(idBand1, idBand2, idBand3, idBand4)
            }
        }
    }

}