package com.example.cellularsignalstrengthfinder

import android.Manifest
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat


const val permissionCode = 200
val permissions: Array<String> = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.READ_PHONE_STATE)


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         requestPermissions()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.startForegroundService(Intent(this, SignalStrengthChange::class.java))
        } else {
            this.startService(Intent(this, SignalStrengthChange::class.java))
        }


    }
    private fun requestPermissions() {
        ActivityCompat.requestPermissions(
                this,
                permissions,
                permissionCode
        )
    }
}