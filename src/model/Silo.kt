package com.example.model

import org.jetbrains.exposed.dao.IntIdTable

object Silos : IntIdTable() {
    val name = varchar("name", 128)
    val quantity = integer("quantity")
}

data class Silo(
    val id: Int,
    val name: String,
    val quantity: Int
)