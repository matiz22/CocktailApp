package pl.matiz22.core.domain.model

data class DataOrError<D, E : Error>(
    val data: D? = null,
    val error: E? = null,
)
