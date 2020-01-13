package com.example.service

import com.example.model.Silo
import com.example.model.Silos
import com.example.service.DatabaseFactory.dbQuery
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll

class SilosService {
    suspend fun getAllSilos(): List<Silo> = dbQuery {
        Silos.selectAll().map { toSilo(it) }
    }

    private fun toSilo(row: ResultRow): Silo =
        Silo(
            id = row[Silos.id].value,
            name = row[Silos.name],
            quantity = row[Silos.quantity]
        )
}