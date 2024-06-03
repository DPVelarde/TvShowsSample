package com.daniel.tvshowssample.datepicker

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.daniel.tvshowssample.ui.theme.TvShowsSampleTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TvShowsDatePickerScreenContent(
    state: DatePickerState,
    dateValidator: (Long) -> Boolean
) {
    DatePicker(
        modifier = Modifier.fillMaxSize(),
        state = state,
        dateValidator = dateValidator
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
internal fun TvShowsDatePickerScreenContentPreview() {
    val pickerState = rememberDatePickerState()

    TvShowsSampleTheme {
        TvShowsDatePickerScreenContent(
            state = pickerState,
            dateValidator = {
                true
            }
        )
    }
}