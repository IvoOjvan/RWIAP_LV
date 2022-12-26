package hr.ferit.ivoojvan.finalproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Switch
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException


class CurrencyFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_currency, container, false)

        val imgBtnBack = view.findViewById<ImageButton>(R.id.imageButtonBack)
        val imgBtnCurrencyDropdown = view.findViewById<ImageButton>(R.id.imgBtnBaseCurrencyDropdown)
        val imgBtnToCurrencyDropdown = view.findViewById<ImageButton>(R.id.imageButtonToCurrencyDropdown)

        val btnCalculate = view.findViewById<Button>(R.id.buttonCalculate)

        val textView = view.findViewById<TextView>(R.id.textView4)

        val etAmount = view.findViewById<EditText>(R.id.editTextAmount)
        val etCurr = view.findViewById<AutoCompleteTextView>(R.id.autoCompleteTextViewCurrency)
        val etCurrConverter = view.findViewById<AutoCompleteTextView>(R.id.autoCompleteTextViewConverter)

        val currencies = arrayOf("HRK", "AUD", "CAD", "CZK", "DKK", "HUF", "NOK", "SEK", "CHF", "GBP", "RSD", "EUR", "BAM", "PLN")
        val adapter = ArrayAdapter(view.context, android.R.layout.simple_list_item_1, currencies)
        etCurr.setAdapter(adapter)
        etCurrConverter.setAdapter(adapter)


        imgBtnCurrencyDropdown.setOnClickListener {
            etCurr.showDropDown()
        }

        imgBtnToCurrencyDropdown.setOnClickListener {
            etCurrConverter.showDropDown()
        }


        imgBtnBack.setOnClickListener {
            val fragmentTransaction : FragmentTransaction? = activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.fragment_layout, MainFragment())
            fragmentTransaction?.commit()
        }


        btnCalculate.setOnClickListener {
            val baseCurrency : String = etCurr.text.toString()
            val toCurrecy : String = etCurrConverter.text.toString()
            val amount : String = etAmount.text.toString()

            val request = ServiceBuilder.buildService(ExchangeRateAPI::class.java)
            val call = request.getNewCurrency(baseCurrency, toCurrecy, amount)

            call.enqueue(object: Callback<ConvertedCurrency>{
                override fun onResponse(
                    call: Call<ConvertedCurrency>,
                    response: Response<ConvertedCurrency>
                ) {
                    if(response.isSuccessful){
                        textView.text = response.body()?.new_amount.toString() + response.body()?.new_currency
                    }
                }

                override fun onFailure(call: Call<ConvertedCurrency>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })

        }

        return view
    }

}