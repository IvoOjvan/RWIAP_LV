package hr.ferit.ivoojvan.lv_6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction


class TextViewFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_text_view, container, false)

        val textView = view.findViewById<TextView>(R.id.textView2)

        textView.text = arguments?.getString("Choice").toString()

        val btn_natrag = view.findViewById<Button>(R.id.btnNazad)
        btn_natrag.setOnClickListener {
            val fragmentTransaction : FragmentTransaction? = activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.fragmentView, RadioGroupFragment())
            fragmentTransaction?.commit()
        }


        return view
    }


}