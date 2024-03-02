package com.razorpay.apiimplemenction

import MyData
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Button2:Button=findViewById(R.id.anhijit)



        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiInterface::class.java)
        val call = apiService.getProductdata()

        call.enqueue(object : Callback<MyData> {
            override fun onResponse(call: Call<MyData>, response: Response<MyData>) {
                if (response.isSuccessful) {


                    val apiResponse = response.body()
                    Button2.setOnClickListener {


                        val nextIntent = Intent(this@MainActivity, MainActivity2::class.java)
                        nextIntent.putExtra("apiResponse", apiResponse)
                        startActivity(nextIntent)
                    }


                    apiResponse?.let {
                        for (product in it.products) {
                            Log.e("Product", "Title: ${product.images}, Price: ${product.price}")

                        }


                    }
                } else {
                    Log.e("API Call", "Failed to fetch data")

                }
            }

            override fun onFailure(call: Call<MyData>, t: Throwable) {
                Log.e("API Call", "Error: ${t.message}")
            }
        })
    }
}
