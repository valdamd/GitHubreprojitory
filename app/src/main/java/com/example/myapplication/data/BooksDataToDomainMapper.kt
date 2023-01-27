package com.example.myapplication.data

import com.example.myapplication.core.Abstract
import com.example.myapplication.data.net.BookServerModel
import com.example.myapplication.domain.BookDomain
import retrofit2.HttpException
import java.net.HttpCookie
import java.net.UnknownHostException

interface BooksDataToDomainMapper : Abstract.Mapper {
    fun map(books: List<BookServerModel>): BookDomain
    fun map(e: Exception): BookDomain

    class Base :  BooksDataToDomainMapper {
        override fun map(books: List<BookServerModel>): BookDomain {

            return BookDomain.Succsess()
        }

        override fun map(e: Exception): BookDomain {
            var errorType = when(e){
               is UnknownHostException -> 8
                is HttpException -> 1
                else -> 2
            }
          return  BookDomain.Fail()
        }
    }
}