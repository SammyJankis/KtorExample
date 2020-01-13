package com.example.routes

import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route

fun Route.mainRouter() {
    route("/") {
        get("/") {
            call.respondText { "silos app" }
        }
    }
}