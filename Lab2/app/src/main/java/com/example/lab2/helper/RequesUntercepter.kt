package com.example.assignment2.helper

import okhttp3.Interceptor
import okhttp3.Response

object RequesUntercepter : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()
            return chain.proceed(request)

    }
}