package com.example.stepbystepapp.fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.stepbystepapp.R
import com.example.stepbystepapp.adapters.EmployeeRecyclerViewAdapter
import com.example.stepbystepapp.models.Employee
import kotlinx.android.synthetic.main.fragment_recycler_view.*

/**
 * @author Marshall Ladd
 */
class RecyclerViewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler_view, container, false)
    }

    // 06
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        /*
        06 Create a ListAdapter for the RecyclerView, passing it a lambda function
        that takes an employee as an argument. At this stage, we do nothing with employee.
        The lambda's current function is to move us to the next screen

        NOTE: This section of code will change again in a future step. Lines marked with
        steps beyond 06 can be left out for now, but must be added later.
         */
        val adapter = EmployeeRecyclerViewAdapter { employee ->
            // 06
            findNavController().navigate(R.id.action_recyclerViewFragment_to_detailFragment)
        }
        /*
        06 Link our adapter to the RecyclerView

        recyclerView is the id of the RecyclerView in our XML file.  We get access to it
        using Kotlin synthetics.
         */
        recyclerView.apply {
            this.adapter = adapter
            // 06 A Fragment's Context is nullable.  This checks if it is or not.
            context?.let {
                /*
                06 A RecyclerView requires a LayoutManager. A LinearLayoutManager gives
                us vertical scrolling rows. There are LayoutManagers for creating grids and
                going horizontal as well. All require a Context Object, represented by 'it'.
                 */
                this.layoutManager = LinearLayoutManager(it)
            }
        }

        // 06_2 Uncomment the next line during this step for testing the RecyclerView
        displayTestData(adapter)
    }

    /** 06_2 This creates a set of test data and submits it to our adapter, to be displayed
     * in the RecyclerView.
     *
     * NOTE: This function is only for testing our RecyclerView. We can remove this code
     * immediately after testing is successful. It will be replaced with our actual data
     * source in a future step.
    */
    private fun displayTestData(adapter: EmployeeRecyclerViewAdapter) {
        val testData = listOf(
                Employee(1, "test1", 85000, 32, ""),
                Employee(2, "test2", 85000, 32, ""),
                Employee(3, "test3", 85000, 32, ""))
        adapter.submitList(testData)
    }
}
