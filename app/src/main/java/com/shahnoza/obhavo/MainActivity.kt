package com.shahnoza.obhavo

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.shahnoza.obhavo.databinding.ActivityMainBinding
import com.shahnoza.obhavo.models.Weather
import com.shahnoza.obhavo.retrofit.Common
import com.shahnoza.obhavo.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val TAG = "MainActivity"

/**
 * Owner: Nabiyeva Shahnoza
 * Using: open weather site
 * Api dagi ma`lumotlarning o`zgaruvchi nomlari bir xil bo`lishi shart
 * https://openweathermap.org/forecast5
 * o`qishingiz kerak bo`lgan narsa: com/shahnoza/ob havo
 */
class MainActivity : AppCompatActivity() {
    lateinit var retrofitService: RetrofitService
    lateinit var binding: ActivityMainBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofitService = Common.retrofitService
        // barcha malumotlarni olish
        retrofitService.getData().enqueue(object : Callback<Weather> {
            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                if (response.isSuccessful) {
                    Log.d(TAG, "onResponse: ${response.body()}")

                    // country - null kelyabd
                    binding.tv.text = " ${response.body()}"

                }
            }

            override fun onFailure(call: Call<Weather>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }
        })


    }




}

