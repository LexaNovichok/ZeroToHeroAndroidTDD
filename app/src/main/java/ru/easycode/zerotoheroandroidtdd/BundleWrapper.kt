package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import android.os.Bundle
import android.util.Log

interface BundleWrapper {

    interface Mutable : Save, Restore

    interface Save {
        fun save(last: UiState)
    }

    interface Restore {
        fun restore(): UiState
    }

    class Base(
        private val bundle: Bundle
    ) : BundleWrapper.Mutable {

        override fun restore(): UiState {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                //Log.d("LALALA", "save: ${bundle.getSerializable(KEYS.KEY_UI, UiState::class.java) as UiState}")
                bundle.getSerializable(KEYS.KEY_UI, UiState::class.java) as UiState
            } else {
                bundle.getSerializable(KEYS.KEY_UI) as UiState
            }
        }

        override fun save(last: UiState) {
            bundle.putSerializable(KEYS.KEY_UI, last)
            //Log.d("LALALA", "save: $last")
        }
    }
}
