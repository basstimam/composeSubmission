package com.example.cryptoapp.ui.theme.screen.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptoapp.R

@Composable
fun AboutScreen() {

    Column(

        modifier = Modifier.padding(16.dp),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally


    ) {
        Image(
            painter = painterResource(id = R.drawable.main_compressed),
            contentDescription = stringResource(id = R.string.about_image),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(400.dp)
                .clip(shape = RoundedCornerShape(10.dp))
        )

        Column (modifier = Modifier.padding(16.dp)){
            Text(text = "Muhammad Imam Fahrudin", style = androidx.compose.material3.MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(text = "basstimam@gmail.com", style = androidx.compose.material3.MaterialTheme.typography.bodyMedium)
        }
    }
}


@Preview(showBackground = true, device = androidx.compose.ui.tooling.preview.Devices.PIXEL_4)
@Composable
fun DefaultPreview() {
    AboutScreen()
}