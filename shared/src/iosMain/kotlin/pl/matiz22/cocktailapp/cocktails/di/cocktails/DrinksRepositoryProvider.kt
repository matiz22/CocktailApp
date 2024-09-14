package pl.matiz22.cocktailapp.cocktails.di.cocktails

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import pl.matiz22.cocktails.domain.repository.remote.DrinksRepository

class DrinksRepositoryProvider : KoinComponent {
    val drinksRepository: DrinksRepository by inject<DrinksRepository>()
}
