package com.example.phoneui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.phoneui.databinding.ActivityMainBinding
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private val BASE_URL = "http://10.0.2.2:3000"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        registerUser()
    }

    private fun registerUser() {
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi::class.java)

        api.register().enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful) {
                    val responseData = response.body()
                    Log.e("API TEST:", "Response: $responseData")
                } else {
                    Log.e("API TEST:", "Error: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.e("API FAIL:", t.message.toString())
            }

        })
    }
}