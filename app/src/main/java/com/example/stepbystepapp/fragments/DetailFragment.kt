package com.example.stepbystepapp.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.stepbystepapp.R
import kotlinx.android.synthetic.main.fragment_detail.*

/**
 * @author Marshall Ladd
 */
class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // 08 Retrieve the bundle passed to the Fragment
        // Check if it is null or now
        arguments?.let {
            // If not null, get the values and set them to the appropriate TextViews
            textViewEmployeeName.text = it.getString(getString(R.string.EMP_NAME))
            textViewSalary.text = "${it.getInt(getString(R.string.EMP_SALARY))}"
            textViewAge.text = "${it.getInt(getString(R.string.EMP_NAME))}"
            textViewEID.text = "${it.getInt(getString(R.string.EMP_ID))}"
        }
    }

}
