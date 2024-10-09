package pl.matiz22.cocktailapp.android.core.viewmodels

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimePickerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import pl.matiz22.cocktailapp.android.core.events.SettingsEvents

@OptIn(ExperimentalMaterial3Api::class)
class SettingsViewModel : ViewModel() {

    private val _dailyDrinkTime = MutableStateFlow<TimePickerState?>(null)
    val dailyDrinkTime = _dailyDrinkTime.asStateFlow()

    var dailyDrinkPicker = mutableStateOf(false)
        private set

    fun onEvent(settingsEvents: SettingsEvents) {
        when (settingsEvents) {
            is SettingsEvents.CancelDailyDrink -> {
            }

            is SettingsEvents.HideDailyDrinkTimePicker -> {
                dailyDrinkPicker.value = false
            }

            is SettingsEvents.TriggerDailyDrinkTimePicker -> {
                dailyDrinkPicker.value = true
            }

            is SettingsEvents.ConfirmDailyDrinkTime -> {
                setDailyDrink(settingsEvents.pickerState)
            }
        }
    }

    private fun setDailyDrink(timePickerState: TimePickerState) {
        viewModelScope.launch {
            _dailyDrinkTime.emit(timePickerState)
        }
    }
}
