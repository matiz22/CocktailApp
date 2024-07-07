package pl.matiz22.cocktailapp.android.core.presentation.states

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AppBarTextsState(
    val name: String = "",
    val description: String = "",
    val navigateBack: Boolean = false
) : Parcelable
