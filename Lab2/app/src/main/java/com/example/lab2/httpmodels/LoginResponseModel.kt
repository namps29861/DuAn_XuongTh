package com.example.assignment2.httpmodels

import com.fasterxml.jackson.annotation.JsonProperty

data class LoginResponseModel(

    @JsonProperty("status") val status: Boolean
)
