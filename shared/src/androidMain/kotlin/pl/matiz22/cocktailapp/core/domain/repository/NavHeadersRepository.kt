package pl.matiz22.cocktailapp.core.domain.repository

import pl.matiz22.cocktailapp.core.domain.model.NavHeaders

interface NavHeadersRepository {
    fun provideNavHeaders(route: String): NavHeaders?
}
