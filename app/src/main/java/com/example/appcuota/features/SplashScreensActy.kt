package com.example.appcuota.features

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.appcuota.databinding.ActivitySplashScreensBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashScreensActy : AppCompatActivity() {
    private lateinit var binding : ActivitySplashScreensBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreensBinding.inflate(layoutInflater)
        installSplashScreen().setKeepOnScreenCondition { false }
        setContentView(binding.root)
        val intent = Intent(this, LoginActy::class.java)
        startActivity(intent)
        finish()
    }
}
