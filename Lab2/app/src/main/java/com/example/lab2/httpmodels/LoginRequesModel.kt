package com.example.assignment2.httpmodels

import com.fasterxml.jackson.annotation.JsonProperty

data class LoginRequesModel(
    @JsonProperty("email") val email: String?,
    @JsonProperty("password") val password: String?,

)
