package com.daniel.tvshowssample.schedule

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daniel.data.model.Show
import com.daniel.tvshowssample.R
import com.daniel.tvshowssample.schedule.item.TvShowsScheduleItem
import com.daniel.tvshowssample.ui.theme.TvShowsSampleTheme

@Composable
fun TvShowsScheduleScreenContent(
    state: TvShowsScheduleViewState,
    onShowClicked: (Show) -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier.padding(
            horizontal = 16.dp
        ),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = stringResource(id = R.string.upcoming_shows, state.selectedDate.orEmpty()),
                style = MaterialTheme.typography.titleMedium
            )
        }
        items(
            items = state.showsSchedule ?: emptyList()
        ) {
            TvShowsScheduleItem(
                item = it,
                onClickItem = onShowClicked
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TvShowsScreenContentPreview() {
    TvShowsSampleTheme {
        TvShowsScheduleScreenContent(TvShowsScheduleViewState())
    }
}