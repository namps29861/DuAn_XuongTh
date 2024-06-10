package com.example.assignment2.helper

import com.example.assignment2.httpmodels.LoginRequesModel
import com.example.assignment2.httpmodels.LoginResponseModel
import com.example.assignment2.httpmodels.RegisterRequesModel
import com.example.assignment2.httpmodels.RegisterResponseModel
import com.example.lab2.httpmodels.ProductsIdResponseModel
import com.example.lab2.httpmodels.ProductsResponseModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface IRetrofit {
    @POST("users/register")
    fun register(@Body body: RegisterRequesModel) : Call<RegisterResponseModel>

    @POST("/users/login")
    fun login(@Body body: LoginRequesModel) : Call<LoginResponseModel>

    @GET("/products")
    fun getProduct(@Query("page") page: Int?,
                   @Query("limit") limit: Int?,
                   @Query("keywords") keywords: String?) : Call<ProductsResponseModel>

    @GET("/products/getProductId/{id}")
    fun getProductId(@Path("id") id: String?) : Call<ProductsIdResponseModel>
}