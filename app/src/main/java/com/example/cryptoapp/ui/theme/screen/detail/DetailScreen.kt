package com.example.cryptoapp.ui.theme.screen.detail

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.cryptoapp.R
import com.example.cryptoapp.di.Injection
import com.example.cryptoapp.ui.theme.common.UiState
import com.example.cryptoapp.ui.theme.screen.home.ViewModelFactory

@Composable
fun DetailScreen(
    coinId: String,
    viewModel: DetailViewModel = viewModel(
    factory = ViewModelFactory(
        Injection.provideRepository()
    )
),
    navigateBack: () -> Unit,



    ) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getCoinById(coinId)
            }
            is UiState.Success -> {
                val data = uiState.data
                DetailContent(
                    data.photoUrl,
                    data.name,
                    data.symbol,
                    data.price,
                    data.volume24h,
                    data.ethAddress,
                    onBackClick = navigateBack,


                )
            }
            is UiState.Error -> {}
        }
    }



}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailContent(
   image: String,
    name: String,
    symbol: String,
    price: Double,
    volume24h: String,
    ethAddress: String,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,

){






    Column(modifier = modifier) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .weight(1f)
                .fillMaxWidth()
        ) {
            Box (
                modifier = Modifier
                    .height(400.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .padding(8.dp)

            ){
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(image)
                        .crossfade(true)
                        .build(),
                    contentDescription = name,
                    contentScale = ContentScale.Crop,

                )

            }

            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = name,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.ExtraBold
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Crypto Symbol : ${symbol}",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Start,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Price : ${price}",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Justify,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Volume 24h : ${volume24h}",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Justify,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "ETH Address : \n${ethAddress}",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Justify,
                )
            }

        }


    }
}


@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun PreviewDetailScreen() {
    DetailScreen(coinId ="1") {

    }
}