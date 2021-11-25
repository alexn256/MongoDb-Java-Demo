package util

import com.mongodb.MongoClient
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import org.bson.Document
import java.util.*

object MongoUtil {

    private const val configPath:String = "/db/db.properties"
    private val dbProps:Properties = Properties()

    private val url: String = getProperty("db.url")
    private val port: Int = getProperty("db.port").toInt()
    private val schema: String = getProperty("db.schema")

    private val db: MongoDatabase

    init {
        val inputStream = MongoUtil::class.java.getResource(configPath).openStream()
        dbProps.load(inputStream)
        val client = getClient()
        db = client.getDatabase(schema)
    }

    private fun getProperty(propName: String): String {
        return dbProps.getProperty(propName)
    }

    private fun getClient() = MongoClient(url, port)

    fun getCollection(name: String): MongoCollection<Document> {
        return db.getCollection(name)
    }
}