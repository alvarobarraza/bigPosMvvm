package com.example.bigposmvvm.util

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException


class HostSelectionInterceptor : Interceptor {
    @Volatile
    private var host: String? = null

    fun setHost(host: String?) {
        this.host = HttpUrl.parse(host)!!.host()
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = chain.request()
        val reqUrl: String = request.url().host()
        val host = host
        if (host != null) {
            val newUrl: HttpUrl = request.url().newBuilder()
                .host(host)
                .build()
            request = request.newBuilder()
                .url(newUrl)
                .build()
        }
        return chain.proceed(request)
    }
}