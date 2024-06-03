package com.daniel.tvshowssample.datepicker

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.daniel.tvshowssample.R
import com.daniel.tvshowssample.ui.theme.TvShowsSampleTheme
import java.time.Year

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TvShowsDatePickerScreen(
    onBackPressed: () -> Unit = {},
    onDateConfirmed: (Long) -> Unit = {},
    dateValidator: (Long) -> Boolean
) {
    val pickerState = rememberDatePickerState(
        yearRange = IntRange(1900, Year.now().value)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.shows_date_picker_title))
                },
                navigationIcon = {
                    IconButton(onClick = onBackPressed) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = stringResource(id = R.string.navigate_up)
                        )
                    }
                },
                actions = {
                    pickerState.selectedDateMillis?.let { date ->
                        IconButton(onClick = { onDateConfirmed(date) }) {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = stringResource(
                                    id = R.string.confirmation_button
                                )
                            )
                        }
                    }
                }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            TvShowsDatePickerScreenContent(
                state = pickerState,
                dateValidator = dateValidator
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun TvShowsDatePickerScreenPreview() {
    TvShowsSampleTheme {
        TvShowsDatePickerScreen(dateValidator = { true })
    }
}