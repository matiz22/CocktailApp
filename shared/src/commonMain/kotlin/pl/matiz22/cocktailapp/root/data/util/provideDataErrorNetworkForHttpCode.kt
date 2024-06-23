package pl.matiz22.cocktailapp.root.data.util

import pl.matiz22.cocktailapp.root.domain.DataError
import pl.matiz22.cocktailapp.root.domain.Result

fun provideDataErrorNetworkForHttpCode(httpCode: Int): DataError.Network {
    return when (httpCode) {
        in 400..499 -> DataError.Network.CLIENT_ERROR
        in 500..599 -> DataError.Network.SERVER_ERROR
        else -> DataError.Network.UNKNOWN
    }
}