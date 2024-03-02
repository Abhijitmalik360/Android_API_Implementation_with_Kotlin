package com.razorpay.apiimplemenction

import MyData
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
  @GET("products")
  fun getProductdata():Call<MyData>


}