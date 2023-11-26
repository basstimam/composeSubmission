package com.example.cryptoapp.ui.theme.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun CoinItem(name: String, price: Double, photoUrl: String, modifier: Modifier = Modifier, onClick: () -> Unit)
{
    Card(
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(120.dp)
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(photoUrl)
                    .crossfade(true)
                    .build(),

                contentDescription = name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp)

                )

            Text(text = name, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.ExtraBold,

                modifier = Modifier.align(Alignment.CenterVertically)
            )


//

            Column {

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "$ $price",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(end = 8.dp)
                )

            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview()
{
    CoinItem(name = "Bitcoin", price = 45000.0, onClick = { }, photoUrl = "https://cryptologos.cc/logos/wrapped-bitcoin-wbtc-logo.png?v=010")
}