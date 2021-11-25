
import com.mongodb.MongoClient
import com.mongodb.client.MongoDatabase
import org.bson.Document

import util.MongoUtil.url as url
import util.MongoUtil.port as port
import org.bson.types.ObjectId




fun main() {

    val client = MongoClient(url, port)
    val db: MongoDatabase = client.getDatabase("testDb")
    db.listCollectionNames().forEach { rec -> println(rec) }
    val userCollection = db.getCollection("user")

    val deleteOne = userCollection.deleteOne(Document("_id", ObjectId("619fca1432b56821af8da7a9")))
    println("${deleteOne.deletedCount} users were deleted.")
}