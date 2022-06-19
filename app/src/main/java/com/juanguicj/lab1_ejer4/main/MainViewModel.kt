package com.juanguicj.lab1_ejer4.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.pow

class MainViewModel : ViewModel() {
    fun process(idBand1: Int, idBand2: Int, idBand3: Int, idBand4: Int) {
        var tolerance = ""
        var accumulator = ""

        accumulator += idBand1.toString()
        accumulator += idBand2.toString()
        var result = accumulator.toFloat()
        result *= if (idBand3 < 10) {
            10.0f.pow(idBand3)
        } else {
            when (idBand3) {
                10 -> 0.1f
                else -> 0.01f
            }
        }
        when (idBand4) {
            0 -> tolerance = " ± 1%"
            1 -> tolerance = " ± 2%"
            2 -> tolerance = " ± 0.5%"
            3 -> tolerance = " ± 0.25%"
            4 -> tolerance = " ± 0.1%"
            5 -> tolerance = " ± 0.05%"
            6 -> tolerance = " ± 5%"
            7 -> tolerance = " ± 10%"
        }
        resultMutableLiveData.value = result.toString() + tolerance
    }

    private val resultMutableLiveData: MutableLiveData<String> = MutableLiveData()
    val resultLiveData: LiveData<String> = resultMutableLiveData


}