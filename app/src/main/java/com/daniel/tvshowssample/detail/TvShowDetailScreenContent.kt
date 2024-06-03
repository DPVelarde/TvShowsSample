package com.daniel.tvshowssample.detail

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.daniel.data.model.Image
import com.daniel.data.model.Show
import com.daniel.tvshowssample.R
import com.daniel.tvshowssample.ui.component.Html
import com.daniel.tvshowssample.ui.theme.TvShowsSampleTheme

@Composable
fun TvShowDetailScreenContent(show: Show) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .scrollable(state = scrollState, orientation = Orientation.Vertical)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        ) {

            AsyncImage(
                modifier = Modifier
                    .height(200.dp)
                    .aspectRatio(0.71f),
                model = show.image.original,
                contentDescription = stringResource(id = R.string.show_image_placeholder),
                error = painterResource(id = R.drawable.il_tv_show_placeholder)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 4.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = show.name,
                    style = MaterialTheme.typography.titleLarge
                )
                Html(show.summary.orEmpty())
            }
        }

        ShowInformation(show)
    }
}

@Composable
private fun ShowInformation(show: Show) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        shape = MaterialTheme.shapes.extraSmall
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.show_detail_info_title),
                style = MaterialTheme.typography.titleMedium
            )
            show.language?.let {
                Text(
                    text = stringResource(id = R.string.show_detail_info_language, it)
                )
            }
            show.type?.let {
                Text(
                    text = stringResource(id = R.string.show_detail_info_type, it)
                )
            }
            show.status?.let {
                Text(
                    text = stringResource(id = R.string.show_detail_info_status, it)
                )
            }
            show.runtime?.let {
                Text(
                    text = stringResource(id = R.string.show_detail_info_runtime, it)
                )
            }
            show.genres?.let {
                Text(
                    text = stringResource(id = R.string.show_detail_info_genres, it)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun TvShowDetailScreenContentPreview() {
    TvShowsSampleTheme {
        TvShowDetailScreenContent(
            show = Show(
                1,
                "Nightline",
                Image(
                    "",
                    "https://static.tvmaze.com/uploads/images/original_untouched/357/892587.jpg"
                ),
                genres = "Drama | Comedy",
                summary = "dsofijsdifds" +
                        "sdfsdfijsdofisdf"
            )
        )
    }
}