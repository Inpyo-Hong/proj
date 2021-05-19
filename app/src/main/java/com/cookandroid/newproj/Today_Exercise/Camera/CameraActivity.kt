package com.cookandroid.newproj.Today_Exercise.Camera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.cookandroid.newproj.R

class CameraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        savedInstanceState ?: supportFragmentManager.beginTransaction()
            .replace(R.id.container, PosenetActivity())
            .commit()
    }
}