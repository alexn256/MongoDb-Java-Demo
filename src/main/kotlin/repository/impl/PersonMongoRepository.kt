package repository.impl

import PERSON
import model.Person
import repository.AbstractMongoRepository

object PersonMongoRepository: AbstractMongoRepository<Person>(PERSON, Person::class.java)