package hr.ferit.ivoojvan.lv_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.RadioButton
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_radio_group.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radioGroupFragment = RadioGroupFragment()
        val textViewFragment = TextViewFragment()

        val fragmentView = findViewById<FrameLayout>(R.id.fragmentView)


        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentView, radioGroupFragment)
            commit()
        }

    }
}