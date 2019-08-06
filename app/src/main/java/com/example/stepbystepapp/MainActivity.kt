package com.example.stepbystepapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {

    // 05 Get a reference to the NavController
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        05 Actually get your NavController from the activity layout XML
        The value passed to the findNavController function is the ID of
        the NavHostFragment we just added in the previous step.
        */
        navController = findNavController(R.id.navHostFragment)
        /*
        05 This line connects the NavController to the ActionBar, which
        is the top title bar in your app.  This will make sure the back
        arrow and titles are displayed properly, and more.
        */
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    /*
    05 Override this function to get the back arrow to function properly
     */
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
