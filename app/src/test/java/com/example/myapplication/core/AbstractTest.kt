package com.example.myapplication.core


import org.junit.Assert.*
import org.junit.Test
import java.io.IOException

import kotlin.Exception

class AbstractTest{
    @Test
    fun test_succes(){
        val dataObject = TestDataObject.Success("a","b")
        val domainObject = dataObject.map(DomainToDataMapper.Base())
        assertTrue(domainObject is DomainObject.Success)
    }
    @Test
    fun test_fail(){
        val dataObject = TestDataObject.Fail(IOException())
        val domainObject = dataObject.map(DomainToDataMapper.Base())
        assertTrue(domainObject is DomainObject.Fail)
    }//

      sealed  class TestDataObject : Abstract.Object<DomainObject, DomainToDataMapper>() {
          abstract override fun map(mapper: DomainToDataMapper): DomainObject
         // чтобы не пробрасывать каждый раз исключение
         class Success (
             private val textOne : String,
             private val textTwo : String) : TestDataObject(){
             override fun map(mapper: DomainToDataMapper): DomainObject {
                 return mapper.map(textOne,textTwo)
             }
         }

        class Fail(ioException: IOException) : TestDataObject(){
            override fun map(mapper:DomainToDataMapper):DomainObject{
                return mapper.map(exception = Exception())
            }

        }
    }

    interface DomainToDataMapper : Abstract.Mapper {

     fun  map(textOne: String, textTwo: String) : DomainObject

     fun map(exception:Exception) : DomainObject

     class Base : DomainToDataMapper{
         override fun map(textOne: String, textTwo: String): DomainObject {
            return DomainObject.Success ("$textOne,$textTwo")
         }

         override fun map(exception: Exception): DomainObject {
             return DomainObject.Fail()
         }

     }
    }

     sealed class  DomainObject : Abstract.Object<UiObject, DomainToUIMapper>() {
         // конконтынация
        class Success(private val  textCombineo : String) : DomainObject(){
            override fun map(mapper: DomainToUIMapper): UiObject {
               TODO("not done yet")
            }

        }
        class Fail : DomainObject(){
            override fun map(mapper: DomainToUIMapper): UiObject {
                TODO("Not done yet")
            }

        }
    }

     interface DomainToUIMapper : Abstract.Mapper

    sealed class UiObject() : Abstract.Object<Unit, Abstract.Mapper.Empty>(){

    }
}