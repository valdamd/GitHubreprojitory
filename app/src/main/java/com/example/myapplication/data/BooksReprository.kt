package com.example.myapplication.data

import com.example.myapplication.data.cache.BooksCacheDataSource
import com.example.myapplication.data.cache.BooksCacheMapper

// берет из кэша книжки и передает дальше не будет краша без интернета
interface BooksReprository {

    suspend fun fetchBooks(): BooksData

    class Base(
        private val cloudDataSourse: BooksCloudDataSourse,
        private val cacheDataSource: BooksCacheDataSource,
        private val booksCloudMapper: BooksCloudMapper,
        private val booksCacheMapper: BooksCacheMapper
    ) : BooksReprository {
        override suspend fun fetchBooks(): BooksData = try {
            // получем данные из сохраненного места
            val booksCacheList = cacheDataSource.fetchBooks()
            if (booksCacheList.isEmpty()) {
                val booksCloudList = cloudDataSourse.fetchBooks()
                val books = booksCloudMapper.map(booksCloudList)
                cacheDataSource.saveBooks(books)
                BooksData.Success(books)
            } else {
                BooksData.Success(booksCacheMapper.map(booksCacheList))
            }

        } catch (e: Exception) {
            BooksData.Fail(e)
        }

    }
}




