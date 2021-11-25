package model

enum class Sex { M, F }

data class User(val name: String, val age: Int, val sex: Sex, val address: Address)

data class Address(val country: String, val city: String, val phone: String)