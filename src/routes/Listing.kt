package com.example.routes

import com.example.service.SilosService
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route

fun Route.silos(silosService: SilosService) {
    route("/silos") {
        get("/") {
            call.respond(silosService.getAllSilos())
        }
    }
}
