package com.example.appcuota.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.appcuota.databinding.ActivityLoginBinding
import com.example.appcuota.databinding.ActivitySplashScreensBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActy : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}