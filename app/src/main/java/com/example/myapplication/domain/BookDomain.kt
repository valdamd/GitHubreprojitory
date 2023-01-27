package com.example.myapplication.domain

import com.example.myapplication.core.Abstract
import com.example.myapplication.data.net.BookServerModel
import com.example.myapplication.presitation.BookUi
sealed class BookDomain : Abstract.Object<BookUi, Abstract.Mapper.Empty>() {
      class Succsess() : BookDomain(){
          override fun map(mapper: Abstract.Mapper.Empty): BookUi {
              TODO("Not yet implemented")
          }
      }

    class Fail() : BookDomain(){
        override fun map(mapper: Abstract.Mapper.Empty): BookUi {
            TODO("Not yet implemented")
        }
    }
}