package hr.ferit.ivoojvan.lv7_exercise

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.DateFormat


object ServiceBuilder {
    private val client = OkHttpClient.Builder().build()


    private val retrofit = Retrofit.Builder()
        .baseUrl("https://makeup-api.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun<T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }
}