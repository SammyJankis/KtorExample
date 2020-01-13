package com.example.routes

import com.example.service.SilosService
import io.ktor.application.call
import io.ktor.locations.Location
import io.ktor.locations.get
import io.ktor.response.respond
import io.ktor.routing.Route

@Location("/silos")
data class SiloList(val name: String = "mierda", val page: Int = 23)

fun Route.getSilos(silosService: SilosService) {
    get<SiloList> { listing ->
        call.respond(silosService.getAllSilos())
    }

}
