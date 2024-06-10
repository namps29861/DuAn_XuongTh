package com.example.assignment2.helper

import android.util.Log
import com.example.assignment2.httpmodels.LoginRequesModel
import com.example.assignment2.httpmodels.LoginResponseModel
import com.example.assignment2.httpmodels.RegisterRequesModel
import com.example.assignment2.httpmodels.RegisterResponseModel
import com.example.lab2.httpmodels.ProductsIdResponseModel
import com.example.lab2.httpmodels.ProductsResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RetrofitAPI {
    private val retrofit = RetrofitClient.getClient()
    private val iRetrofit = retrofit.create(IRetrofit::class.java)

    fun register(body: RegisterRequesModel,
                 callback: (RegisterResponseModel?) -> Unit){
        iRetrofit.register(body).enqueue(
            object : Callback<RegisterResponseModel> {
                override fun onResponse(call: Call<RegisterResponseModel>,
                                        response: Response<RegisterResponseModel>
                ) {
                    if (response.isSuccessful) {
                        val registerResponseModel = response.body()
                        callback(registerResponseModel)
                    } else {
                        Log.d(">>>Failed to register", response.message())
                    }
                }

                override fun onFailure(call: Call<RegisterResponseModel>, t: Throwable) {
                    Log.d("Failed to register", t.message ?: "Unknown error")
                }
            })
    }

    fun login(body: LoginRequesModel ,
                 callback: (LoginResponseModel?) -> Unit){
        iRetrofit.login(body).enqueue(
            object : Callback<LoginResponseModel> {
                override fun onResponse(call: Call<LoginResponseModel>,
                                        response: Response<LoginResponseModel>
                ) {
                    if (response.isSuccessful) {
                        val loginResponseModel = response.body()
                        callback(loginResponseModel)
                    } else {
                        Log.d(">>>Failed to register", response.message())
                    }
                }

                override fun onFailure(call: Call<LoginResponseModel>, t: Throwable) {
                    Log.d("Failed to register", t.message ?: "Unknown error")
                }
            })
    }

    fun getProducts(query: Int?, query2: Int?, query3: String?,
                    callback: (ProductsResponseModel?) -> Unit){
        iRetrofit.getProduct(query, query2, query3).enqueue(
            object : Callback<ProductsResponseModel> {
                override fun onResponse(call: Call<ProductsResponseModel>,
                                        response: Response<ProductsResponseModel>
                ) {
                    if (response.isSuccessful) {
                        val productsResponseModel = response.body()
                        callback(productsResponseModel)
                    } else {
                        Log.d(">>>Failed to register", response.message())
                    }
                }

                override fun onFailure(call: Call<ProductsResponseModel>, t: Throwable) {
                    Log.d("Failed to register", t.message ?: "Unknown error")
                }
            })
    }

    fun getProductsId(params: String?,
                      callback: (ProductsIdResponseModel?) -> Unit){
        iRetrofit.getProductId(params).enqueue(
            object : Callback<ProductsIdResponseModel> {
                override fun onResponse(call: Call<ProductsIdResponseModel>,
                                        response: Response<ProductsIdResponseModel>
                ) {
                    if (response.isSuccessful) {
                        val productsIdResponseModel = response.body()
                        callback(productsIdResponseModel)
                    } else {
                        Log.d(">>>Failed to register", response.message())
                    }
                }

                override fun onFailure(call: Call<ProductsIdResponseModel>, t: Throwable) {
                    Log.d("Failed to register", t.message ?: "Unknown error")
                }
            })
    }
}