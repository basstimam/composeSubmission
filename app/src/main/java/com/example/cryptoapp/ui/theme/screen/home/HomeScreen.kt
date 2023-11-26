package com.example.cryptoapp.ui.theme.screen.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.cryptoapp.R
import com.example.cryptoapp.di.Injection
import com.example.cryptoapp.model.Coin
import com.example.cryptoapp.ui.theme.CryptoAppTheme
import com.example.cryptoapp.ui.theme.components.AboutButton

import com.example.cryptoapp.ui.theme.components.CoinItem
import com.example.cryptoapp.ui.theme.components.ScrollToTopButton
import com.example.cryptoapp.ui.theme.components.SearchBar
import com.example.cryptoapp.ui.theme.navigation.Screen
import kotlinx.coroutines.launch



@SuppressLint("SuspiciousIndentation")
@Composable
fun HomeScreen(modifier: Modifier = Modifier,
               viewModel: HomeViewModel = viewModel(
                   factory = ViewModelFactory(Injection.provideRepository())),
               navigateToDetail: (String) -> Unit,
){

    val query by viewModel.query
            viewModel.groupedCoins.collectAsState().value.let { groupedCoins ->
                HomeContent(
                    cryptoList = groupedCoins,
                    modifier = modifier,
                    navigateToDetail = navigateToDetail,
                    query = query,
                    onQueryChange = viewModel::search
                )
            }



}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    cryptoList: List<Coin>,
    modifier: Modifier = Modifier,
    query: String = "",
    navigateToDetail: (String) -> Unit,
    onQueryChange: (String) -> Unit,

){


    Box(
        contentAlignment = Alignment.BottomEnd,
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        val scope = rememberCoroutineScope()
        val listState = rememberLazyListState()
        val showButton by remember(listState) {
            derivedStateOf { listState.firstVisibleItemIndex > 0 }
        }


        LazyColumn(
            state = listState,
            modifier = Modifier.padding(10.dp),
            contentPadding = PaddingValues(bottom = 80.dp)
        ) {
            item {
                SearchBar(query = query, onQueryChange = onQueryChange)
            }


            items(cryptoList) { coin ->
                CoinItem(
                    name = coin.name,
                    price = coin.price,
                    modifier = Modifier

                        .fillMaxWidth(),
                    onClick = {
                        navigateToDetail(coin.id)
                        Log.d("HomeScreen", "HomeScreen: ${coin.id}")
                    }


                )
            }
        }



        AnimatedVisibility(
            visible = showButton,
            enter = fadeIn() + slideInVertically(),
            exit = fadeOut() + slideOutVertically(),
            modifier = Modifier
                .padding(bottom = 30.dp)
                .align(Alignment.BottomCenter)

        ) {
            ScrollToTopButton(
                onClick = {
                    scope.launch {
                        listState.scrollToItem(index = 0)
                    }
                }
            )
        }



    }
}
