package pl.matiz22.cocktailapp.android.core.events

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimePickerState

sealed class SettingsEvents {
    data object CancelDailyDrink : SettingsEvents()
    data object TriggerDailyDrinkTimePicker : SettingsEvents()
    data object HideDailyDrinkTimePicker : SettingsEvents()
    data class ConfirmDailyDrinkTime
    @OptIn(ExperimentalMaterial3Api::class)
    constructor(
        val pickerState: TimePickerState,
    ) : SettingsEvents()
}
