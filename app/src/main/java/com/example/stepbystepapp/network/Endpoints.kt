package com.example.stepbystepapp.network

import com.example.stepbystepapp.models.Employee
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

/**
 * 07 This is where the magic happens.
 *
 * This class is where we define our API endpoints.  We mark each function
 * with an @ notation to specify the type of request we want to perform.
 * We also pass in the second part of the API's URL.
 *
 * When we compile our app, RetroFit writes code for us that handles, switching
 * to a background thread to make sure the UI does not freeze during the request,
 * calling the endpoint, waiting for a response, and parsing the response into
 * Kotlin Objects.
 *
 * @author Marshall Ladd
 */
interface Endpoints {

    // Simple get request to get a list of all employees
    // Call is a generic class that returns the API
    // response, parsed to Kotlin Objects.
    @GET("api/v1/employees")
    fun getEmployeeList(): Call<List<Employee>>

    // A request to get an employee based on their employee id #.
    // In the URL, we wrap what could change in {} and give it a name.
    // Then, use @Path(variableName) in the arguments to the function.
    // The value to be placed in the URL can then be passed in
    // dynamically at runtime.
    @GET("api/v1/employees/{employeeId}")
    fun getEmployeeById(@Path("employeeId") employeeId: Int): Call<Employee>

    // If your endpoint requires an API token, here is how the first call would look.
    @GET("api/v1/employees")
    fun getEmployeeListRequireToken(@Header("x-api-key") key: String): Call<List<Employee>>
}