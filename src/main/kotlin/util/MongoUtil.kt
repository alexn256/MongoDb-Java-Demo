package util

import java.util.*

object MongoUtil {

    private const val configPath:String = "/db/db.properties"
    private val dbProps:Properties = Properties()

    val url:String
    get() = getProperty("db.url")
    val port:Int
    get() = getProperty("db.port").toInt()

    init {
        val inputStream = MongoUtil::class.java.getResource(configPath).openStream()
        dbProps.load(inputStream)
    }

    private fun getProperty(propName: String): String {
        return dbProps.getProperty(propName)
    }
}