package hr.ferit.ivoojvan.lv7_exercise

import retrofit2.Call
import retrofit2.http.GET

import retrofit2.http.Query

interface MakeupAPI {
    @GET("/api/v1/products.json?")
    fun getProducts(
        @Query("brand") brand:String
    ): Call<List<Product>>
}