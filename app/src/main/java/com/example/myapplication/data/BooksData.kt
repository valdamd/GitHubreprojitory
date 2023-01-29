package com.example.myapplication.data

import com.example.myapplication.core.Abstract
import com.example.myapplication.core.Book
import com.example.myapplication.domain.BookDomain

// данные от сервера получает список книг и мапит их дальше
sealed class BooksData  : Abstract.Object<BookDomain, BooksDataToDomainMapper >() {
    class Success(private val books: List<Book>) : BooksData() {
        override fun map(mapper: BooksDataToDomainMapper) = mapper.map(books)
    }
    class Fail(private val e: Exception) : BooksData() {
        override fun map(mapper: BooksDataToDomainMapper)  = mapper.map(e)
    }
}