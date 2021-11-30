package codec

import model.Address
import model.Person
import org.bson.BsonReader
import org.bson.BsonWriter
import org.bson.codecs.Codec
import org.bson.codecs.DecoderContext
import org.bson.codecs.EncoderContext

object PersonCodec: Codec<Person> {

    override fun encode(writer: BsonWriter, value: Person, encoderContext: EncoderContext) {
        TODO("Not yet implemented")
    }

    override fun decode(reader: BsonReader, decoderContext: DecoderContext): Person {
        val address = Address("", "", "")
        val person = Person("", 0, address)
        reader.readStartDocument()

        return person
    }

    override fun getEncoderClass(): Class<Person> = Person::class.java
}