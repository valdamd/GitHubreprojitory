package com.example.myapplication.data.net

import com.example.myapplication.core.Abstract
import com.example.myapplication.data.BookData

interface BookServerToDataMapper : Abstract.Mapper {
    fun map(id : Int, name: String) : BookData
}