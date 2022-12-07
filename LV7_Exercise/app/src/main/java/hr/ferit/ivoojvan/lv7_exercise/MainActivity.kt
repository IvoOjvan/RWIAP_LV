package hr.ferit.ivoojvan.lv7_exercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etBrand = findViewById<EditText>(R.id.etBrand)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)


        val btnSearch = findViewById<Button>(R.id.btnSearch)
        btnSearch.setOnClickListener{

            val brand : String = etBrand.text.toString()

            val request = ServiceBuilder.buildService(MakeupAPI::class.java)
            val call = request.getProducts(brand)

            call.enqueue(object : Callback<List<Product>> {
                override fun onResponse(
                    call: Call<List<Product>>,
                    response: Response<List<Product>>
                ) {
                    if (response.isSuccessful) {
                        recyclerView.apply {
                            layoutManager = LinearLayoutManager(this@MainActivity)
                            adapter = ProductRecyclerAdapter(response.body()!!.toList())
                        }
                    }
                }

                override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                    Log.d("FAIL", t.message.toString())
                }
            })

       }

    }
}