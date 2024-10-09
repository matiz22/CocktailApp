package pl.matiz22.cocktailapp.android.core.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pl.matiz22.cocktailapp.android.core.composables.settings.SettingsDailyDrinkOption
import pl.matiz22.cocktailapp.android.core.composables.timepicker.TimeAppPicker
import pl.matiz22.cocktailapp.android.core.events.SettingsEvents

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    dailyDrinkTimeState: TimePickerState?,
    dialogState: Boolean,
    onEvent: (SettingsEvents) -> Unit,
    modifier: Modifier = Modifier,
) {
    TimeAppPicker(
        dialogState = dialogState,
        picked = { timePickerState ->
            onEvent(SettingsEvents.ConfirmDailyDrinkTime(timePickerState))
        },
        dismiss = {
            onEvent(SettingsEvents.HideDailyDrinkTimePicker)
        },
    )
    Box(modifier = modifier){
        Column(modifier = Modifier.fillMaxSize()) {
            SettingsDailyDrinkOption(
                onCancelClick = { onEvent(SettingsEvents.CancelDailyDrink) },
                onOptionClick = { onEvent(SettingsEvents.TriggerDailyDrinkTimePicker) },
                clockState = dailyDrinkTimeState,
            )
        }
    }
}
