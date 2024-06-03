package com.daniel.tvshowssample.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daniel.tvshowssample.R
import com.daniel.tvshowssample.ui.theme.TvShowsSampleTheme

@Composable
fun InformationScreen(
    @DrawableRes image: Int,
    text: String,
    button: String? = null,
    onButtonClicked: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier.size(200.dp),
                painter = painterResource(id = image),
                contentDescription = null
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                text = text,
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center
            )
            button?.let {
                Button(onClick = onButtonClicked) {
                    Text(text = button)
                }
            }
        }
    }
}

@Composable
fun GenericErrorScreen(
    button: String? = null,
    onButtonClicked: () -> Unit = {}
) {
    InformationScreen(
        image = R.drawable.il_generic_error,
        text = stringResource(id = R.string.show_generic_error),
        button = button,
        onButtonClicked = onButtonClicked
    )
}

@Preview(showBackground = true)
@Composable
internal fun InformationScreenPreview() {
    TvShowsSampleTheme {
        GenericErrorScreen()
    }
}