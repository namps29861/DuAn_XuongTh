package com.example.assignment.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Product_Id(
    @JsonProperty("_id") val _id: String?,
    @JsonProperty("name") val name: String?,
    @JsonProperty("price") val price: Double?,
    @JsonProperty("stock") val stock: Int?,
    @JsonProperty("images") val images: List<String>?,
    @JsonProperty("description") val description: String?,
    @JsonProperty("category") val category: Category?,
    @JsonProperty("createdAt") val createdAt: String?,
    @JsonProperty("updatedAt" ) val updatedAt: String?,
    @JsonProperty("__v") val __v: Int?
)
