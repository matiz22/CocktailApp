package pl.matiz22.cocktailapp.cocktails.presentation.viewmodels

import org.koin.androidx.scope.ScopeViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import pl.matiz22.cocktailapp.cocktails.domain.repository.DrinksRepository

@OptIn(KoinExperimentalAPI::class)
class DrinksViewModel(private val drinksRepository: DrinksRepository) : ScopeViewModel() {

}