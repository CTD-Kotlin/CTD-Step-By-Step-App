package com.example.stepbystepapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * 07 A singleton instance of a RetroFit Object.
 *
 * RetroFit is a very powerful library that will write code for us
 * to handle requesting data from an api in the background and parsing
 * the JSON to Kotlin Objects that can be used in code.
 *
 * A singleton is a way of ensuring that only one instance of an Object
 * is created at a time.
 *
 * @author Marshall Ladd
 */
class RetroFitInstance {
    // companion object is very similar to the Java static
    companion object {
        /*
        This is the part of the URL that never changes
        It is a constant value, and its name is in all caps to signify that.
        */
        val BASE_URL = "http://dummy.restapiexample.com/api/v1/employees"

        // This private variable is where the actual RetroFit is located
        // It is a singleton and its name is in all caps to signify that.
        private var INSTANCE: Retrofit? = null
        // This is the value used to give access to the single RetroFit instance
        val retrofit: Retrofit
            // Custom get works similar to the custom set in our ViewHolder.
            get() {
                // If INSTANCE is null, create a new one.
                INSTANCE?.let {
                    // Call to the RetroFit Builder to build our RetroFit
                    INSTANCE = Retrofit.Builder()
                            // Sets the URL
                            .baseUrl(BASE_URL)
                            // Tells RetroFit that we will be getting JSON and would like to
                            // convert it to Kotlin objects useing the GSON converter library.
                            .addConverterFactory(GsonConverterFactory.create())
                            // Finally builds our RetroFit
                            .build()
                }
                // Since our custom getter sets a value to INSTANCE if it is null,
                // we can be 100% confident that when we reach this return line,
                // INSTANCE will no longer be null, and that is the reason for the
                // double '!'.  Try removing them to see what happens if you'd like.
                return INSTANCE!!
            }
    }
}
