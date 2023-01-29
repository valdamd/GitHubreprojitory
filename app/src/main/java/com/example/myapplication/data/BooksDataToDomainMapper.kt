package com.example.myapplication.data

import com.example.myapplication.core.Abstract
import com.example.myapplication.core.Book
import com.example.myapplication.domain.BookDomain

interface BooksDataToDomainMapper : Abstract.Mapper {
    fun map(books: List<Book>): BookDomain // список книг
    fun map(e: Exception): BookDomain


}