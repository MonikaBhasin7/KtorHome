package com.example

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module(testing: Boolean = false) {

    routing {

        getCall()
        getCallWithParameters()
        getCallWithQueryParameters()
        //postCall()
    }
}

fun Route.getCallWithQueryParameters(): Route {
    return route("") {
        get("/qp") {
            call.respond(HttpStatusCode.OK, call.request.queryParameters["key"].toString())
        }
    }
}

fun Routing.getCall(): Route {
    return route("") {
        get("/") {
            //call.respond("He is there.")
            call.respond(HttpStatusCode.OK, "bad request")
        }
    }
}

fun Routing.getCallWithParameters(): Route {
    return route("") {
        get("/{key}") {
            //call.respond("He is there.")
            call.respond(HttpStatusCode.OK, call.parameters["key"].toString())
        }
    }
}
//fun Routing.postCall(): Route {
//    return route("/post") {
//        post {
//            var firstParameter = call.receiveParameters().
//            call.respond(HttpStatusCode.OK, "200")
//        }
//    }
//}
