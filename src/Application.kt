package com.example

import com.example.routes.mainRouter
import com.example.routes.silos
import com.example.service.DatabaseFactory
import com.example.service.SilosService
import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.jackson.jackson
import io.ktor.routing.Routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main(args: Array<String>) {
    //embeddedServer(Netty, commandLineEnvironment(args)).start(wait = true)
    embeddedServer(Netty, 8080, module = Application::module).start(true)

}

fun Application.module() {
    install(DefaultHeaders)
    install(CallLogging)
    install(ContentNegotiation) {
        jackson {
            configure(SerializationFeature.INDENT_OUTPUT, true)
        }
    }
    DatabaseFactory.init()

    val silosService = SilosService()
    install(Routing) {
        mainRouter()
        silos(silosService)
    }
}