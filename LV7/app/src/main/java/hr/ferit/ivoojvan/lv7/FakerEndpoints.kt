package hr.ferit.ivoojvan.lv7

import retrofit2.Call
import retrofit2.http.GET

interface FakerEndpoints {
    @GET("/api/v1/persons?_quantity=10")
    fun getPersons(): Call<ResponseData>
}