import repository.UserMongoRepository

const val USER = "user"

fun main() {
    val userRepo = UserMongoRepository()
    userRepo.deleteById("619fca734bbfc0424683fdc6")
}