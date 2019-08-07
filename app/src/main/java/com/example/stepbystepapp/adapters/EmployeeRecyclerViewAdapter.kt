package com.example.stepbystepapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.stepbystepapp.R
import com.example.stepbystepapp.models.Employee

/**
 * 06 This is the ListAdapter class.
 *
 * It is responsible for creating ViewHolders, binding them to data,
 * and adding them to the RecyclerView.  When extending ListAdapter,
 * make sure to extend the 'androidx' ListAdapter, and not the other
 * one.
 *
 * ListAdapter is a class that takes advantage of a concept known as
 * generics. In this case, inside the <>, we are first telling our
 * ListAdapter what Type will our list of data contain, and second,
 * what is the name of the ViewHolder that will display the Object.
 *
 * ListAdapter requires a DiffUtil.ItemCallback, which we create and
 * describe at the end of this file.
 *
 * Our ListAdapter constructor has a single parameter, which has a
 * Type of a lambda function.  The lambda take and Employee and
 * returns nothing(Unit). This lambda will be created in our Fragment
 * when we instantiate our ListAdapter.
 *
 * @author Marshall Ladd
 */
class EmployeeRecyclerViewAdapter(private val onClick: (Employee) -> Unit) : ListAdapter<Employee, EmployeeViewHolder>(EmployeeDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        /*
        06 Creates the View and links the XML layout file to the Kotlin, similar to how Fragments
        are created.  This gets a LayoutInflater from the Fragment that the Adapter is instantiated
        in, then inflates the XML file we created to display the Employee name in the RecyclerView.
        */
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_employee, parent, false)
        /* 06 We then link that View to our ViewHolder. This ViewHolder will then be passed on to
        onBindViewHolder to have an Object from the list bound to it for display. We also pass
        the onClick lambda to the ViewHolder, to be used in the onClickListener.
        */
        return EmployeeViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        /*
        06 Binds the data to the ViewHolder. The holder comes from the ViewHolder
        created in the onCreateViewHolder method. position comes from the index
        of where a specific ViewHolder is in the overall RecyclerView.

        The getItem function gets the list of data that was passed to the
        Adapter in the Fragment.
        */
        holder.employee = getItem(position)
    }
}

class EmployeeViewHolder(itemView: View, private val onClick: (Employee) -> Unit) : RecyclerView.ViewHolder(itemView) {
    // 06 holds the data that is bound to this ViewHolder
    var employee: Employee? = null
        /*
        06 Custom setter is used to ensure that if a null value is somehow, bound
        to a ViewHolder, it is not displayed, preventing a NullPointerException,
        which prevents the app from crashing.

        value is the Object that you are attempting to set employee to.
        */
        set(value) {
            // checks if value is null, if not executes the code inside the {}
            value?.let {
                // field represents the variable employee.  This actually sets the value of employee
                field = it
                // Finds the TextView from the XML inflated in our ViewHolder, and sets the text
                // to the employeeName.
                itemView.findViewById<TextView>(R.id.textViewVHEmployeeName).text = it.employeeName
                /* This makes the entire ViewHolder clickable. It does this by using the lambda
                we passed in when we instantiated our adapter.  The onClick takes an Employee as an
                argument.
                */
                itemView.setOnClickListener { _ -> onClick(it) }
                /* Further reading and an explanation of 'it' and '_' can be found at the following
                link. https://kotlinlang.org/docs/reference/lambdas.html
                */
            }
        }
}

/**
 * 06 This class is responsible for handling changes in your data.
 *
 * It calls to methods that compare the Objects in your list to each
 * other, and animates changes in the RecyclerView, instead of things
 * just abruptly resetting and jumping around the screen.
 */
class EmployeeDiffCallback : DiffUtil.ItemCallback<Employee>() {
    override fun areItemsTheSame(oldItem: Employee, newItem: Employee): Boolean {
        // 06 Items are the same if they are saved in the same location in memory.
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Employee, newItem: Employee): Boolean {
        /*
        06 Because we used a 'data' class for our Employee Object, we get an implementation
        of the equals function for us, that compares the content of two Objects.
         */
        return oldItem == newItem
    }
}