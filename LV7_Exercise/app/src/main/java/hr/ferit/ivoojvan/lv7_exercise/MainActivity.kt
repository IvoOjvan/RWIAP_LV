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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etBrand = findViewById<EditText>(R.id.etBrand)
        val tv = findViewById<TextView>(R.id.textView2)

        val btnSearch = findViewById<Button>(R.id.btnSearch)
        btnSearch.setOnClickListener{

            Toast.makeText(this, "Clicked", Toast.LENGTH_LONG).show()

            val request = ServiceBuilder.buildService(MakeupAPI::class.java)
            val call = request.getProducts()

            call.enqueue(object : Callback<ResponseData> {
                override fun onResponse(
                    call: Call<ResponseData>,
                    response: Response<ResponseData>
                ) {
                    if (response.isSuccessful) {
                        findViewById<RecyclerView>(R.id.recyclerView).apply {
                            layoutManager = LinearLayoutManager(this@MainActivity)
                            adapter = ProductRecyclerAdapter(response.body()!!.data)
                        }
                    }
                }

                override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                    Log.d("FAIL", t.message.toString())
                }
            })

       }

    }
}