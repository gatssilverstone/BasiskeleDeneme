package com.silverstone.basiskeledeneme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ListLazyColum(navController: NavController,places:List<Places>){
Box(modifier = Modifier.fillMaxSize()){
    Image(
        painter = painterResource(id = R.drawable.listback),
        contentDescription = "",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .matchParentSize()
            .alpha(0.5f)
    )
    LazyColumn(modifier = Modifier.fillMaxSize()){
        items(places.size){
            val place=places[it]
            ListCards(place = place,navController)
        }
    }
}
}
@Composable
fun ListCards(place:Places,navController: NavController){
    Box(
        Modifier
            .padding(5.dp)
            .border(BorderStroke(2.dp, Color.Black), shape = RoundedCornerShape(10))
            .clip(shape = RoundedCornerShape(10))
            .background(color = Color.Gray.copy(0.9f))
            .fillMaxWidth()
            .height(120.dp)
            .clickable { navController.navigate("DetailsScreene/${place.name}/${place.address}/${place.description}/${place.phoneNumber}/${place.image}/${place.latitude}/${place.longitude}") }) {
        Image(
            painter = painterResource(id = place.image),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .matchParentSize()
                .alpha(0.2f)
        )
        Row(Modifier.fillMaxSize()) {
            Column(
                Modifier
                    .weight(5f / 2f)
                    .padding(2.dp)

) {
                val neva= FontFamily(Font(R.font.neva))
                Text(text = place.name,   color = Color.White, fontSize = 18.sp, fontFamily = neva)
                val description = place.description
                val limitedDescription = if (description.length > 50) description.take(50) + "..." else description
                Text(text = limitedDescription,   color = Color.White)
                Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {
                    StarsImage(100.dp)

                }

                
            }
        Column(
            Modifier
                .weight(5f / 3f)
                .clip(shape = RoundedCornerShape(10.dp))) {
            Image(painter = painterResource(id = place.image), contentDescription ="",
                contentScale = ContentScale.FillBounds)
        }
        }
    }
}

@Composable
fun StarsImage(size:Dp){
    Row(Modifier.size(size), verticalAlignment = Alignment.Bottom) {
        for (i in 0..3){
            Image(painter = painterResource(id = R.drawable.pointtrue), contentDescription = "",
                Modifier.weight(1f))
        }
        Image(painter = painterResource(id = R.drawable.pointfalse), contentDescription = "",
            Modifier.weight(1f))
    }
}

@Composable
fun EmptyStars(size:Dp){
    Row(Modifier.width(size), verticalAlignment = Alignment.Top) {
        for (i in 0..4){
            Image(painter = painterResource(id = R.drawable.pointfalse), contentDescription = "",
                Modifier.weight(1f))
        }

}}

