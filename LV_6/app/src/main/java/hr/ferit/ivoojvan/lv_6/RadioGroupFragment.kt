package hr.ferit.ivoojvan.lv_6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.FragmentTransaction


class RadioGroupFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_radio_group, container, false)

        val radioGroup = view.findViewById<RadioGroup>(R.id.radioGroup)

        val btn_naprijed = view.findViewById<Button>(R.id.btnNaprijed)
        btn_naprijed.setOnClickListener{
            if(radioGroup.getCheckedRadioButtonId() != -1)
            {
                val selectedRadioButton = view.findViewById<RadioButton>(radioGroup.checkedRadioButtonId)

                val sureFragment = TextViewFragment()
                val bundle = Bundle()
                bundle.putString("Choice", selectedRadioButton.text.toString())
                sureFragment.arguments = bundle

                val fragmentTransaction : FragmentTransaction? = activity?.supportFragmentManager?.beginTransaction()
                fragmentTransaction?.replace(R.id.fragmentView, sureFragment)
                fragmentTransaction?.commit()
            }
        }

        return view
    }


}