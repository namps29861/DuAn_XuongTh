package com.example.assignment2.httpmodels

import com.fasterxml.jackson.annotation.JsonProperty

data class RegisterRequesModel(
    //username, email, phoneNumber, password, confirm
    @JsonProperty("username") val username: String,
    @JsonProperty("email") val email: String,
    @JsonProperty("phoneNumber") val phoneNumber: String,
    @JsonProperty("password") val password: String,
    @JsonProperty("confirm") val confirm: String
)
