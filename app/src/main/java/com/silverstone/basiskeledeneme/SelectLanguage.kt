package com.silverstone.basiskeledeneme

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SelectLanguage(sharedPreferences: SharedPreferences,navController: NavController) {
    val languages = listOf(
        Pair("tr", R.drawable.tr),
        Pair("en", R.drawable.en),
      //  Pair("ar", R.drawable.ar)

    )
    Box(Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.back),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize().alpha(0.5f)
        )
    Column(
        Modifier.fillMaxSize().background(Color.Transparent),
        verticalArrangement = Arrangement.Center,
        Alignment.CenterHorizontally
    ) {

        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            languages.forEach { (language, flag) ->
                IconButton(
                    onClick = {
                        sharedPreferences.edit().putString("selectedLanguage", language).apply()
                        val selectedLanguage=sharedPreferences.getString("selectedLanguage",language).apply {  }
                        navController.navigate("MainPage")
                    },
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)

                ) {
                    Image(
                        painter = painterResource(id = flag),
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}


}

fun updateList(context:Context,language:String):List<Places>{
    val placeList=SetList(context,language)

    return placeList.places
}