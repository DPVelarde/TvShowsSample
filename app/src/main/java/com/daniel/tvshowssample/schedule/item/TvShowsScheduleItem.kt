package com.daniel.tvshowssample.schedule.item

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.daniel.data.model.Image
import com.daniel.data.model.Show
import com.daniel.data.model.ShowSchedule
import com.daniel.tvshowssample.R
import com.daniel.tvshowssample.ui.theme.TvShowsSampleTheme

@Composable
fun TvShowsScheduleItem(
    modifier: Modifier = Modifier,
    item: ShowSchedule,
    onClickItem: (Show) -> Unit = {}
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClickItem(item.show) },
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Row(
        ) {
            AsyncImage(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .width(100.dp)
                    .aspectRatio(0.71f),
                model = item.show.image.medium,
                contentDescription = null,
                error = painterResource(id = R.drawable.il_tv_show_placeholder)
            )
            Column(
                modifier = Modifier.padding(
                    start = 4.dp, end = 16.dp,
                    top = 8.dp, bottom = 8.dp
                )
            ) {
                Text(
                    text = item.show.name,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.labelMedium
                )
                Text(
                    text = item.name,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    text = "Start: ${item.airTime}",
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}

@Preview
@Composable
fun TvShowsScheduleItemPreview() {
    TvShowsSampleTheme {
        TvShowsScheduleItem(
            modifier = Modifier.padding(16.dp),
            item = ShowSchedule(
                1,
                "ShowSchedule",
                "2024-05-31",
                "",
                "07:40",
                1,
                40,
                40,
                Show(1, "Show", Image("", "")),
                "",
                ""
            )
        )
    }
}