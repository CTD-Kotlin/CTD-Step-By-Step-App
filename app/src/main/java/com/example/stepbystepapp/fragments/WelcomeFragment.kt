package com.example.stepbystepapp.fragments

// TODO Step 03

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.stepbystepapp.R

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // This line is what links the XML layout to the Kotlin Fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

}
