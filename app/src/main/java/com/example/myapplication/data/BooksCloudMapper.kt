package com.example.myapplication.data

import com.example.myapplication.core.Abstract
import com.example.myapplication.core.Book
import com.example.myapplication.data.cache.BookDb
import com.example.myapplication.data.net.BookCloud
import com.example.myapplication.data.net.BookCloudMapper

// переиспользуем BookCloudMapper здесь
interface BooksCloudMapper : Abstract.Mapper {
    // спсиок из книг от сети от сервера
    fun map (cloudList: List<BookCloud>) : List<Book>


    class Base(private val bookMapper : BookCloudMapper) : BooksCloudMapper{
        override fun map(cloudList: List<BookCloud>): List<Book> {// замапить с списку книг которое есть целовое решение
            return cloudList.map { bookCloud ->
                bookCloud.map(bookMapper)
            }
        }
    }
}