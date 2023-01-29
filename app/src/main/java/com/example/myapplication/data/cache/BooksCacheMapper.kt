package com.example.myapplication.data.cache

import com.example.myapplication.core.Abstract
import com.example.myapplication.core.Book
// сразу для всех книг
interface BooksCacheMapper : Abstract.Mapper {
    fun map(books: List<BookDb>): List<Book>

    class Base(private val mapper: BookCacheMapper) : BooksCacheMapper {
        override fun map(books: List<BookDb>) = books.map { bookDb ->
            bookDb.map(mapper)
        }
    }
}