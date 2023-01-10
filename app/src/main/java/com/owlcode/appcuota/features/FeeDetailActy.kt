package com.owlcode.appcuota.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.owlcode.appcuota.databinding.ActivityFeeDetailActyBinding
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