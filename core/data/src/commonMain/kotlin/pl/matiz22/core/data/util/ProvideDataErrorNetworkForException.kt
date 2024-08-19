package pl.matiz22.core.data.util

import io.ktor.client.call.NoTransformationFoundException
import io.ktor.serialization.JsonConvertException
import pl.matiz22.core.domain.model.DataError

fun provideDataErrorNetworkForException(exception: Exception): DataError.Network =
    when (exception) {
        is NoTransformationFoundException -> DataError.Network.SERIALIZATION
        is JsonConvertException -> DataError.Network.SERIALIZATION
        else -> DataError.Network.NO_INTERNET // no access to java.net.UnknownHostException
    }
