package com.silverstone.basiskeledeneme

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.silverstone.basiskeledeneme.ui.theme.BasiskeleDenemeTheme

class MainActivity : ComponentActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {

        sharedPreferences = this.getSharedPreferences("com.silverstone.basiskeledeneme", Context.MODE_PRIVATE)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge(statusBarStyle = SystemBarStyle.auto(android.graphics.Color.TRANSPARENT,android.graphics.Color.TRANSPARENT))
        setContent {
     BasiskeleDenemeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val language= sharedPreferences.getString("selectedLanguage","tr").apply {  }


                 PageNavigations(sharedPreferences)
                    //SelectLanguage(sharedPreferences = sharedPreferences)
                }
            }
        }
    }
}


