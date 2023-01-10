package com.owlcode.appcuota.features.updatepassword.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.owlcode.appcuota.R
import com.owlcode.appcuota.databinding.FragmentValidateCodeBinding
import com.owlcode.appcuota.utils.DataStoreGlobal.Companion.DOCIDENTIDAD
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ValidateCodeFrag : Fragment() {

    private var _binding: FragmentValidateCodeBinding? = null
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
        _binding = FragmentValidateCodeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        eventsHanlds()
        resendCode()
        sendCode()
    }

    private fun sendCode() {
        Toast.makeText(activity, "SE ENVIO EL CODIGO", Toast.LENGTH_SHORT).show()
        viewModel.sendCode(DOCIDENTIDAD)
    }

    private fun eventsHanlds() {
        binding.btnEnterCode.setOnClickListener { validateCode() }
    }

    private fun resendCode() {
        binding.tvReenviarCode.isEnabled = false
        CoroutineScope(Dispatchers.IO).launch{
            for (i in 90 downTo 1) {
                activity?.runOnUiThread{
                    binding.tvReenviarCode.text = "Reenviar codigo de verificación (${i}s)"
                }
                delay(1000)
            }
            activity?.runOnUiThread{
                binding.tvReenviarCode.text = "Reenviar codigo de verificación"
                binding.tvReenviarCode.isEnabled = true
                binding.tvReenviarCode.setOnClickListener { sendCode() }
            }
        }
    }

    private fun validateCode() {
        viewModel.valideCode(DOCIDENTIDAD,binding.etEnterCode.text.toString())
        resultCode()
    }

    private fun resultCode() {
        viewModel.isStateValidateCode.observe(viewLifecycleOwner){
            if (it){
                findNavController().navigate(R.id.action_resetCodeFrag_to_updatePasswordFrag)
            }else{
                Toast.makeText(activity, "Codigo Incorrecto", Toast.LENGTH_SHORT).show()
            }
        }
    }


}