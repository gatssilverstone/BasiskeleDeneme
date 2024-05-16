package com.silverstone.basiskeledeneme
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailsScreene(name:String,
                  address:String,
                  description:String,
                  phoneNumber:String,
                  image: Int,
                  latitude: Double,
                  longitude:Double) {
    val descriptionDetails = remember{ mutableStateOf(false) }

    Image(painter = painterResource(id = image), contentDescription = "", contentScale = ContentScale.FillBounds,
        modifier = Modifier.alpha(0.2f))
    Column(
        Modifier
            .fillMaxSize()

            .verticalScroll(ScrollState(0)), horizontalAlignment = Alignment.CenterHorizontally) {

        Image(
            painter = painterResource(id = image),
            contentDescription = "",
            Modifier
                .clip(shape = RoundedCornerShape(0,0,10,10)),
            contentScale = ContentScale.FillBounds)
        Text(name, fontSize = 35.sp, fontFamily = FontFamily.Cursive, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.size(5.dp))
        Box(modifier = Modifier.padding(5.dp).fillMaxSize()){
            Box(modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(if (descriptionDetails.value)10 else 30))
                .background(Color.Cyan.copy(alpha = 0.5f))
                .padding(10.dp)
                .clickable { descriptionDetails.value = !descriptionDetails.value }){
                val limitedDescription = if (description.length > 50) description.take(50) + "..." else description

                Text(text = if (descriptionDetails.value) description else limitedDescription, fontSize = 20.sp, textAlign = TextAlign.Center)
            }
        }
        Spacer(modifier = Modifier.size(25.dp))

        Box(modifier = Modifier
            .size(350.dp, 150.dp)
            .clip(shape = RoundedCornerShape(10)).border(border = BorderStroke(3.dp,Color.Cyan))){
            MyGoogleMapSingle(latitude = latitude, longitude = longitude, name =name )

        }
        Text(text = address)
        if (phoneNumber!="none"){
            PhoneCallButton(phoneNumber = phoneNumber)
        }
        EmptyStars(size = 200.dp)

    }
}