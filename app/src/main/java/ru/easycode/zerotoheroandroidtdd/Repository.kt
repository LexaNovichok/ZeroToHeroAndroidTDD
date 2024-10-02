package ru.easycode.zerotoheroandroidtdd

import java.net.UnknownHostException

interface Repository {

    suspend fun load() : LoadResult

    class Base(
        private val service : SimpleService,
        private val url : String
    ) : Repository {
        override suspend fun load(): LoadResult {
            return try {
                val response = service.fetch(url)
                if (response.text.isNotEmpty()) {
                    LoadResult.Success(response)
                } else {
                    LoadResult.Error(noConnection = false)
                }
            } catch (e: UnknownHostException) {
                LoadResult.Error(noConnection = true)
            } catch (e: Exception) {
                LoadResult.Error(noConnection = false)
            }
        }

    }
}