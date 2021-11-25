package repository

import com.mongodb.client.MongoCollection
import org.bson.Document
import org.bson.conversions.Bson
import org.bson.types.ObjectId
import util.MongoUtil

/**
 * @param name MongoDb collection.
 */
abstract class AbstractMongoRepository<T>(private val name: String) : BaseMongoRepository<T> {

    private val collection: MongoCollection<Document> = MongoUtil.getCollection(name)

    override fun deleteById(id: String) {
        try {
            val result = collection.deleteOne(Document("_id", ObjectId(id)))
            println("${result.deletedCount} $name were deleted.")
        } catch (e: Exception) {
            throw e
        }
    }

    override fun insert() {
        TODO("Not yet implemented")
    }

    override fun update() {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<T> {
        TODO("Not yet implemented")
    }

    override fun findById(id: String) {
        TODO("Not yet implemented")
    }

    override fun findByFilter(filter: Bson): T {
        TODO("Not yet implemented")
    }
}