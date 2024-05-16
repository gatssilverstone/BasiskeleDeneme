package com.silverstone.basiskeledeneme

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.Rect
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState



@Composable
fun MyGoogleMapMultiple(places:List<Places>){

    val context= LocalContext.current
    val userLocation=LatLng(40.71468719149089, 29.934638347181014)


   // val basiskeleLocation=LatLng(40.629931652056634, 29.950513770804207)
    val cameraPositionState = rememberCameraPositionState{
        position = CameraPosition.fromLatLngZoom(userLocation, 12f)}

    GoogleMap(
        cameraPositionState = cameraPositionState
    ){

        places.forEach{place ->
            val bitmap = BitmapFactory.decodeResource(context.resources,place.image)
            val resizedImage= Bitmap.createScaledBitmap(bitmap,150,150,false)
            val circularBitmap= getCircularBitmap(resizedImage)
            val framedBitmap= addFrameToBitmap(circularBitmap,10, Color.YELLOW)
            val descriptor=BitmapDescriptorFactory.fromBitmap(framedBitmap)
            val location=LatLng(place.latitude.toDouble(),place.longitude.toDouble())
            Marker(state = MarkerState(location), title = place.name, snippet = place.description, icon = descriptor)
        }
        val userBitmap=BitmapFactory.decodeResource(context.resources, R.drawable.personpin)
        val resizedPersonBitmap= Bitmap.createScaledBitmap(userBitmap,150,150,false)
        val personDescriptor=BitmapDescriptorFactory.fromBitmap(resizedPersonBitmap)
        Marker(state = MarkerState(userLocation), icon = personDescriptor)
    }
}

fun getCircularBitmap(bitmap: Bitmap): Bitmap {
    val width = bitmap.width
    val height = bitmap.height
    val output = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(output)
    val paint = Paint()
    val rect = Rect(0, 0, width, height)
    val radius = Math.min(width, height) / 2f

    paint.isAntiAlias = true
    canvas.drawARGB(0, 0, 0, 0)
    canvas.drawCircle(width / 2f, height / 2f, radius, paint)
    paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
    canvas.drawBitmap(bitmap, rect, rect, paint)
    return output
}

fun addFrameToBitmap(bitmap: Bitmap, frameSize: Int, frameColor: Int): Bitmap {
    val radius = Math.min(bitmap.width, bitmap.height) / 2f
    val output = Bitmap.createBitmap(
        bitmap.width + frameSize * 2,
        bitmap.height + frameSize * 2,
        Bitmap.Config.ARGB_8888
    )
    val canvas = Canvas(output)
    val paint = Paint()
    paint.color = frameColor
    paint.style = Paint.Style.STROKE
    paint.strokeWidth = frameSize.toFloat()
    paint.isAntiAlias = true

    canvas.drawCircle(
        bitmap.width / 2f + frameSize,
        bitmap.height / 2f + frameSize,
        radius + frameSize / 2f,
        paint
    )

    canvas.drawBitmap(bitmap, frameSize.toFloat(), frameSize.toFloat(), null)
    return output
}