package com.example.Locations

import io.ktor.locations.*


@Location("/getPerson/{name}/{age}")
data class PersonLocations (
    var name: String? = null,
    var age: Int? = null
)