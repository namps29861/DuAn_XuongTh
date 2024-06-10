package com.example.lab2.httpmodels

import com.example.assignment.model.Product
import com.example.assignment.model.Product_Id
import com.fasterxml.jackson.annotation.JsonProperty

data class ProductsResponseModel(

    @JsonProperty("status") val status: Boolean,
    @JsonProperty("data") val data: List<Product>
)

data class ProductsIdResponseModel(

    @JsonProperty("status") val status: Boolean,
    @JsonProperty("data") val data: Product_Id
)

