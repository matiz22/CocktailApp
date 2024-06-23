package pl.matiz22.cocktailapp.root.data.util

import io.ktor.client.call.NoTransformationFoundException
import pl.matiz22.cocktailapp.root.domain.DataError

fun provideDataErrorNetworkForException(exception: Exception): DataError.Network {
    return when (exception) {
        is NoTransformationFoundException -> DataError.Network.SERIALIZATION
        else -> DataError.Network.NO_INTERNET // no access to java.net.UnknownHostException
    }
}