package repository

import com.mongodb.client.MongoCollection
import org.bson.Document
import org.bson.conversions.Bson
import org.bson.types.ObjectId
import util.MongoUtil
import java.lang.IllegalArgumentException

/**
 * Base MongoDb repository.
 *
 * @param name MongoDb collection name.
 */
abstract class AbstractMongoRepository<T>(
    private val name: String,
    private val type: Class<T>
    ) : BaseMongoRepository<T> {

    private val collection: MongoCollection<T> = MongoUtil.getCollection(name, type)

    override fun deleteById(id: String) {
        try {
            val result = collection.deleteOne(Document("_id", ObjectId(id)))
            println("${result.deletedCount} $name were deleted.")
        } catch (e: Exception) {
            throw e
        }
    }

    override fun insert(entity: T) {
        try {
            collection.insertOne(entity)
            println("One entity $entity was inserted.")
        } catch (e: Exception) {
            throw e
        }
    }

    override fun insertMany(entities: List<T>) {
        try {
            collection.insertMany(entities)
            println("${entities.size} entities were inserted.")
        } catch (e: Exception) {
            throw e
        }
    }

    override fun update() {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<T> {
        try {
            val entities = collection.find().toList()
            if (entities.isNotEmpty()) {
                println("${entities.size} entities were read from database.")
            }
            return entities
        } catch (e: Exception) {
            throw e
        }
    }

    override fun findById(id: String) {
        TODO("Not yet implemented")
    }

    override fun findByFilter(filter: Bson): T {
        try {
            val result = collection.find()
            println("1 entity was read from database.")
            return result.first()
        } catch (e: Exception) {
            throw e
        }
    }
}