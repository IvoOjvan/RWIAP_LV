package hr.ferit.ivoojvan.lv7_exercise

import retrofit2.Call
import retrofit2.http.GET

interface MakeupAPI {
    @GET("/api/v1/products.json?brand=maybelline")
    fun getProducts(): Call<ResponseData>
}