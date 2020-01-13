package com.example

import com.example.routes.getSilos
import com.example.service.DatabaseFactory
import com.example.service.SilosService
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.DefaultHeaders
import io.ktor.locations.Locations
import io.ktor.routing.routing
import io.ktor.server.engine.commandLineEnvironment
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main(args: Array<String>) {
    //embeddedServer(Netty, commandLineEnvironment(args)).start(wait = true)
    embeddedServer(Netty, 8080, module = Application::module).start(true)

}

fun Application.module() {
    install(DefaultHeaders)
    install(CallLogging)
    install(Locations)

    DatabaseFactory.init()

    val silosService = SilosService()

    routing {
        getSilos(silosService)
    }
}