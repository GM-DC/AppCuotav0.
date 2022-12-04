package com.example.appcuota.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appcuota.databinding.ActivityFeeDetailActyBinding
import com.example.appcuota.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeeDetailActy : AppCompatActivity() {
    private lateinit var binding: ActivityFeeDetailActyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeeDetailActyBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}