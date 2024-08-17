package pl.matiz22.cocktails.data.remote.source

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig

expect fun httpClient(config: HttpClientConfig<*>.() -> Unit): HttpClient