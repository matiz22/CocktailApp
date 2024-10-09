package pl.matiz22.cocktailapp.android.core.composables.timepicker

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import io.github.skeptick.libres.compose.painterResource
import pl.matiz22.cocktailapp.SharedRes
import pl.matiz22.cocktailapp.android.R
import pl.matiz22.cocktailapp.android.core.composables.mainbutton.MainButton
import pl.matiz22.cocktailapp.android.core.composables.mainbutton.MainButtonText
import pl.matiz22.cocktailapp.android.theme.CocktailsAppTheme
import java.util.Calendar

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TimeAppPicker(
    dialogState: Boolean,
    picked: (TimePickerState) -> Unit,
    dismiss: () -> Unit,
) {
    val currentTime = Calendar.getInstance()
    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = true,
    )
    if (dialogState) {
        Dialog(onDismissRequest = {
            dismiss()
        }) {
            Surface(
                modifier = Modifier.clip(RoundedCornerShape(8.dp)),
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    TimePicker(
                        state = timePickerState,
                        colors = TimePickerDefaults.colors(
                            clockDialColor = CocktailsAppTheme.colors.background,
                            selectorColor = CocktailsAppTheme.colors.accentBrand,
                            timeSelectorSelectedContainerColor = CocktailsAppTheme.colors.accentBrand,
                            timeSelectorSelectedContentColor = CocktailsAppTheme.colors.fontWhite,
                            timeSelectorUnselectedContainerColor = CocktailsAppTheme.colors.background,
                        ),
                    )
                    Row {
                        IconButton(onClick = { dismiss() }) {
                            Icon(
                                painter = SharedRes.image.x.painterResource(),
                                contentDescription = null,
                            )
                        }
                        MainButton(
                            modifier = Modifier.width(100.dp),
                            onClick = {
                                picked(timePickerState)
                            },
                        ) {
                            MainButtonText(stringResource(R.string.settings_daily_drink_confirm))
                        }
                    }
                }
            }
        }
    }
}
