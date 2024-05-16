package com.silverstone.basiskeledeneme

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

@Composable
fun PhoneCallButton(phoneNumber:String){
    val context= LocalContext.current

    Button(onClick = {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data= Uri.parse("tel:$phoneNumber")
        }
        context.startActivity(intent)
    },Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(Color.Cyan)) {
            Icon(imageVector = Icons.Filled.Call , contentDescription = "")
    }

}