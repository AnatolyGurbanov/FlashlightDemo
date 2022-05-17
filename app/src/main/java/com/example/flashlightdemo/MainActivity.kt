package com.example.flashlightdemo

import android.content.Context
import android.graphics.Color
import android.hardware.camera2.CameraManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var cameraManager: CameraManager
    private lateinit var powerButton: ImageButton
    var isFlash = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        powerButton = findViewById(R.id.button)
        powerButton.setBackgroundColor(Color.LTGRAY)

        cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        powerButton.setOnClickListener { flashLightOnRoOff(it) }
    }

    private fun flashLightOnRoOff(v: View?) {
        if (!isFlash) {
            val cameraListId = cameraManager.cameraIdList[0]
            cameraManager.setTorchMode(cameraListId,true)
            isFlash = true
            powerButton.setBackgroundColor(Color.GREEN)
            textMassge("Flash Light is On",this)
        } else {
            val cameraListId = cameraManager.cameraIdList[0]
            cameraManager.setTorchMode(cameraListId,false)
            isFlash = false
            powerButton.setBackgroundColor(Color.LTGRAY)
            textMassge("Flash Light is Off",this)
        }

    }

    private fun textMassge(s: String, c: Context) {
        Toast.makeText(c,s,Toast.LENGTH_SHORT).show()
    }
}