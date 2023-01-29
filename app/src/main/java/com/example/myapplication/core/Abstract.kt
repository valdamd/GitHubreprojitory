package com.example.myapplication.core

abstract class Abstract {
    /*все мои дата объекты должны наследоваться от главного объекта имеют способность преобразовываться
    к другому типу с помощью мапера
    * */

    abstract class Object<T , M : Mapper>{

        abstract fun map(mapper: M) : T
    }

    interface Mapable<T, M : Mapper> {
        fun map(mapper: M): T
    }

   interface Mapper {


       // если не к чему мапить
       class Empty : Mapper
   }
}