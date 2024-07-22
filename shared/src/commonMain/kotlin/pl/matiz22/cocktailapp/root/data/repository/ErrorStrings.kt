package pl.matiz22.cocktailapp.root.data.repository

import pl.matiz22.cocktailapp.SharedRes
import pl.matiz22.cocktailapp.root.domain.model.DataError


val DataError.Network.errorMessage: String
    get() = when (this) {
        DataError.Network.CLIENT_ERROR -> SharedRes.string.error_client_error
        DataError.Network.REQUEST_TIMEOUT -> SharedRes.string.error_request_timeout
        DataError.Network.TOO_MANY_REQUESTS -> SharedRes.string.error_too_many_requests
        DataError.Network.NO_INTERNET -> SharedRes.string.error_no_internet
        DataError.Network.PAYLOAD_TOO_LARGE -> SharedRes.string.error_payload_too_large
        DataError.Network.SERVER_ERROR -> SharedRes.string.error_server_error
        DataError.Network.SERIALIZATION -> SharedRes.string.error_serialization
        DataError.Network.UNKNOWN -> SharedRes.string.error_network_unknown
    }

val DataError.Local.errorMessage: String
    get() = when (this) {
        DataError.Local.DISK_FULL -> SharedRes.string.error_disk_full
        DataError.Local.DATABASE_ERROR -> SharedRes.string.error_database
    }
