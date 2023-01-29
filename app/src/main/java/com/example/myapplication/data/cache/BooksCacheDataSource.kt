package com.example.myapplication.data.cache

import com.example.myapplication.core.Book

// use вместо try catch оно может уничтожиться
interface BooksCacheDataSource {
    fun fetchBooks() : List<BookDb>

    fun saveBooks(books: List<Book>)


    class Base(private val realmProvider: RealmProvider) : BooksCacheDataSource {
        override fun fetchBooks(): List<BookDb> {
            realmProvider.provide().use { realm ->
               val bookDb = realm.where(BookDb::class.java).findAll()?: emptyList()// если ничего не будет в кеше
               return realm.copyFromRealm(bookDb)
                
            }
        }
// проходится по всем книжкам создает элементы bookDb эдементы
        override fun saveBooks(books: List<Book>) {
            realmProvider.provide().use {realm ->
                realm.executeTransaction{
                    books.forEach { book ->
                        val bookDb = it.createObject(BookDb::class.java, book.id)
                        bookDb.name = bookDb.name
                    }
                }
            }
        }
    }

}