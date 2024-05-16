package com.silverstone.basiskeledeneme

import android.graphics.drawable.Drawable
import androidx.compose.ui.graphics.painter.Painter

data class Places(
    val name:String,
    val address:String,
    val description:String,
    val phoneNumber:String,
    val image: Int,
    val latitude: String,
    val longitude:String
    )
