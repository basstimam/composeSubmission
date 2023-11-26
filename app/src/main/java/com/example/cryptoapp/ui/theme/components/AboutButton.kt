package com.example.cryptoapp.ui.theme.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.cryptoapp.R


@Composable
fun AboutButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    FilledIconButton(
        onClick = onClick,
        modifier = modifier.size(60.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Person,
            modifier = Modifier.size(30.dp),
            contentDescription = stringResource(R.string.about_page),
        )
    }
}