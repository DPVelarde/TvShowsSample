package com.daniel.tvshowssample.search.item

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.daniel.data.model.Image
import com.daniel.data.model.Show
import com.daniel.tvshowssample.R
import com.daniel.tvshowssample.ui.theme.TvShowsSampleTheme

@Composable
fun TvShowsSearchItem(
    modifier: Modifier = Modifier,
    item: Show,
    onClickItem: (Show) -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .clickable { onClickItem(item) }
            .clip(MaterialTheme.shapes.medium)
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxSize(),
            model = item.image.medium,
            contentDescription = stringResource(id = R.string.show_image_placeholder),
            error = painterResource(id = R.drawable.il_tv_show_placeholder),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Transparent,
                            Color.Black
                        )
                    )
                )
                .padding(8.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = item.name,
                style = MaterialTheme.typography.labelMedium,
                color = Color.White,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            item.genres?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun TvShowsSearchItemPreview() {
    TvShowsSampleTheme {
        TvShowsSearchItem(
            modifier = Modifier
                .size(200.dp, 295.dp),
            item =
            Show(
                1,
                "Show",
                Image("", ""),
                genres = "Drama "
            ),
        )
    }
}