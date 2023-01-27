package com.example.myapplication.data
// берет из кэша книжки и передает дальше не будет краша без интернета
interface BooksReprository {

    suspend fun fetchBooks(): BookData

    class Base(private val casheDataSourse: BooksCloudDataSourse) : BooksReprository {
        override suspend fun fetchBooks() : BookData = try {
                 BookData.Success(casheDataSourse.fetchBooks())
            } catch (e: Exception) {
                  BookData.Fail(e)
            }

        }
    }
