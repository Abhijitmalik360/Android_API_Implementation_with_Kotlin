package com.razorpay.apiimplemenction

import MyData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val apiResponse: Parcelable? = intent.getParcelableExtra("apiResponse")
        apiResponse?.let {
           Log.e("HIIII",""+apiResponse)
        }


    }
}