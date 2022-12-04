package com.example.appcuota.features.updatepassword.presentation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.appcuota.R
import com.example.appcuota.databinding.FragmentFeeDetailBinding
import com.example.appcuota.databinding.FragmentUpdatePasswordBinding
import com.example.appcuota.features.LoginActy
import com.example.appcuota.features.login.presentation.LoginViewModel
import com.example.appcuota.utils.DataStoreGlobal.Companion.DOCIDENTIDAD

class UpdatePasswordFrag : Fragment() {

    private var _binding: FragmentUpdatePasswordBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: UpdatePasswordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            activity?.let {
                ViewModelProvider(it)[UpdatePasswordViewModel::class.java]
            }!!
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle? ): View {
        _binding = FragmentUpdatePasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        messageState()
        eventsHandlet()
        resultUpdatePassword()
    }

    private fun eventsHandlet() {
        binding.btnConfirmar.setOnClickListener { changePassword() }
    }

    private fun changePassword() {
        val docIdendidad = binding.tvDocIdentidad.text.toString()
        val newPassword = binding.tvNewPasscode.text.toString()
        val newPasswordRepirt = binding.tvNewPasscodeRepirt.text.toString()

        if (newPassword == newPasswordRepirt){
            viewModel.updatePassword(newPassword,docIdendidad)
        }else{
            Toast.makeText(activity, "La contraseña no coinciden", Toast.LENGTH_SHORT).show()
        }
    }

    private fun messageState() {
        viewModel.message.observe(viewLifecycleOwner){ it ->
            Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
        }
    }

    private fun resultUpdatePassword(){
        viewModel.loginResult.observe(viewLifecycleOwner){
            if (it){
                startActivity(Intent(activity, LoginActy::class.java))
            }
        }
    }

}