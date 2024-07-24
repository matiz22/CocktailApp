package pl.matiz22.cocktailapp.root.domain.model

sealed interface DataError : Error {
    enum class Network : DataError {
        CLIENT_ERROR,
        REQUEST_TIMEOUT,
        TOO_MANY_REQUESTS,
        NO_INTERNET,
        PAYLOAD_TOO_LARGE,
        SERVER_ERROR,
        SERIALIZATION,
        UNKNOWN,
        NOT_FOUND
    }

    enum class Local : DataError {
        DISK_FULL,
        DATABASE_ERROR,
        NOT_FOUND
    }
}
