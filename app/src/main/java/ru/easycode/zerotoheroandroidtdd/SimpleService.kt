package ru.easycode.zerotoheroandroidtdd

import com.google.gson.annotations.SerializedName
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface SimpleService {

    @GET("{fullUrl}")
    suspend fun fetch(@Path(value = "fullUrl", encoded = true) url : String) : SimpleResponse

    object Base : SimpleService {
        override suspend fun fetch(url: String) : SimpleResponse {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://www.google.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service : SimpleService = retrofit.create(SimpleService::class.java)
            val actual = service.fetch(url)

            return actual
        }
    }
}

data class SimpleResponse(
    @SerializedName("text")
    val text : String
)