package pl.matiz22.cocktailapp.cocktails.data.remote.util

import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.URLProtocol
import io.ktor.http.path
import io.ktor.serialization.kotlinx.json.json

val defaultHttpClientConfig: HttpClientConfig<*>.() -> Unit = {
    install(ContentNegotiation) {
        json()
    }
    defaultRequest {
        url {
            protocol = URLProtocol.HTTPS
            host = "www.thecocktaildb.com"
            path("/api/json/v1/1/")
        }
    }
}