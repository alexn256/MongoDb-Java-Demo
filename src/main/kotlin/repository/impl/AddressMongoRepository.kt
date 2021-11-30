package repository.impl

import ADDRESS
import model.Address
import repository.AbstractMongoRepository

object AddressMongoRepository: AbstractMongoRepository<Address>(ADDRESS, Address::class.java)