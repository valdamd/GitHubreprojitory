package com.example.myapplication.core

import android.app.Application
import com.example.myapplication.data.net.BookService
import retrofit2.Retrofit

class BookApp : Application() {
    private companion object{
        const val BASE_URL = "https://bible-go-api.rkeplin.com/v1/"
    }



    override fun onCreate() {
        super.onCreate()
    }

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .build()
    val service = retrofit.create(BookService::class.java)
}