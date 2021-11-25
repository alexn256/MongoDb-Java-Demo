package repository

import USER
import model.User

class UserMongoRepository: AbstractMongoRepository<User>(USER)