package repository

import org.bson.conversions.Bson

/**
 * Describes basic CRUD operations for MongoDb collection.
 */
interface BaseMongoRepository<T> {

    /**
     * Delete document from collection by ObjectId
     */
    fun deleteById(id: String)

    /**
     * Insert new document to collection.
     */
    fun insert()

    /**
     * Update existed document in collection.
     */
    fun update()

    /**
     * Return all documents from collection.
     */
    fun findAll(): List<T>

    /**
     * Return single existed document from collection by ObjectId.
     */
    fun findById(id: String)

    /**
     * Return single existed document from collection by filter.
     */
    fun findByFilter(filter: Bson): T
}