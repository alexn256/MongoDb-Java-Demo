package codec

import model.Address
import org.bson.BsonReader
import org.bson.BsonWriter
import org.bson.codecs.Codec
import org.bson.codecs.DecoderContext
import org.bson.codecs.EncoderContext

object AddressCodec: Codec<Address> {

    override fun encode(writer: BsonWriter, value: Address, encoderContext: EncoderContext) {
        TODO("Not yet implemented")
    }

    override fun getEncoderClass(): Class<Address> {
        TODO("Not yet implemented")
    }

    override fun decode(reader: BsonReader, decoderContext: DecoderContext): Address {
        TODO("Not yet implemented")
    }
}