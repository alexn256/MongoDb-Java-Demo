package util

import com.mongodb.MongoClient
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import model.Address
import model.Person
import org.bson.codecs.ValueCodecProvider
import org.bson.codecs.configuration.CodecRegistries.fromProviders
import org.bson.codecs.configuration.CodecRegistries.fromRegistries
import org.bson.codecs.jsr310.Jsr310CodecProvider
import org.bson.codecs.pojo.PojoCodecProvider
import java.util.*

object MongoUtil {

    private const val configPath:String = "/db/db.properties"
    private val dbProps:Properties = Properties()

    /**
     * Mongo URL
     */
    private val url: String
    /**
     * Mongo PORT
     */
    private val port: String
    /**
     * Mongo DB
     */
    private val schema: String

    private val db: MongoDatabase

    init {
        val inputStream = MongoUtil::class.java.getResource(configPath).openStream()
        dbProps.load(inputStream)

        url = getProperty("db.url")
        port = getProperty("db.port")
        schema = getProperty("db.schema")

        val pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
            fromProviders(PojoCodecProvider.builder().register(Person::class.java, Address::class.java).build(),
                Jsr310CodecProvider(), ValueCodecProvider()))
        val client = getClient()
        db = client.getDatabase(schema).withCodecRegistry(pojoCodecRegistry)
    }

    private fun getProperty(propName: String): String {
        return dbProps.getProperty(propName)
    }

    private fun getClient() = MongoClient(url, port.toInt())

    fun <T> getCollection(name: String, pojo: Class<T>): MongoCollection<T> {
        return db.getCollection(name, pojo)
    }

    fun createCollection(name: String) {
        db.createCollection(name)
    }
}