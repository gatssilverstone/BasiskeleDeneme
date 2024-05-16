package com.silverstone.basiskeledeneme

import android.content.SharedPreferences
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MainPage(navController: NavController,sharedPreferences: SharedPreferences){
    val language=sharedPreferences.getString("selectedLanguage","tr").apply {  }.toString()
    Image(painter = painterResource(id = R.drawable.mainback), contentDescription = "", contentScale = ContentScale.FillBounds,
        modifier = Modifier.alpha(0.5f))
    Column(Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.size(100.dp))
        Image(painter = painterResource(id = R.drawable.hosgldnz), contentDescription = "",
            Modifier
                .fillMaxWidth()
                .size(150.dp))
        Spacer(modifier = Modifier.size(50.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            ImageButtons(icon = R.drawable.listicon,  navigation = "TabRows/0",navController)
            ImageButtons(icon = R.drawable.mapicon, navigation = "TabRows/1",navController)
        }
        Spacer(modifier = Modifier.size(100.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            val flagIcon= when(language){
                "tr" -> R.drawable.tr
                "en" -> R.drawable.en
                "ar" -> R.drawable.ar
                else -> R.drawable.tr
            }

            ImageButtons(icon = flagIcon, navigation ="Language",navController )
        }
        Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {
            Image(painter = painterResource(id = R.drawable.altbanner), contentDescription = "",Modifier.fillMaxWidth())
        }

    }
}

@Composable
fun ImageButtons(icon:Int,navigation:String,navController: NavController) {

    Box(modifier = Modifier
        .size(85.dp)
        .clip(shape = CircleShape)
        .background(Color.Red)
        .padding(2.dp)){
    IconButton(
        onClick = { navController.navigate(navigation) },
        Modifier
            .size(80.dp)
            .clip(shape = CircleShape)

    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = "",
            Modifier.clip(shape = CircleShape),
            contentScale = ContentScale.FillBounds
        )
    }
}
}