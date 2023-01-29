package com.example.myapplication.data

import com.example.myapplication.data.net.BookCloud
import com.example.myapplication.data.net.BookService

interface BooksCloudDataSourse {

    suspend fun fetchBooks() : List<BookCloud>

    class Base(private val service : BookService) : BooksCloudDataSourse {
        override suspend fun fetchBooks(): List<BookCloud> {
            return service.fetchBooks()
        }
    }
}