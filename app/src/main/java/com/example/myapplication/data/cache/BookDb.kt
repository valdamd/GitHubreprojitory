package com.example.myapplication.data.cache

import com.example.myapplication.core.Abstract
import com.example.myapplication.core.Book
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
// PrimaryKey по кторому будет различать книги
open class BookDb : RealmObject(), Abstract.Mapable<Book, BookCacheMapper> {
    @PrimaryKey
    var id: Int = -1
    var name: String = ""

    override fun map(mapper: BookCacheMapper): Book {
        return Book(id, name)
    }


}