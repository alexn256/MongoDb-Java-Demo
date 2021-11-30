import model.Address
import model.Person
import repository.impl.PersonMongoRepository

const val PERSON = "person"
const val ADDRESS = "address"

fun main() {
    val userRepo = PersonMongoRepository

    val list = listOf(
        Person(
            "Michael Myers", 40,
            Address("45th", "Los Angeles", "10003")
        ),
        Person(
            "Ashley Brooks", 22,
            Address("Gorkiy", "Orlando", "10007")
        ),
        Person(
            "Mikey Mouse", 10,
            Address("Disney", "Texas", "10009")
        )
    )

    val findAll = userRepo.findAll()
    findAll.forEach { println(it) }
}