package com.maria.deliveryclub

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.maria.deliveryclub.databinding.ActivityMapsBinding
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKit
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraListener
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.map.CameraUpdateReason
import com.yandex.mapkit.map.Map
import com.yandex.mapkit.map.MapObjectCollection
import com.yandex.mapkit.map.PlacemarkMapObject
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.image.ImageProvider


class MapsActivity : AppCompatActivity(), CameraListener {
    private lateinit var binding: ActivityMapsBinding
    private val startLocation = Point(45.035470, 38.975313)
    private var zoomValue: Float = 10.5f
    private lateinit var mapObjectCollection: MapObjectCollection
    private lateinit var placemarkMapObject: PlacemarkMapObject

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setApiKey(savedInstanceState)
        MapKitFactory.initialize(this)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.mapview.map.addCameraListener(this)

        moveToStartLocation()
        setMarkerInStartLocation()

    }

    private fun setApiKey(savedInstanceState: Bundle?) {
        val haveApiKey = savedInstanceState?.getBoolean("haveApiKey") ?: false
        if (!haveApiKey) {
            MapKitFactory.setApiKey(MAPKIT_API_KEY)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("haveApiKey", true)
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        binding.mapview.onStart()
    }

    override fun onStop() {
        binding.mapview.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

    companion object {
        const val MAPKIT_API_KEY = "acabf37f-60b3-4afc-976f-215d547acab4"
        const val ZOOM_BOUNDARY = 16.4f
    }

    private fun moveToStartLocation() {
        binding.mapview.map.move(
            CameraPosition(startLocation, zoomValue, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 5f), // анимация при переходе на стартовую точку
            null

        )
    }

    private fun setMarkerInStartLocation() {
        val marker = R.drawable.ic_pin_black_png
        mapObjectCollection = binding.mapview.map.mapObjects
        placemarkMapObject = mapObjectCollection.addPlacemark(startLocation, ImageProvider.fromResource(this, marker))
        placemarkMapObject.opacity = 0.5f
        //placemarkMapObject.setText("Вы здесь!")
    }

    override fun onCameraPositionChanged(
        map: Map,
        cameraPosition: CameraPosition,
        cameraUpdateReason: CameraUpdateReason,
        finished: Boolean
    ) {}


}





