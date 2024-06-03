package com.daniel.tvshowssample.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daniel.data.model.Show
import com.daniel.tvshowssample.search.item.TvShowsSearchItem
import com.daniel.tvshowssample.ui.theme.TvShowsSampleTheme

private const val COLUMNS = 3

@Composable
fun TvShowsSearchScreenContent(
    items: List<Show>,
    onShowClicked: (Show) -> Unit = {}
) {
    val itemHeight = (LocalConfiguration.current.screenWidthDp.dp / COLUMNS) * 1.4f

    LazyVerticalStaggeredGrid(
        modifier = Modifier
            .fillMaxSize(),
        columns = StaggeredGridCells.Fixed(COLUMNS),
        contentPadding = PaddingValues(16.dp),
        verticalItemSpacing = 8.dp,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = items
        ) {
            TvShowsSearchItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(itemHeight),
                item = it,
                onClickItem = onShowClicked
            )
        }
    }
}

@Preview
@Composable
internal fun TvShowsSearchScreenContentPreview() {
    TvShowsSampleTheme {
        TvShowsSearchScreenContent(items = listOf())
    }
}