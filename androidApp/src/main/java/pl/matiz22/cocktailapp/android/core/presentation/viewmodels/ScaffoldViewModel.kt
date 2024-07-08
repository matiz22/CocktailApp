package pl.matiz22.cocktailapp.android.core.presentation.viewmodels

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import pl.matiz22.cocktailapp.android.core.presentation.states.AppBarTextsState
import pl.matiz22.cocktailapp.core.domain.repository.NavHeadersRepository

class ScaffoldViewModel(
    private val saveStateHandle: SavedStateHandle,
    private val navHeadersRepository: NavHeadersRepository
) : ViewModel() {

    private val appBarTextsStateKey = "appBarTextsState"
    val appBarTextsState = saveStateHandle.getStateFlow(appBarTextsStateKey, AppBarTextsState())

    fun updateAppBar(controller: NavController, destination: NavDestination, arguments: Bundle?) {
        val headers = destination.route?.let { navHeadersRepository.provideNavHeaders(it) }
        if (headers != null) {
            saveStateHandle[appBarTextsStateKey] =
                saveStateHandle.get<AppBarTextsState>(appBarTextsStateKey)?.copy(
                    name = headers.title,
                    description = headers.description,
                    navigateBack = headers.isNavigationBack
                )
        }
    }
}
