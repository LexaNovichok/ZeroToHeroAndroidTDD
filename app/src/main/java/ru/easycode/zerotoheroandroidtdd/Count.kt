package ru.easycode.zerotoheroandroidtdd

import android.os.Debug
import android.util.Log
import java.io.Serializable
import java.lang.IllegalStateException

interface Count {
    fun increment(number: String): UiState

    class Base(private val step : Int, private val max : Int) : Count {

        init {
            if (step <= 0) {
                throw IllegalStateException("step should be positive, but was $step")
            }
            if (max <= 0) {
                throw  IllegalStateException("max should be positive, but was $max")
            }
            if (max - step < 0) {
                throw IllegalStateException("max should be more than step")
            }
        }
        override fun increment(number: String): UiState {
            val currentNumber = number.toInt()
            val result = currentNumber + step

            return if (result + step <= max)
                UiState.Base(result.toString())
            else
                UiState.Max(result.toString())
        }
    }
}