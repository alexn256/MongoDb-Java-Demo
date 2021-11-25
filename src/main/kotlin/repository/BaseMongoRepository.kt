package repository

import org.bson.conversions.Bson

interface BaseMongoRepository<T> {
    fun deleteById(id: String)
    fun insert()
    fun update()
    fun findAll(): List<T>
    fun findById(id: String)
    fun findByFilter(filter: Bson): T
}