package com.owlcode.appcuota.features.login.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.owlcode.appcuota.R
import com.owlcode.appcuota.databinding.FragmentLoginBinding
import com.owlcode.appcuota.utils.DataStoreGlobal.Companion.DOCIDENTIDAD
import com.owlcode.appcuota.utils.DataStoreGlobal.Companion.NAMEUSER
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFrag : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            activity?.let {
                ViewModelProvider(it)[LoginViewModel::class.java]
            }!!
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle? ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        eventsHandlers()
        initLoginResult()
        messageState()
        getDataStore()
    }

    private fun initLoginResult() {
        viewModel.loginResult.observe(viewLifecycleOwner){
            if (it.flogin == 1){
                Toast.makeText(activity, "Cambiar Contraseña primera vez", Toast.LENGTH_SHORT).show()
                NAMEUSER = it.nombre
                viewModel.saveDataStore(DOCIDENTIDAD,it.nombre)
                findNavController().navigate(R.id.action_login_to_validateCodeFrag)
            }else{
                Toast.makeText(activity, "Ir detalle", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_login_to_feeDetailActy)
            }
        }
    }

    private fun eventsHandlers() {
        binding.btnIngresar.setOnClickListener { enterUser() }
        binding.tvRescuePassword.setOnClickListener { rescuePassword() }
    }

    private fun rescuePassword() {
        findNavController().navigate(R.id.action_login_to_updatePasswordActy)
    }

    private fun enterUser() {
        val user = binding.tvUser.text.toString()
        val password = binding.tvPass.text.toString()
        binding.tvPass.setText("")
        DOCIDENTIDAD = user
        viewModel.saveDataStore(user,"")
        viewModel.loginUser(user,password)
    }

    private fun messageState() {
        viewModel.message.observe(viewLifecycleOwner){ it ->
            Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
        }
    }

    private fun getDataStore(){
        viewModel.dataStore.observe(viewLifecycleOwner){
            if (it.dni.isNotBlank()){
                DOCIDENTIDAD = it.dni
                binding.tvUser.setText(it.dni)
            }
        }
    }

}