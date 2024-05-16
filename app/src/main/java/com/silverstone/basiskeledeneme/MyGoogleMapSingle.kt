package com.silverstone.basiskeledeneme

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MyGoogleMapSingle(latitude:Double,longitude:Double,name:String){
    val context= LocalContext.current
    val location = LatLng(latitude, longitude)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(location, 15f)
    }
    GoogleMap(
        cameraPositionState = cameraPositionState
    ){
        Marker(
            state = MarkerState(location), title = "Bölge", snippet = "muthisbishi")
    }
}

