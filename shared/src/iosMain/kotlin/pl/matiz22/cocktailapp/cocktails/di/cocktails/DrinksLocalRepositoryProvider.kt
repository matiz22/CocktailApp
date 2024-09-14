package pl.matiz22.cocktailapp.cocktails.di.cocktails

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import pl.matiz22.cocktails.domain.repository.local.DrinksLocalRepository

class DrinksLocalRepositoryProvider : KoinComponent {
    val drinksLocalRepository: DrinksLocalRepository by inject<DrinksLocalRepository>()
}
