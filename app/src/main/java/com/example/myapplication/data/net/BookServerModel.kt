package com.example.myapplication.data.net

import com.example.myapplication.core.Abstract
import com.example.myapplication.data.BookData
import com.google.gson.annotations.SerializedName

/* будем сравнивать через Unit test data автоматом генерирует hashcode eguels
* {"id":1,"name":"Genesis","testament":"OT","genre":{"id":1,"name":"Law"}}
* */


data class BookServerModel(
    @SerializedName("id")
    private val id: Int,
    @SerializedName("name")
    private val name: String
) : Abstract.Object<BookData, BookServerToDataMapper>() {
    override fun map(mapper: BookServerToDataMapper) : BookData {
        return mapper.map(id, name)
    }


}