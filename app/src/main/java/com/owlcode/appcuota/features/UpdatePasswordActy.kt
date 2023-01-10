package com.owlcode.appcuota.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.owlcode.appcuota.databinding.ActivityUpdatePasswordBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdatePasswordActy : AppCompatActivity() {
    lateinit var binding: ActivityUpdatePasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdatePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}