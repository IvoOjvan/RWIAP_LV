package hr.ferit.ivoojvan.lv7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var personAdapter: PersonRecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val request = ServiceBuilder.buildService(FakerEndpoints::class.java)
        val call = request.getPersons()

        call.enqueue(object : Callback<ResponseData> {
            override fun onResponse(call: Call<ResponseData>, response:
            Response<ResponseData>
            ) {
                if(response.isSuccessful) {
                    findViewById<RecyclerView>(R.id.personList).apply {
                        layoutManager =
                            LinearLayoutManager(this@MainActivity)
                        adapter =
                            PersonRecyclerAdapter(response.body()!!.data)
                    }
                }
            }
            override fun onFailure(call: Call<ResponseData>, t: Throwable)
            {
                Log.d("FAIL", t.message.toString())
            }
        })
    }
    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        personAdapter = PersonRecyclerAdapter()
        personAdapter.postItemsList(setupData())
        initView()

    }

    private fun initView() {
        findViewById<RecyclerView>(R.id.personList).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = personAdapter
        }
    }
    private fun setupData(): ArrayList<Persons> {
        val list = ArrayList<Persons>()
        list.add(
            Persons(
                "http://placeimg.com/640/480/people",
                "Pero Perić",
                "1971-09-14",
                "10657 Reichel Lodge Apt. 963"
            )
        )
        list.add(
            Persons(
                "http://placeimg.com/640/480/people",
                "Pero Perić123",
                "1971-09-20",
                "10657 Reichel Lodge Apt. 950"
            )
        )
        return list
    }*/

}