package com.example.myapplication.data

import com.example.myapplication.data.net.BookServerModel
import com.example.myapplication.data.net.BookService

interface BooksCloudDataSourse {

    suspend fun fetchBooks() : List<BookServerModel>

    class Base(private val service : BookService) : BooksCloudDataSourse {
        override suspend fun fetchBooks(): List<BookServerModel> {
            return service.fetchBooks()
        }
    }
}