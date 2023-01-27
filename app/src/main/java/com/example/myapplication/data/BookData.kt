package com.example.myapplication.data

import com.example.myapplication.core.Abstract
import com.example.myapplication.data.net.BookServerModel
import com.example.myapplication.data.net.BookService
import com.example.myapplication.domain.BookDomain

// данные от сервера получает список книг и мапит их дальше
sealed class BookData  : Abstract.Object<BookDomain, BooksDataToDomainMapper >() {
    class Success(private val books: List<BookServerModel>) : BookData() {
        override fun map(mapper: BooksDataToDomainMapper) : BookDomain {
            return mapper.map(books)
        }
    }
    class Fail(private val e: Exception) : BookData() {
        override fun map(mapper: BooksDataToDomainMapper) : BookDomain {
            return  mapper.map(e)
        }
    }
}