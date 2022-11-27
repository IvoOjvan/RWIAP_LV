package hr.ferit.ivoojvan.ormwa_lv1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView1 = findViewById<TextView>(R.id.textView1)
        val textView2 = findViewById<TextView>(R.id.textView2)
        val textView3 = findViewById<TextView>(R.id.textView3)


        val editText1 = findViewById<EditText>(R.id.editText1)
        val editText2 = findViewById<EditText>(R.id.editText2)
        val editText3 = findViewById<EditText>(R.id.editText3)
        val editText4 = findViewById<EditText>(R.id.editText4)

        val input_btn = findViewById<Button>(R.id.input_btn)
        input_btn.setOnClickListener{
            textView1.text = editText1.text.toString()
            textView2.text = editText2.text.toString()
        }

        val calculate_btn = findViewById<Button>(R.id.calculate_btn)

        calculate_btn.setOnClickListener{
            var height : Float = editText3.text.toString().toFloat() / 100
            var weight : Float = editText4.text.toString().toFloat()
            var result : Float = calculateBMI(height, weight)
            textView3.text = result.toString()
            Toast.makeText(this, result.toString(),
                Toast.LENGTH_LONG).show()
        }

    }

    fun calculateBMI(height:Float, weight:Float) : Float{
        return weight / ( height * height)
    }

}