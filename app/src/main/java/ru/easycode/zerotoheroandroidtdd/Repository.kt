package ru.easycode.zerotoheroandroidtdd

import kotlinx.coroutines.delay

interface Repository {

    suspend fun load()

    class Base : Repository {

        private var actualCalledTimes = 0

        override suspend fun load() {
            delay(2500)
            actualCalledTimes++
        }

        fun checkLoadCalledTimes(times: Int) {

        }

    }
}
