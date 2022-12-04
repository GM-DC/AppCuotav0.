package com.example.appcuota.features.updatepassword.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.appcuota.R
import com.example.appcuota.databinding.FragmentValidateCodeBinding
import com.example.appcuota.databinding.FragmentValidateDocIdentificationBinding
import com.example.appcuota.features.updatepassword.domain.model.DocIdentidad
import com.example.appcuota.utils.DataStoreGlobal.Companion.DOCIDENTIDAD
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ValidateDocIdentificationFrag : Fragment() {

    private var _binding: FragmentValidateDocIdentificationBinding? = null
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
        _binding = FragmentValidateDocIdentificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        eventsHandls()
    }

    private fun eventsHandls() {
        binding.btnEnviar.setOnClickListener { sendDocIdentification() }
    }

    private fun sendDocIdentification() {
        if (binding.etEnterDoc.text.toString().length>7){
            DOCIDENTIDAD = binding.etEnterDoc.text.toString()
            findNavController().navigate(R.id.action_validateDocIdentificationFrag_to_resetCodeFrag)
        }else{
            Toast.makeText(activity, "Documento Invalido", Toast.LENGTH_SHORT).show()
        }
    }

}