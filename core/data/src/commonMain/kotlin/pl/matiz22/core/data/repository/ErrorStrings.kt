package pl.matiz22.core.data.repository

import pl.matiz22.core.data.CoreDataRes
import pl.matiz22.core.domain.model.DataError

val DataError.Network.errorMessage: String
    get() =
        when (this) {
            DataError.Network.CLIENT_ERROR -> CoreDataRes.string.error_client_error
            DataError.Network.REQUEST_TIMEOUT -> CoreDataRes.string.error_request_timeout
            DataError.Network.TOO_MANY_REQUESTS -> CoreDataRes.string.error_too_many_requests
            DataError.Network.NO_INTERNET -> CoreDataRes.string.error_no_internet
            DataError.Network.PAYLOAD_TOO_LARGE -> CoreDataRes.string.error_payload_too_large
            DataError.Network.SERVER_ERROR -> CoreDataRes.string.error_server_error
            DataError.Network.SERIALIZATION -> CoreDataRes.string.error_serialization
            DataError.Network.UNKNOWN -> CoreDataRes.string.error_network_unknown
            DataError.Network.NOT_FOUND -> CoreDataRes.string.error_not_found
        }

val DataError.Local.errorMessage: String
    get() =
        when (this) {
            DataError.Local.DISK_FULL -> CoreDataRes.string.error_disk_full
            DataError.Local.DATABASE_ERROR -> CoreDataRes.string.error_database
            DataError.Local.NOT_FOUND -> CoreDataRes.string.error_not_found
        }
